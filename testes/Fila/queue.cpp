#include <iostream>
#include <queue>

using namespace std;

// inplementação de filas do c++ com a class queue

int main(int argc, char const *argv[])
{
    queue<int> fila;

    for (int i = 0; i < 10; i++)
    {
        fila.push(i);
    }

    cout << fila.size() << endl;

    for (int i = 0; i < 10; i++)
    {
        fila.pop(); // remove o elemento do inicio.
    }

    cout << fila.size() << endl;

    return 0;
}
