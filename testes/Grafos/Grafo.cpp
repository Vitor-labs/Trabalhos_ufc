#include <iostream>
#include <list>
#include <algorithm>

using namespace std;
/*  Matriz de Adjacência: O(n)^2 -> É mais rápida para detectar a 
    existencia de alguma aresta
    
    int grafo[5][5]{
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 1, 0, 1},
        {0, 0, 1, 1, 0}};

    Lista de Adjacência: Proporcional ao numero de arestas.
    -> recomendada para grafos com poucas arestas em relação ao numero de 
    vertices, mas é mais lenta para verificar a existencia de uma aresta 
    int lista[25];*/
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

    int getVertices()
    {
        return this->vertices;
    }

    void adAresta(int v1, int v2)
    {
        adj[v1].push_back(v2);
    }

    int grauSaida(int v)
    {
        return adj[v].size();
    }

    bool ehVizinho(int v1, int v2)
    {
        if (find(adj[v1].begin(), adj[v1].end(), v2) != adj[v1].end())
        {
            return true;
        }
        return false;
    }
};

bool ehLigado(int grafo[4][4], int v1, int v2)
{
    if (grafo[v1][v2])
    {
        return true;
    }
    return false;
}

void printaMatriz(int matriz[][4], int tam)
{
    char lin[4] = {'A', 'B', 'C', 'D'};
    cout << endl
         << "   A B C D " << endl
         << "+---------+" << endl;
    for (int i = 0; i < tam; i++)
    {
        cout << lin[i] << "|";
        for (int j = 0; j < tam; j++)
        {
            cout << " " << matriz[i][j];
        }
        cout << "|" << endl;
        cout << "+---------+" << endl;
    }
}

int main(int argc, char const *argv[])
{
    Grafo graf(4);

    int matrizAdjacencia[4][4];

    graf.adAresta(0, 1);
    graf.adAresta(0, 3);
    graf.adAresta(1, 2);
    graf.adAresta(3, 1);
    graf.adAresta(3, 2);

    for (int i = 0; i < graf.getVertices(); i++)
    {
        cout << "Grau de saida de " << i << ": " << graf.grauSaida(i) << endl;

        for (int j = 0; j < graf.getVertices(); j++)
        {
            if (graf.ehVizinho(i, j))
            {
                cout << "\t" << i << " e vizinho de " << j << endl;
            }
            matrizAdjacencia[i][j] = graf.ehVizinho(i, j);
        }
        cout << endl;
    }

    printaMatriz(matrizAdjacencia, graf.getVertices());

    return 0;
}
