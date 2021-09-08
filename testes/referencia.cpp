#include <iostream>
#include <math.h>

using namespace std;

/*O retorno por referência é aconselhado para casos onde o retorno de 
dados de uma função são muito grandes, podendo causar uma lentidão no 
sistema, assim sendo mais eficiente */

typedef struct Pessoa
{
	string nome;
	int idade;
	double peso, altura;
} t_pessoa;

double &calcular_imc(t_pessoa &pessoa)
{
	double result = pessoa.peso / pow(pessoa.altura, 2);
	double &imc = result;

	return imc;
}

int main(int argc, char *argv[])
{
	t_pessoa pessoa = {"joao", 20, 92.45, 1.75};

	cout << "IMC: " << calcular_imc(pessoa) << endl;
	return 0;
}