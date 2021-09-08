#include <iostream>
#include <string.h>
#include <stdlib.h>

using namespace std;
/* O algoritmo Union-Find que detecta ciclos em grafos não direcionados.

*Logica:
    > O algoritmo busca uniões, ou ciclos
    > Como o nome diz, é a união das funções união e busca
    > Find: É feita uma busca pelo subconjunto de um elemento 'x',
      determinando-o
      Find(vetor, vertice)
          se (vetor[vertice] == -1)
              retorne vertice
          retorne Find(vetor, vetor[vertice])
    > Union: Junta 2 subconjuntos, se(vertice1 == vertice2), não há ciclo, 
      logo a aresta pertence a arvore geradora minima
      Union(vetor, vertice1, vertice2)
          set1 = find(vetor, vertice1)
          set2 = find(vetor, vertice2)
          vetor[set1] = set2        

*Exemplo:
    > Dado um grafo com 'v' vertices.
    > Temos um vetor[v], inicializado com -1. [1, 2, 3] -> [-1, -1, -1]
    > Percorre todas as arrestas do grafo, guardando o retorno da 
      função find. Aresta[1][2] -> vertice = find(vetor, vertice)
    > se os vetices fores diferentes, une-se os vertices*/

// busca o subconjunto de um elemento "v"
int buscar(int subset[], int v)
{
    if (subset[v] == -1)
        return v;
    return buscar(subset, subset[v]);
}

// une dois subconjuntos
void unir(int subset[], int v1, int v2)
{
    int v1_set = buscar(subset, v1);
    int v2_set = buscar(subset, v2);

    subset[v1_set] = v2_set;
}

bool tem_ciclo(int grafo[3][3])
{
    int *subset = (int *)malloc(3 * sizeof(int));

    // inicializa todos os subconjuntos como conjuntos de um único elemento
    memset(subset, -1, sizeof(int) * 3);

    for (int i = 0; i < 3; i++)
    {
        for (int j = i; j < 3; j++)
        {
            if (grafo[i][j] == 1)
            {
                int v1 = buscar(subset, i);
                int v2 = buscar(subset, j);

                if (v1 == v2)
                    return true;
                else
                    unir(subset, v1, v2);
            }
        }
    }

    return false;
}

int main(int argc, char *argv[])
{
    int grafo[3][3] = {{0, 1, 1}, {1, 0, 0}, {1, 0, 0}};

    cout << "Grafo ciclico: " << boolalpha << tem_ciclo(grafo);

    return 0;
}