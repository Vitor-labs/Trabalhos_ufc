#include <iostream>
#include <list>
#include <stack>

using namespace std;

class Grafo
{
private:
    int vertices; //
    list<int> *adj;

public:
    Grafo(int V)
    {
        this->vertices = V;
        adj = new list<int>[V];
    }

    void adAresta(int v1, int v2)
    {
        adj[v1].push_back(v2);
    }

    bool dfs(int V)
    {
        stack<int> pilha;
        bool visitados[V], pilha_rec[V];
        for (int i = 0; i < V; i++)
        {
            visitados[i] = pilha_rec[i] = false;
        }

        while (true)
        {
            bool temProximo = false;
            list<int>::iterator iter = adj[V].begin();

            if (!visitados[V])
            {
                pilha.push(V);
                visitados[V] = pilha_rec[V] = true;
            }

            for (iter; iter != adj[V].end(); iter++)
            {
                if (pilha_rec[*iter])
                {
                    return true;
                }
                else if (!visitados[*iter])
                {
                    temProximo = true;
                    break;
                }
            }

            if (temProximo)
            {
                pilha_rec[pilha.top()] = false;
                pilha.pop();
                if (pilha.empty())
                {
                    break;
                }
                V = pilha.top();
            }
            else
            {
                V = *iter;
            }
        }
        return false;
    }

    bool temCiclo()
    {
        for (int i = 0; i < vertices; i++)
        {
            if (dfs(i))
            {
                return true;
            }
            return false;
        }
    }
};

int main(int argc, char const *argv[])
{
    Grafo graf(4);

    graf.adAresta(0, 1);
    graf.adAresta(0, 2);
    graf.adAresta(1, 3);
    graf.adAresta(3, 0);

    if (graf.temCiclo())
    {
        cout << "Grafo com ciclo" << endl;
    }

    return 0;
}
