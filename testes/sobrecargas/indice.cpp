#include <iostream>

using namespace std;

// sobrecarga do operador de índice '[]'

class Vetor
{
private:
    int *vet, *vetpos;
    int max;

public:
    Vetor(int max = 100)
    {
        if (max < 0)
        {
            cerr << "Vetor menor que 0";
            exit(1);
        }
        else if (max > 10000)
        {
            cerr << "Vetor maior que 10000";
            exit(1);
        }
        this->max = max;
        vet = (int *)malloc(max * sizeof(int));
        vetpos = (int *)malloc(max * sizeof(int));

        for (int i = 0; i < max; i++)
        {
            vet[i] = 0;
        }
    }

    ~Vetor()
    {
        delete[] vet;
    }

    bool inserir(int e, int pos)
    {
        if (pos < max && pos >= 0)
        {
            vet[pos] = e;
            vetpos[pos] = 1;
            return true;
        }
        return false;
    }
    int &operator[](int i)
    {
        if (i < 0 || i >= max)
        {
            cerr << "Acesso invalido";
            exit(1);
        }
        else if (vetpos[i] == 0)
        {
            cerr << "Não há elemento" << endl;
            exit(1);
        }
        return vet[i];
    }

    int tam()
    {
        int count = 0;

        for (int i = 0; i < max; i++)
        {
            if (vetpos[i] == 1)
            {
                count++;
            }
        }
        return count;
    }
};

int main(int argc, char const *argv[])
{
    Vetor ve(10);

    if (ve.inserir(10, 0))
    {
        cout << "Inserido" << endl;
    }
    else
    {
        cerr << "Não Inserido" << endl;
    }
    if (ve.inserir(11, 1))
    {
        cout << "Inserido";
    }
    else
    {
        cerr << "Não Inserido" << endl;
    }
    if (ve.inserir(100, 2))
    {
        cout << "Inserido" << endl;
    }
    else
    {
        cerr << "Não Inserido" << endl;
    }
    if (ve.inserir(101, 3))
    {
        cout << "Inserido" << endl;
    }
    else
    {
        cerr << "Não Inserido" << endl;
    }
    if (ve.inserir(111, 4))
    {
        cout << "Inserido" << endl;
    }
    else
    {
        cerr << "Não Inserido" << endl;
    }

    for (int i = 0; i <= 5; i++)
    {
        cout << ve[i] << " ";
    }

    return 0;
}
