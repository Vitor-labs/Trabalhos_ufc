#include <iostream>

using namespace std;

class Node
{
private:
    Node *esq, *dir;
    int chave;

public:
    Node(int chave)
    {
        this->chave = chave;
        esq = dir = NULL;
    }

    int getChave() { return chave; }
    Node *getEsq() { return esq; }
    Node *getDir() { return dir; }

    void setchave(int chave) { this->chave = chave; }
    void setEsq(Node *esq) { this->esq = esq; }
    void setDir(Node *dir) { this->dir = dir; }
};

class ArvoreBinaria
{
private:
    Node *root;

public:
    void arvoreBinaria()
    {
        root = NULL;
    }

    Node *getRoot() { return root; }

    void insere(int chave)
    {
        if (root == NULL)
        {
            root = new Node(chave);
        }
        else
        {
            insereAux(root, chave);
        }
    }

    void insereAux(Node *node, int chave)
    {
        if (chave < node->getChave())
        {
            if (node->getEsq() == NULL)
            {
                Node *aux = new Node(chave);
                node->setEsq(aux);
            }
            else
            {
                insereAux(node->getEsq(), chave);
            }
        }
        else if (chave > node->getChave())
        {
            if (node->getDir() == NULL)
            {
                Node *aux = new Node(chave);
                node->setDir(aux);
            }
            else
            {
                insereAux(node->getDir(), chave);
            }
        }
    }

    void ordena(Node *node)
    {
        if (node == NULL)
        {
            ordena(node->getEsq());
            cout << node->getChave() << " ";
            ordena(node->getDir());
        }
    }

    int main(int argc, char const *argv[])
    {

        return 0;
    }
};