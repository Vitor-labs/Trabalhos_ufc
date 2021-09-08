#include <iostream>
#include "fila.h"

using namespace std;

int main(int argc, char const *argv[]){
    Fila<string> fila1;

    cout << "Testando Fila recem criada:" << endl;
    cout << "Fila tem algo: " << !fila1.vazia() << endl;

    try{
        string e = fila1.remover();}
    catch(const char* e){
        cerr << "Erro: " << e << endl;}
    catch(...){
        cerr << "Erro inesperado !" << endl;}

    cout << endl << "Testando Insersoes" << endl;

    fila1.inserir("jorgim");
    fila1.inserir("cleitim");
    fila1.inserir("geraldo");

    cout << "Fila tem algo: " << !fila1.vazia() << endl;
    cout << "Elemento da Frente: " << fila1.frente() << endl;
    cout << "Elemento Final: " << fila1.final() << endl;
    //cout << "Tamanho da Pilha" << fila1.tamanho() << endl;

    cout << endl << "Testando Remosoes: " << endl;

    fila1.remover();
    fila1.remover();

    cout << "Elemento da Frente: " << fila1.frente() << endl;
    cout << "Elemento Final: " << fila1.final() << endl;
    //cout << "Tamanho da Pilha: " << fila1.tamanho() << endl;

    cout << endl << "Limpando a fila" << endl;
    while(fila1.vazia() == 0){
        fila1.remover();}

    cout << "Fila tem algo: " << !fila1.vazia() << endl;
    cout << "Elemento da Frente: " << fila1.frente() << endl;
    cout << "Elemento Final: " << fila1.final() << endl;
    //cout << "Tamanho da Pilha" << fila1.tamanho() << endl;

    return 0;}
   