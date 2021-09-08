#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

/*VITOR HUGO - 496348*/

template <typename U>
struct No
{
public:
    No *esquerda, *direita;
    U valor;

    No(U valor)
    {
        this->valor = valor;
        this->esquerda = direita = 0;
    }
};

template <typename T>
struct Arvore
{
private:
    No<T> *root;

    No<T> *__add__(No<T> *no, T valor)
    {
        if (no == 0)
        {
            return new No<T>(valor);
        }
        if (no->valor >= valor)
        {
            no->esquerda = __add__(no->esquerda, valor);
        }
        else
        {
            no->direita = __add__(no->direita, valor);
        }
        return no;
    }

    void _print_(No<T> *base, int i = 0)
    {
        if (base)
        {
            i += 8;
            _print_(base->direita, i);

            cout << endl;
            for (int x = 4; x < i; x++)
                cout << " ";
            cout << base->valor << endl;

            _print_(base->esquerda, i);
        }
    }

    No<T> *__pesquisa__(No<T> *No, T valor)
    {
        if (No != 0)
        {
            if (No->valor == valor)
                return No;
            else if (No->valor < valor)
            {
                return __pesquisa__(No->direita, valor);
            }
            else
            {
                return __pesquisa__(No->esquerda, valor);
            }
        }

        return 0;
    }

public:
    Arvore()
    {
        this->root = 0;
    }

    void add(T valor)
    {
        this->root = __add__(this->root, valor);
    }

    void print()
    {
        _print_(this->root);
    }

    No<T> *search(T valor)
    {
        return __pesquisa__(this->root, valor);
        cout << endl;
    }
};

int main(int argc, char **argv)
{ // APP 2
    Arvore<string> *barvore = new Arvore<string>();

    ifstream portuga; // adicinando palavras ao corretor
    portuga.open("SDK\\portugues~.txt", ios::in);
    if (portuga.is_open())
    {
        string palavra;
        while (getline(portuga, palavra))
        {
            barvore->add(palavra);
        }
    }
    portuga.close();

    ifstream input; // compara palavras que não existem na arvore
    string fileIN = "SDK\\";
    fileIN += argv[1];
    input.open(fileIN, ios::in);
    if (input.is_open())
    {
        string line;
        ofstream output; // adiciona palavras inexistentes
        string file = "SDK\\";
        file += argv[2];
        output.open(file, ios::out);

        while (getline(input, line)) // lê inputs
        {
            if (barvore->search(line) == 0) // caso a palavra não exista
            {
                output << line << "\n";
            }
        }
        output.close();
    }
    input.close();

    return 0;
}