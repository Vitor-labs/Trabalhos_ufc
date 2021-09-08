#include <iostream>
#include <list>

/*nas listas cada nó requer espaço
extra para o nó que detem o elementos
incluindo seus ponteiros.

a inserção e exclusão na lista são 
muito mais eficientes do que no vetor

é implementado internamente como uma 
lista duplamente encadeada e não se 
pode acessar aleatoriamente os 
elementos, aumentando o custo*/

using namespace std;

bool comparaTamanho(const string &str1, const string str2)
{
    if (str1.length() > str2.length())
    {
        return true;
    }
    return false;
}

int main(int argc, char const *argv[])
{
    list<int> list1;
    list<int> list2(3, 10);

    int vet[3] = {0, 4, 5};

    list<int>::iterator iter;

    list1.push_back(2);
    list1.push_front(3);
    list1.push_back(1);

    for (iter = list1.begin(); iter != list1.end(); iter++)
    {
        cout << *iter << " ";
    }
    cout << endl;

    list2.assign(vet, vet + 3);

    for (iter = list2.begin(); iter != list2.end(); iter++)
    {
        cout << *iter << " ";
    }
    cout << endl;

    iter = list1.end();
    list1.splice(iter, list2);
    list1.sort();

    for (iter = list1.begin(); iter != list1.end(); iter++)
    {
        cout << *iter << " ";
    }
    cout << endl;

    list<string> list3;
    list<string>::iterator iter2;

    list3.push_back("bomfim");
    list3.push_back("zezim e marquim");
    list3.push_back("cleitin");
    list3.push_back("junim e fei");
    list3.push_back("andim");

    list3.sort(comparaTamanho);

    for (iter2 = list3.begin(); iter2 != list3.end(); iter2++)
    {
        cout << *iter2 << " ";
    }
    cout << endl;

    return 0;
}