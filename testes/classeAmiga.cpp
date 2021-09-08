//Experimento sobre herança
//funções virtuais, funções
//e classes amigas em c++.

#include <iostream>
#include <string.h>

using namespace std;

class Tijolo{
    friend class Telha;

private:
    int largura, altura, comprimento;
    string tipo, cor;
    bool inteiro;
    
    friend void addComprimento(Tijolo &tij, int add);

public:
    void setLargura(int largura){ 
        this -> largura = largura;}
    void setAtura(int altura){
        this -> altura = altura;}
    void setComprimento(int comprimento){
        this -> comprimento = comprimento;}
    void setTipo(string tipo){
        this -> tipo = tipo;}
    void setCor(string cor){
        this -> cor = cor;}

    //Getters
    int getLargura(void){
        return largura;}
    int getAltura(void){
        return altura;}
    int getComprimento(void){
        return comprimento;}
    string getCor(void){
        return cor;}
    string getTipo(void){
        return tipo;}

    Tijolo(int largura, int altura, int comprimento, string tipo, string cor){
        this -> largura = largura; 
        this -> altura = altura;
        this -> comprimento = comprimento;
        this -> tipo = tipo;
        this -> cor = cor;
        this -> inteiro = true;}

    void isInteiro(){
        cout << "Tijolo: " << inteiro << endl;}

    virtual void apresentar(){
        cout << "Eu sou um Tijolão" << endl;}
};
void addComprimento(Tijolo &tij, int add){
        tij.comprimento += add;}

class Telha : public Tijolo{

private:
    int curvatura;

public:
    Telha(int largura, int altura, int comprimento, int curvatura, string tipo, string cor): 
        Tijolo(largura, altura, comprimento, tipo, cor){
        this -> curvatura = curvatura;}

    void setCurvatura(int curvatura){
        this -> curvatura = curvatura;}
    int getCurvatura(){
        return this -> curvatura;}

    virtual void apresentar(){
        cout << "Eu sou um Telhão" << endl;}

    void quebraTijolo(Tijolo &tij){
        tij.inteiro = false;}
};

void whoIam(Tijolo* pointTij){
    pointTij -> apresentar();}

int main(int argc, char const *argv[]){
    Tijolo tij = {3, 4, 10, "de concreto", "cinza"};
    Telha teco = {5, 2, 15, 2, "quadrada", "rosa"};

    //tij.isInteiro();
    //teco.quebraTijolo(tij);
    //tij.isInteiro();

    whoIam(&tij);
    whoIam(&teco);

    return 0;}