#include <iostream>

using namespace std;

/*Variaveis estaticas tem tipo de vida equivalente ao programa. O espaço 
para a variável estática é alocado apenas uma vez e é usado para todo o 
programa. Uma vez que esta variável é declarada, ela existe até que o 
programa seja executado. Variáveis ​​estáticas são geralmente consideradas 
ruins porque representam o estado global e, portanto, são muito mais 
difíceis de raciocinar. Em particular, eles quebram os pressupostos da 
programação orientada a objetos.*/

static int id = 0;

int geraID()
{
    return ++id;
}

int main(int argc, char const *argv[])
{
    while (id < 16)
    {
        string nome = argv[1];
        string nome2 = argv[2];
        string nome3 = argv[3];
        cout << "ID de " << nome << ": " << geraID() << endl;
        cout << "ID de " << nome2 << ": " << geraID() << endl;
        cout << "ID de " << nome3 << ": " << geraID() << endl;
    }
    return 0;
}
