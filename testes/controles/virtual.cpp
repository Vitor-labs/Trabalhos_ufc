#include <iostream>

using namespace std;
/*Funções virtuais são funções de membro cujo comportamento pode ser 
substituído em classes derivadas. Ao contrário das funções não virtuais, o 
comportamento substituído é preservado mesmo se não houver informações de 
tempo de compilação sobre o tipo real da classe. Se uma classe derivada for
tratada usando um ponteiro ou referência à classe base, uma chamada para
uma função virtual substituída invocaria o comportamento definido na classe
derivada. Esse comportamento é suprimido se a função for selecionada usando
pesquisa de nome qualificado, ou seja, se o nome da função aparecer à
direita do operador de resolução de escopo '::'*/
struct Base
{
    virtual void f()
    {
        cout << "base\n";
    }
};
struct Derivado : Base
{
    void f() override
    { // 'override' é opcional
        cout << "derivado\n";
    }
};
int main()
{
    Base b;
    Derivado d;

    Base &br = b;
    Base &dr = d;
    br.f(); // printa "base"
    dr.f(); // printa "derivado"

    Base *bp = &b;
    Base *dp = &d;
    bp->f(); // printa "base"
    dp->f(); // printa "derivado"

    br.Base::f();    // printa "base"
    dr.Base::f();    // printa "base"
    d.Derivado::f(); // printa "derivado"
}