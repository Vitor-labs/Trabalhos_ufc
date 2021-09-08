#include <iostream>

using namespace std;

class animals{
protected:
    string name, color;

public:
    animals(string name, string color){
        this->name = name;
        this->color = color;}

    string getName(){return name;}
    string getColor(){return color;}

    void eat(){cout << "eating..." << endl;}
    void present(){cout << "i'm a " << getColor() << " Animal named " << getName() << endl;}
};
class groundAnimal : public animals{
protected:
    int numberPaws;
public:
    groundAnimal(int numberPaws, string name, string color) : animals(name, color){
        this->numberPaws = numberPaws;
        this->name = name;
        this->color = color;}

    groundAnimal(int numberPaws) : animals(name, color){
        this->numberPaws = numberPaws;}
    
    int getNumberPaws(){return numberPaws;}

    void walk(){
        if (numberPaws >= 2){
            cout << "Walking..." << endl;}
    }
    void run(){
        if (numberPaws >= 2){
        cout << "Running !!!" << endl;}
    }
    void present(){
        cout << "i'm a " << getColor() << " ground Animal named " << getName() << endl;}
};
class waterAnimal : public animals{
protected:
    bool tail;
public:
    waterAnimal(bool tail, string name, string color) : animals(name, color){
        this->tail = tail;
        this->name = name;
        this->color = color;}

    waterAnimal(bool tail) : animals(name, color){
        this->tail = tail;}

    bool getTail(){return tail;}

    void swim(){
        if(tail){
            cout << "Swiming" << endl;}
    }
    void present(){
        cout << "i'm a " << getColor() << " water Animal named " << getName() << endl;}
    
};
class flyAnimal : public animals{
protected:
    bool fly;
public:
    flyAnimal(bool fly, string name, string color) : animals(name, color){
        this->fly = fly;
        this->name = name;
        this->color = color;}

    flyAnimal(bool fly) : animals(name, color){
        this->fly = fly;}

    bool getFly(){return fly;}

    void flying(){
        if(fly){
            cout << "flying..." << endl;}
    }
    void landing(){
        if (fly){
            cout << "Landing..." << endl;}
        else{
            cout << "Landi....ROLLING !!!" << endl;}
    }
    void present(){
        cout << "i'm a " << getColor() << " flying Animal named " << getName() << endl;}
};
class duck : public groundAnimal, public waterAnimal, public flyAnimal {
public:
    string name, color;

    duck(int numberPaws, bool fly, bool tail, string name, string color) :
             groundAnimal(numberPaws), waterAnimal(tail), flyAnimal(fly) {
        this->numberPaws = numberPaws;
        this->fly = fly;
        this->tail = tail;
        this->name = name;
        this->color = color;}
    
    void present(){
        cout << "i'm a " << getColor() << " nature god named " << getName() << endl;}
};
int main(int argc, char const *argv[]){
    /*animals animal = {"jeferson", "roxaum"};
    animal.present();
    animal.eat();

    roundAnimal terra = {4, "robson", "a-m-a-r-e-l-o"};
    terra.present();
    terra.walk();
    terra.run();
    terra.eat();

    waterAnimal moiado = {true, "cheila", "purpurina, q nem a tua bunda"};
    moiado.present();
    moiado.swim();

    flyAnimal zezaum = {true, "sulista", "negativo"};
    zezaum.present();
    zezaum.flying();
    zezaum.landing();*/

    duck donald = {2, true, true, "seu pai ", "dourado"};
    donald.present();
    donald.flying();
    donald.landing();
    donald.swim();
    donald.walk();
    donald.run();

    return 0;}