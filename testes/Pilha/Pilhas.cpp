#include <iostream>
#include "Pilhas.h"

using namespace std;

int main(int argc, char const *argv[]){
    
    Pilhas<const char*> pila = Pilhas<const char*>(10);

    pila.empilhar("12.41");
    pila.empilhar("Chucrute");
    pila.empilhar("33.4312");
    pila.empilhar("arlindo santa cruz");

    cout << "Pilha: ";
    pila.vazia();
    cout << "Topo: " << pila.get_top() << endl;

    pila.desempilhar();
    pila.desempilhar();

    cout << "Pilha: ";
    pila.vazia();
    cout << "Topo: " << pila.get_top() << endl;

    pila.~Pilhas();

    return 0;}