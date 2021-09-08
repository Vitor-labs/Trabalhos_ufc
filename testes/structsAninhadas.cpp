#include <iostream>

using namespace std;

typedef struct Aluno
{
    struct Curso
    {
        string nome;
        int preco;
    };

    struct Estudante
    {
        string nomeAluno;
        Curso materia;
    };

    Curso curso;
    Estudante estudante;

} aluno;

int main(int argc, char const *argv[])
{
    aluno carlo = {{"Fisica", 700}, {"Carlos"}};
    aluno ceza = {{"Historia", 600}, {"Cezar"}};
    aluno *aln = &carlo, *alun = &ceza;

    cout << aln->estudante.nomeAluno << endl;

    aluno::Estudante nomeCur = alun->estudante;

    cout << nomeCur.materia.nome << endl;

    return 0;
}