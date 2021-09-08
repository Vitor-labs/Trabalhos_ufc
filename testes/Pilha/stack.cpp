#include <iostream>
#include <stack>

using namespace std;

/* Pilha - LIFO (last in first out), primeiro a entrar, ultimo a sair*/

int main(int argc, char *argv[])
{
	stack<int> pilha;

	pilha.push(10);
	pilha.push(20);
	pilha.push(30);
	pilha.push(40);
	// pilha: 10, 20, 30, 40

	cout << "Tamanho da pilha: " << pilha.size() << endl;

	while (!pilha.empty())
	{
		int e = pilha.top();

		cout << e << " ";
		pilha.pop();
	}

	cout << "\n";

	return 0;
}