#include <iostream> //VITOR HUGO 496348
#include <vector>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <direct.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <windows.h>
#include <cstdio>
#include <cstring>

using namespace std;

void mostraSudoku(int matriz[9][9])
{
    cout << "- - - - - - - - -" << endl;
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }
    cout << "- - - - - - - - -" << endl;
}

//verifica se há espaços "vazios".
bool podeColocar(int matriz[9][9], int linha, int coluna, int numero)
{
    //verifica se há algum espaço vazio
    if (matriz[linha][coluna] != 0)
    {
        return false;
    }

    bool status = true;
    int indiceX = (coluna / 3) * 3;
    int indiceY = (linha / 3) * 3;

    for (int i = 0; i < 9; i++)
    {
        if (matriz[linha][i] == numero)
        {
            status = false;
            break;
        }
        if (matriz[i][coluna] == numero)
        {
            status = false;
            break;
        }
        if (matriz[indiceY + i / 3][indiceX + i % 3] == numero)
        {
            status = false;
            break;
        }
    }
    return status;
}
vector<int> achaColocaveis(int matriz[9][9], int linha, int coluna)
{
    vector<int> colocaveis = {};
    for (int i = 1; i <= 9; i++)
    {
        if (podeColocar(matriz, linha, coluna, i))
        {
            colocaveis.push_back(i);
        }
    }
    return colocaveis;
}

void copiaMatriz(int matrizOriginal[9][9], int matrizCopia[9][9])
{
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            matrizCopia[i][j] = matrizOriginal[i][j];
        }
    }
}
void proximoVazio(int matriz[9][9], int linha, int coluna, int &proximaLinha, int &proximaColuna)
{
    int indice = 9 * 9 + 1;
    for (int i = linha * 9 + coluna + 1; i < 9 * 9; i++)
    {
        if (matriz[i / 9][i % 9] == 0)
        {
            indice = i;
            break;
        }
    }
    proximaLinha = indice / 9;
    proximaColuna = indice % 9;
}

bool resolveSudoku(int matriz[9][9], int linha, int coluna)
{
    if (linha > 8)
    {
        return true;
    }

    if (matriz[linha][coluna] != 0)
    {
        int proximaLinha, proximaColuna;
        proximoVazio(matriz, linha, coluna, proximaLinha, proximaColuna);
        return resolveSudoku(matriz, proximaLinha, proximaColuna);
    }

    vector<int> colocaveis = achaColocaveis(matriz, linha, coluna);
    if (colocaveis.size() == 0)
    {
        return false;
    }

    bool status = false;

    for (int i = 0; i < colocaveis.size(); i++)
    {
        int n = colocaveis[i];
        int matrizCopia[9][9];

        copiaMatriz(matriz, matrizCopia);
        matrizCopia[linha][coluna] = n;

        int proximaLinha = linha;
        int proximaColuna = coluna;

        proximoVazio(matrizCopia, linha, coluna, proximaLinha, proximaColuna);

        if (resolveSudoku(matrizCopia, proximaLinha, proximaColuna))
        {
            copiaMatriz(matrizCopia, matriz);
            status = true;
            break;
        }
    }
    return status;
}

void criaSudoku(int matriz[9][9])
{
    srand(time(NULL));
    int numero;
    int j[9] = {0, 3, 6, 1, 4, 7, 2, 5, 8};

    for (int i = 0; i < 9; i++)
    {
        numero = rand() % 10;
        matriz[i][j[i]] == numero;
    }

    resolveSudoku(matriz, 0, 0);

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (rand() % 10 < 6)
            {
                matriz[i][j] = 0;
            }
            if (matriz[i][j] > 0)
            {
                matriz[i][j] -= 1;
            }
        }
    }
}

void remSudoku(int vetor[], int quantos_remover)
{
    srand(time(NULL));
    int aux = 0;
    while (aux < quantos_remover)
    {
        for (int i = 0; i < 81; i++)
        {
            int chance = rand() % 10;
            if (chance > 7)
            {
                vetor[i] = 0;
                aux++;
            }
        }
    }
}

int conversorCharToInt(int varint, char varchar)
{
    varint = atoi(varchar);
}

int main(int argc, char const *argv[])
{
    _mkdir("SDK");
    int matriz[9][9];

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            matriz[i][j] = 0;
        }
    }

    if (strcmp(argv[1], "--criar") == 0)
    {
        int quantos;
        sscanf(argv[2], "%d", &quantos);
        ofstream arquivos;
        string nomeArquivo[quantos];

        for (int i = 0; i < quantos; i++)
        {
            char nome[10] = "sudoku0";
            char val[2];
            sprintf(val, "%d", i);
            strcat(nome, val);
            nomeArquivo[i] = nome;
            val[0] = '\0';
        }

        for (int i = 0; i <= quantos; i++)
        {
            criaSudoku(matriz);
            resolveSudoku(matriz, 0, 0);
            string filename = "SDK\\" + nomeArquivo[i];
            arquivos.open(filename, ios::trunc);
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    int aux = matriz[i][j];
                    arquivos << aux;
                }
            }
            arquivos.close();
        }
    }

    if (strcmp(argv[1], "--remover") == 0)
    {
        int quantos; // celulas a remover
        string nomeArquivo = argv[3];
        string rem = "rem_";
        rem += nomeArquivo;
        sscanf(argv[2], "%d", &quantos);

        ifstream completeSudoku; //arquivo da operção anterior, cheio
        completeSudoku.open(argv[3], ios::out);
        char newSudoku[81];
        if (completeSudoku.is_open())
        {
            //pega dados do arquivo e guarda em um vetor
            completeSudoku.getline(newSudoku, 81, EOF);
        }

        completeSudoku.close();

        ofstream remCelSudoku; //arquivo com sudoku com celulas removidas
        string file = "SDK\\" + rem;
        remCelSudoku.open(file, ios::trunc);
        if (remCelSudoku.is_open())
        {
            int intNwSudoku[81];
            conversorCharToInt(intNwSudoku, newSudoku, 81);
            for (int i = 0; i < 81; i++)
            {
                cout << intNwSudoku[i] << " ";
            }
            remSudoku(intNwSudoku, quantos);
            char(*fimSudoku)[9] = reinterpret_cast<char(*)[9]>(newSudoku);

            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    remCelSudoku << fimSudoku[i][j];
                }
            }
            remCelSudoku.close();
        }
    }
    if (strcmp(argv[1], "--resolver") == 0)
    {
        string aux = argv[2];
        string filename = "sol_" + aux;

        ifstream solvedSudoku;
        solvedSudoku.open(argv[2], ios::out);
        char newSudoku[81];
        if (solvedSudoku.is_open())
        {
            //pega dados do arquivo e guarda em um vetor
            solvedSudoku.getline(newSudoku, 81, EOF);
            solvedSudoku.close();
        }

        //conversor de char para int
        int intNwSudoku[81];
        conversorCharToInt(intNwSudoku, newSudoku, 81);

        ofstream fullSudoku; //arquivo com sudoku com celulas removidas
        string file_name = "SDK\\" + filename;
        fullSudoku.open(file_name, ios::trunc);
        if (fullSudoku.is_open())
        {
            int(*fimSudoku)[9] = reinterpret_cast<int(*)[9]>(intNwSudoku);
            resolveSudoku(fimSudoku, 0, 0);

            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    fullSudoku << fimSudoku[i][j] << " ";
                }
                fullSudoku << endl;
            }
        }
        fullSudoku.close();
    }
    return 0;
}