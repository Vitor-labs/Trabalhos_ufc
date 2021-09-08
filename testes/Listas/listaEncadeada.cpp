#include <iostream>

using namespace std;

template <typename T>
struct Node
{
private:
    T valor;
    Node *prox;

public:
    Node(T valor)
    {
        this->valor = valor;
        this->prox = NULL;
    }

    int getValor()
    {
        return this->valor;
    }

    Node *proxNo()
    {
        return this->prox;
    }

    void setProx(Node *proxNo)
    {
        prox = proxNo;
    }
};

template <typename T>
class Lista
{
private:
    Node<T> *cabeca;
    Node<T> *pe;

public:
    Lista()
    {
        cabeca = NULL;
        pe = NULL;
    }

    Lista(int valor)
    {
        cabeca = new Node<T>(valor);
        pe = cabeca;
    }

    virtual ~Lista()
    {
        delete cabeca;
    }

    bool isEmpty()
    {
        return (pe == NULL);
    }

    void mostrar()
    {
        Node<T> *cab = cabeca;
        if (isEmpty())
        {
            cout << "Empty" << endl;
        }
        else
        {
            while (cab)
            {
                cout << cab->getValor() << " ";
                cab = cab->proxNo();
            }
            cout << endl;
        }
    }

    void insereInicio(T valor)
    {
        Node<T> *novoNode = new Node<T>(valor);
        novoNode->setProx(cabeca);
        cabeca = novoNode;
    }

    void insereFinal(int valor)
    {
        Node<T> *novoNode = new Node<T>(valor);
        if (isEmpty())
        {
            cabeca = novoNode;
            pe = novoNode;
        }
        else
        {
            pe->setProx(novoNode);
            pe = novoNode;
        }
    }

    int tamanho()
    {
        if (isEmpty)
        {
            return 0;
        }

        Node<T> *cab = cabeca;
        int tamanho = 0;

        do
        {
            cab = cab->proxNo();
            tamanho++;

        } while (cab);
    }

    bool isThere(T valor)
    {
        Node<T> *cab = cabeca;

        while (cab)
        {
            if (cab->getValor() == (T)valor)
            {
                return true;
            }
            cab = cab->proxNo();
        }
        return false;
    }

    void remover()
    {
        if (!isEmpty())
        {
            if (cabeca->proxNo() == NULL)
            {
                cabeca = NULL;
            }
            else if (cabeca->proxNo()->proxNo() == NULL)
            {
                cabeca->setProx(NULL);
            }
            else
            {
                Node<T> *nodeAnteAnt = cabeca;
                Node<T> *nodeAnte = cabeca->proxNo();
                Node<T> *atual = cabeca->proxNo()->proxNo();

                while (atual)
                {
                    Node<T> *nodeAux = nodeAnte;
                    nodeAnte = atual;
                    nodeAnteAnt = nodeAux;
                    atual = atual->proxNo();
                }
                delete nodeAnteAnt->proxNo();
                nodeAnteAnt->setProx(NULL);
                pe = nodeAnteAnt;
            }
        }
    }
};

int main(int argc, char const *argv[])
{
    Lista<int> list;

    list.insereFinal(1);
    list.insereFinal(2);
    list.insereFinal(3);
    list.insereFinal(4);

    list.mostrar();
    if (list.isThere(5))
        cout << "True";

    list.insereInicio(5);
    list.insereInicio(6);
    list.insereInicio(7);
    list.insereInicio(8);

    list.mostrar();
    if (list.isThere(5))
        cout << "True";

    return 0;
}
