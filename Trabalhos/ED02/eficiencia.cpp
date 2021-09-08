#include <iostream>
#include <stdlib.h>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <direct.h>

#define MAX 100

using namespace std;

int contaQuick = 0;
int interations[MAX];

void printArr(int *arr, int n)
{
    cout << "[ ";
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout
        << "]" << endl;
}

void criarVetor(int vetor[], int tamanhoVetor)
{
    for (int i = 0; i < tamanhoVetor; i++)
        vetor[i] = rand() % tamanhoVetor;
}

void copiaVetor(int vetorEntrada[], int vetorSaida[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
        vetorSaida[i] = vetorEntrada[i];
}

int insertionSort(int *vetor, int posisao, int tamanho)
{
    int contador = 0;
    for (int i = posisao + 1; i < tamanho + posisao; i++)
    {
        int chave = vetor[i];
        int j = i - 1;

        /*Move elementos do vetor[posição -> i-1], que são maiores que a 
        chave, para uma posição afrente da posição atual deles*/
        while (j >= 0 && vetor[j] > chave)
        {
            vetor[j + 1] = vetor[j];
            --j;
            contador++;
        }
        vetor[j + 1] = chave;
    } //zera-se o contador para a proxima interação.
    return contador;
}

void bubbleSort(int vetor[], int teto)
{ //Ordena até bater no teto
    int aux, k, tamanhoBolha, contador = 0;

    string name_file = "SDK\\interasoes.txt";
    ofstream ordenaMista(name_file, ofstream::out | ofstream::trunc);
    for (tamanhoBolha = 2; tamanhoBolha <= MAX; tamanhoBolha++)
    {
        int vetorAux[MAX];
        copiaVetor(vetor, vetorAux, MAX);

        int intera = 0;
        while (true)
        {
            for (int i = 0; i < teto - tamanhoBolha + 1; i++)
            {
                intera += insertionSort(vetorAux, i, tamanhoBolha);
            }
            bool foiordenado = true;

            for (int i = 0; i < teto - 1; i++)
            {
                if (vetorAux[i] > vetorAux[i + 1])
                {
                    foiordenado = false;
                    break;
                }
            }
            if (foiordenado)
            {
                break;
            }
        }
        ordenaMista << tamanhoBolha << "\t\t" << intera << endl;
    }
    ordenaMista.close();
}

void troca(int *a, int *b)
{ // função de controle das interações
    int aux = *a;
    *a = *b;
    *b = aux;
    contaQuick++;
}

int particao(int vetor[], int comeso, int fim)
{
    /* Esta função pega o último elemento como pivô, coloca-o
o em sua posição correta no vetor, e coloca todos os menores
(menores que pivô) à esquerda do pivô e todos os maiores à 
direita de pivô */
    int pivo = vetor[fim], i = (comeso - 1); // indice do menor elemento e indicador
                                             // da posição certa do pivo encontrado até então.
    for (int j = comeso; j <= fim - 1; j++)
    {
        if (vetor[j] < pivo)
        {
            i++; // incrementa o indice do menor elemento.
            troca(&vetor[i], &vetor[j]);
        }
    }
    troca(&vetor[i + 1], &vetor[fim]);
    return (i + 1);
}

void quickSort(int vetor[], int comeso, int fim)
{
    // vetor[] --> vetor para ser ordenado,
    // comeso --> indice inicial,
    // fim --> indice final.
    if (comeso < fim)
    { //se não entrar nesse laço if o vetor já está ordenado.
        // indip é o indice da particao, vetor[indip] agora está no lugar certo
        int indip = particao(vetor, comeso, fim);
        // ordena separadamente os elementos antes e depois da particao
        quickSort(vetor, comeso, indip - 1);
        quickSort(vetor, indip + 1, fim);
    }
}

int main(int argc, char const *argv[])
{
    _mkdir("SDK");
    srand(time(NULL));

    // <--{ PARTE 1: ORDENAÇÃO-ELEMENTAR }--> //

    ofstream interasoes; //arquivo com a comparação da ordenação mista: TamBolha x Contador.

    int vetor[MAX];

    criarVetor(vetor, MAX);
    bubbleSort(vetor, MAX);

    // <--{ PARTE 2: ORDENAÇÃO-EFICIENTE }--> //

    ofstream Quick; //arquivo com a comparação da ordenação mista: TamBolha x Contador.
    string namefile = "SDK\\Quick.txt";
    Quick.open(namefile, ios::trunc);
    if (Quick.is_open())
    {
        for (int tamanhoExtra = 0; tamanhoExtra <= 100; tamanhoExtra++)
        {
            int tamanho = 1000 + (10 * tamanhoExtra);
            int *vetorQuick = (int *)malloc(tamanho * sizeof(int));
            if (vetorQuick == NULL)
            {
                cout << "Memoria não alocada." << endl;
                exit(0);
            }
            criarVetor(vetorQuick, MAX);
            quickSort(vetorQuick, 0, tamanho - 1);
            //vetorQuick = (int *)realloc(vetorQuick, tamanho * sizeof(int));
            Quick << tamanho << "\t\t" << contaQuick << endl;
            contaQuick = 0;
        }
        Quick.close();
    }
    return 0;
}