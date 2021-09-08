#include <iostream>
#include <queue>

using namespace std;

/*Nas filas de prioridade, só se consegue alterar o começo da fila, não 
existem os metodos pop_front e pop_back, apenas pop, o mesmo como o push,
fora isso é igual a uma fila comum*/

int main(int argc, char const *argv[])
{
    priority_queue<int> fila;

    fila.push(10);
    fila.push(15);
    fila.push(20);
    fila.push(30);
    fila.push(5);
    fila.push(1);
    fila.push(25);

    cout << fila.size() << endl;

    while (!fila.empty())
    {
        cout << fila.top() << " ";
        fila.pop();
    }

    cout << fila.size() << endl;

    //FILA COM PRIORIDADE INVERTIDA
    priority_queue<int, vector<int>, greater<int>> fila2;

    fila2.push(10);
    fila2.push(15);
    fila2.push(20);
    fila2.push(30);
    fila2.push(5);
    fila2.push(1);
    fila2.push(25);

    cout << fila2.size() << endl;

    while (!fila2.empty())
    {
        cout << fila2.top() << " ";
        fila2.pop();
    }

    cout << fila2.size() << endl;

    return 0;
}
