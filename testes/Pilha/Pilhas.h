#include <iostream>

using namespace std;

template <class classType>
class Pilhas
{
private:
    classType *vet;
    int max_size;
    int top;

public:
    Pilhas(int tam)
    {
        vet = new classType[tam];
        max_size = tam - 1;
        top = -1;
    };

    ~Pilhas()
    {
        delete[] vet;
    };

    void empilhar(classType e)
    {
        if (top == max_size)
        {
            cout << "Pilha Cheia" << endl;
        }
        else
        {
            vet[++top] = e;
        }
    }
    void desempilhar()
    {
        if (top == -1)
        {
            cout << "Pilha Vazia" << endl;
        }
        else
        {
            top--;
        }
    }
    classType get_top()
    {
        if (top != -1)
        {
            return vet[top];
        }
        else
        {
            cout << "Pilha Vazia | ";
            return NULL;
        }
    }
    void vazia()
    {
        if (top == -1)
        {
            cout << "Vazia " << endl;
        }
        else
        {
            cout << "com Elementos " << endl;
        }
    }
};