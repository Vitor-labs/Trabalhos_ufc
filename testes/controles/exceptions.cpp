#include <iostream>
#include <exception>

using namespace std;

class exceptions : public exception{
protected:
    string message;
public:
    exceptions(string message){
        this->message = message;}

    virtual string what(){
        return this->message;} 
};

int fat(int n){
    if (n < 0){
        throw exceptions("Numero Negtivo");}
    if (n == 0 || n == 1 ){
        return 1;}
    return n * fat(n-1);}

double div(double n, double n2){
    if (n2 == 0){
        throw exceptions("Divisao por 0");}
    return n/n2;}

int main(int argc, char const *argv[]){
    try{
        cout << fat(5) << endl;
        //cout << fat(-4) << endl;
        cout << div(5.8, 6.1) << endl;
        cout << div(6.0, 0.0) << endl;}

    catch(exceptions e){
        cerr << "error: " << e.what() << '\n';}

    catch(...){
        cerr << "Erro inesperado !" << endl;};
    
    return 0;}