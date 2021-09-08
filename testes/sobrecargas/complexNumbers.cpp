/*Estudo sobre numeros 
complexos e sobrecarga
de operadores em c++*/

#include <iostream>

using namespace std;

class complexNumbers{
public:
    int real, imag;

    void init(int real, int imag){
        this->real = real;
        this->imag = imag;}
    
    complexNumbers(int real, int imag){
        /*this->real = real;
        this->imag = imag;*/
        init(real, imag);}

    complexNumbers(complexNumbers& copyComplex){
        init(copyComplex.real, copyComplex.imag);}

    /*complexNumbers operator+ (complexNumbers& complexNumber){
        return complexNumbers(this->real + complexNumber.real, 
                              this->imag + complexNumber.imag);}

    complexNumbers operator- (complexNumbers& complexNumber){
        return complexNumbers(this->real - complexNumber.real,
                              this->imag - complexNumber.imag);}*/

    complexNumbers& operator= (complexNumbers& complexNumber){
        if (this != &complexNumber){
            init(complexNumber.real, complexNumber.imag);}
        return *this;}
};
int main(int argc, char const *argv[]){
    complexNumbers c(1, 2), c2(3, 4);
    c = c2;
    cout << c.real << " " << c.imag << endl;
    cout << c2.real << " " << c2.imag << endl;

    cout << ++c.real << " " << ++c.imag << endl;
    cout << c2.real << " " << c2.imag << endl;
    /*complexNumbers c3 = c + c2; //c3 = c.operator+(c2);

    cout << "C3 -> real: " << c3.real 
         << " | imaginary: " << c3.imag << endl;*/
    return 0;}