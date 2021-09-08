#include <iostream>
#include <vector>
#include <algorithm> // sort
#include <string.h>	 // memset

using namespace std;

/*O algoritmo de Kruskal é um algoritmo em teoria dos grafos que busca uma 
árvore geradora mínima para um grafo conexo com pesos. Isto significa que 
ele encontra um subconjunto das arestas que forma uma árvore que inclui 
todos os vértices, onde o peso total, dado pela soma dos pesos das arestas 
da árvore, é minimizado.*/

class Aresta
{
	int vertice1, vertice2, peso;

public:
	Aresta(int v1, int v2, int peso)
	{
		vertice1 = v1;
		vertice2 = v2;
		this->peso = peso;
	}

	int getVertice1()
	{
		return vertice1;
	}

	int getVertice2()
	{
		return vertice2;
	}

	int getPeso()
	{
		return peso;
	}

	// sobrescrita do operador "<"
	bool operator<(const Aresta &aresta2) const
	{
		return (peso < aresta2.peso);
	}
};

class Grafo
{
	int vertices;
	vector<Aresta> arestas;

public:
	Grafo(int vertices)
	{
		this->vertices = vertices;
	}

	void adicionarAresta(int v1, int v2, int peso)
	{
		Aresta aresta(v1, v2, peso);
		arestas.push_back(aresta);
	}

	// busca o subconjunto de um elemento "e"
	int buscar(int subset[], int e)
	{
		if (subset[e] == -1)
			return e;
		return buscar(subset, subset[e]);
	}

	// une dois subconjuntos em um único subconjunto
	void unir(int subset[], int v1, int v2)
	{
		int v1_set = buscar(subset, v1);
		int v2_set = buscar(subset, v2);
		subset[v1_set] = v2_set;
	}

	void kruskal()
	{
		vector<Aresta> arvore;
		int size_arestas = arestas.size();

		// ordena as arestas pelo menor peso
		sort(arestas.begin(), arestas.end());

		// aloca memória para criar "vertices" subconjuntos
		int *subset = new int[vertices];

		// inicializa todos os subconjuntos como conjuntos de um único elemento
		memset(subset, -1, sizeof(int) * vertices);

		for (int i = 0; i < size_arestas; i++)
		{
			int v1 = buscar(subset, arestas[i].getVertice1());
			int v2 = buscar(subset, arestas[i].getVertice2());

			if (v1 != v2)
			{
				// se forem diferentes, não forma ciclo, então insere no vetor
				arvore.push_back(arestas[i]);
				unir(subset, v1, v2); // faz a união
			}
		}

		int size_arvore = arvore.size();

		// mostra as arestas selecionadas com seus respectivos pesos
		for (int i = 0; i < size_arvore; i++)
		{
			char v1 = 'A' + arvore[i].getVertice1();
			char v2 = 'A' + arvore[i].getVertice2();
			cout << "(" << v1 << ", " << v2 << ") = " << arvore[i].getPeso() << endl;
		}
	}
};

int main(int argc, char *argv[])
{
	Grafo g(7);

	g.adicionarAresta(0, 1, 7);
	g.adicionarAresta(0, 3, 5);
	g.adicionarAresta(1, 2, 8);
	g.adicionarAresta(1, 3, 9);
	g.adicionarAresta(1, 4, 7);
	g.adicionarAresta(2, 4, 5);
	g.adicionarAresta(3, 4, 15);
	g.adicionarAresta(3, 5, 6);
	g.adicionarAresta(4, 5, 8);
	g.adicionarAresta(4, 6, 9);
	g.adicionarAresta(5, 6, 11);

	g.kruskal();

	return 0;
}