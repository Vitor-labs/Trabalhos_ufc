#include <iostream>
#include <deque>

using namespace std;

/* Double - End - QUEues, os deques são filas de 2 pontas, tem as mesmas 
funcionaldades só que em ambas as extremidades*/

int main(int argc, char const *argv[])
{
    deque<int> filadupla;

    cout << (bool)filadupla.empty() << endl;

    filadupla.push_back(10);
    filadupla.push_back(20);
    filadupla.push_back(30);

    filadupla.push_front(11);
    filadupla.push_front(21);
    filadupla.push_front(31);

    cout << filadupla.empty() << endl;

    filadupla.erase(filadupla.begin() + 3);

    deque<int>::iterator i = filadupla.begin();
    while (i != filadupla.end())
    {
        cout << *i << " ";
        i++;
    }

    filadupla.clear();

    return 0;
}
