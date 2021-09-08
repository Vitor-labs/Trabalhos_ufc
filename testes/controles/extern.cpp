#include <iostream>

using namespace std;

/*o termo 'extern' é usado para declarar funções ou variaveis externas, ela 
serve para ampliar a visibilidade da função ou variavel em que foi usada*/

extern int var = 10;
extern int var2;
// quando se define uma variavel var, deve-se por um valor

extern void print() // por padrão toda funçao é declarada como extern
{
    var2 = 20; // o valor também pode ser atribuido depois;
    cout << var << endl;
}