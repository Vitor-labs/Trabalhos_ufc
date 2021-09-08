#include <iostream>
#include <list>
#include <stack>
#include <queue>

using namespace std;

class Grafo
{
private:
    int vertices;
    list<int> *adj; //ponteiro -> vetor com as lista de Adjacência

public:
    Grafo(int v)
    {
        this->vertices = v;
        adj = new list<int>[v];
    }

    void adAresta(int v1, int v2)
    {
        adj[v1].push_back(v2);
    }

    /*Busca em Profundidade iterativa
    -> Usada para verificar conectividades*/
    void dsf(int v)
    {
        stack<int> pilha;
        bool visited[vertices];

        for (int i = 0; i < vertices; i++)
        {
            visited[i] = false;
        }

        while (true)
        {
            bool achado = false;
            list<int>::iterator it = adj[v].begin();

            if (!visited[v])
            {
                cout << "Vertice Atual: " << v << endl;
                visited[v] = true;
                pilha.push(v); // insere o vertice na pilha
            }

            for (it; it != adj[v].end(); it++)
            {
                if (!visited[*it])
                {
                    achado = true;
                    break;
                }
            }
            if (achado)
            {
                v = *it;
            }
            else
            {
                pilha.pop();
                if (pilha.empty())
                {
                    break;
                }
                v = pilha.top();
            }
        }
    }

    /*Busca em Largura*/
    void bsf(int v)
    {
        queue<int> fila;

        bool visited[vertices];
        for (int i = 0; i < vertices; i++)
        {
            visited[i] = false;
        }
        cout << "Vertice atual: " << v << endl;
        visited[v] = true;

        while (true)
        {
            list<int>::iterator iter = adj[v].begin();
            for (iter; iter != adj[v].end(); iter++)
            {
                if (!visited[*iter])
                {
                    cout << "Vertice Atual: " << *iter << endl;
                    visited[*iter] = true;
                    fila.push(*iter);
                }
            }
            if (!fila.empty())
            {
                v = fila.front();
                fila.pop();
            }
            else
            {
                break;
            }
        }
    }
};

int main(int argc, char const *argv[])
{
    Grafo graf(8);

    int matrizAdjacencia[4][4];

    graf.adAresta(0, 1);
    graf.adAresta(0, 2);
    graf.adAresta(1, 3);
    graf.adAresta(1, 4);
    graf.adAresta(2, 5);
    graf.adAresta(2, 6);
    graf.adAresta(6, 7);

    cout << "DSF" << endl;
    graf.dsf(0);
    cout << endl;

    cout << "BSF" << endl;
    graf.bsf(0);
    cout << endl;

    return 0;
}
