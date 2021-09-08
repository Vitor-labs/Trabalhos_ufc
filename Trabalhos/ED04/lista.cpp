#include <iostream>
/*Vitor Hugo Diogenes
  S.I - T04 - 496348*/
using namespace std;

template <class C>
struct nodo
{
    C key;
    nodo<C> *next;
    nodo(C x)
    {
        key = x;
        next = 0;
    }
};

template <class T>
class lsord
{
private:
    nodo<T> *ptraiz;
    void __rev__(nodo<T> *p, nodo<T> *ant = NULL) //*ant = NODO PREVIO
    {
        if (p == NULL)
        {
            return;
        }

        if (p->next == NULL)
        {
            this->ptraiz = p;
            return;
        }

        __rev__(p->next);
        p->next->next = p;
        p->next = NULL;
    }

public:
    lsord()
    {
        this->ptraiz = 0;
    }

    // Para testes
    void print()
    {
        nodo<T> *current = this->ptraiz;
        cout << current->key;
        while (current->next)
        {
            current = current->next;
            cout << " - " << current->key;
        }
        cout << endl;
    }
    // -----------

    void add(T x)
    {
        nodo<T> *p = new nodo<T>(x);
        if (this->ptraiz == 0)
            this->ptraiz = p;
        else if (x < this->ptraiz->key)
        {
            p->next = this->ptraiz;
            this->ptraiz = p;
        }
        else
        {
            nodo<T> *q = this->ptraiz;
            while (q->next != 0 && q->next->key < x)
                q = q->next;
            if (q->next == 0)
                q->next = p;
            else if (q->next != 0)
            {
                nodo<T> *p = q->next;
                nodo<T> *r = new nodo<T>(x);
                r->next = p;
                q->next = r;
            }
        }
    }
    void del(T x)
    {
        if (this->ptraiz == 0)
            return;
        else if (x == this->ptraiz->key)
        {
            nodo<T> *p = this->ptraiz->next;
            this->ptraiz = p->next;
            delete p;
        }
    }

    void rev()
    {
        this->__rev__(this->ptraiz);
    }
};

int main()
{
    lsord<int> list;

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.rev();
    cout << endl;
    list.print();
}