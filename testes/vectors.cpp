#include <iostream>
#include <vector>

// vector são recomendados para dados que
// irão mudar pouco ao longo do tempo, já
// que retirar um certo dado é custoso.

// vectors pré-alocam espaço para elementos
// futuros, mas sem espaço adicional além do
// tipo do vector.

// armazena elementos em locais de memória
// contíguos, como uma matriz. Portanto, no
// vetor o acesso aleatório é possível.

using namespace std;

class ponto
{
public:
    int x, y;

    ponto(int x, int y)
    {
        this->x = x;
        this->y = y;
    }
};
int main(int argc, char const *argv[])
{
    /*vector<int> vet(5);

    for (int i = 0; i < vet.size(); i++){
        vet[i] = i + 10;}

    if (vet.empty()){
        cout << "vetor vazio" << endl;}
    else{
        cout << "vetor com elementos: " << endl;}

    vector<int>::iterator it;

    for (it = vet.begin(); it != vet.end(); it++){
        cout << vet.at(*it) << endl;}
    
    cout << endl << "Ultimo inserido: "<< vet.back() << endl;
    cout << "Primeiro inserido: " << vet.front() << endl;

    cout << endl;

    cout << "Primeiro Elemento: " << *vet.begin() << endl;
    cout << "Ultimo Elemento: " << *(--vet.end()) << endl;

    vet.pop_back();
    vet.insert(vet.begin(), 40);
    
    cout << "Primeiro Elemento: " << *vet.begin() << endl;
    cout << "Ultimo Elemento: " << *(--vet.end()) << endl;

    cout << endl;

    vector<int>::reverse_iterator revit;

    cout << "Revertido" << endl;
    for (revit = vet.rbegin(); revit != vet.rend(); revit++){
        cout << *revit << endl;}

    vet.pop_back();
    cout << "Ultimo Elemento: " << *(--vet.end()) << endl;*/

    vector<ponto *> vet;
    vector<ponto *>::iterator iter;

    ponto *p1 = new ponto(1, 2);
    ponto *p2 = new ponto(3, 4);
    ponto *p3 = new ponto(5, 6);
    ponto *p4 = new ponto(7, 8);
    ponto *p5 = new ponto(9, 0);

    vet.push_back(p1);
    vet.push_back(p2);
    vet.push_back(p3);
    vet.push_back(p4);
    vet.push_back(p5);

    for (iter = vet.begin(); iter != vet.end(); iter++)
    {
        cout << (*iter)->x << " " << (*iter)->y << endl;
    }

    return 0;
}