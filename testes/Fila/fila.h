#ifndef _FILA_H_
#define _FILA_H_

#include <list>

using namespace std;

template <class T>
class Fila{
private:
    list<T> Fila;
public:
    bool vazia(){
        return Fila.empty();}

    void inserir(T x){
        Fila.push_back(x);}

    T remover(){
        if (!this->vazia()){
            T e = Fila.front();
            Fila.pop_front();
            return e;}
        throw "Fila Vazia !";}

    T frente(){
        if(!this->vazia()){
            return Fila.front();}
        throw "Fila Vazia !";}

    T final(){
        if(!this->vazia()){
            return Fila.back();}
        throw "Fila Vazia !";}

    T tamanho(){
        return Fila.size();}
};

#endif