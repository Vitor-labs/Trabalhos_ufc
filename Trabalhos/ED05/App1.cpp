#include <iostream>
#include <fstream>
#include <direct.h>
#include <vector>

/*VITOR HUGO - 496348*/

using namespace std;

void sodeussabeoqissofaz(fstream &saida, vector<string> palavras, int primeiro, int ultimo)
{
    int media = (primeiro + ultimo) / 2;

    if (primeiro > ultimo)
    {
        return;
    }
    else
    {
        saida << palavras[media] << endl;
        sodeussabeoqissofaz(saida, palavras, primeiro, media - 1);
        sodeussabeoqissofaz(saida, palavras, media + 1, ultimo);
    }
}

int main(int argc, char const *argv[])
{
    _mkdir("SDK");

    fstream portuga, portugas;
    vector<string> palavras;
    string palavra;

    portuga.open("SDK\\portugues.txt", ios::in);
    portugas.open("SDK\\portugues~.txt", ios::out | ios::trunc);
    if (portuga.is_open())
    {
        while (getline(portuga, palavra))
        {
            palavras.push_back(palavra);
        }
        sodeussabeoqissofaz(portugas, palavras, 0, palavras.size() - 1);
    }
    portuga.close();
    portugas.close();
    return 0;
}
