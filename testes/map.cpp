#include <iostream>
#include <map>

using namespace std;

/*A classe map funciona como um conteiner associativo. O acesso aos mapas é
bem rápido, pois internamente, eles implementa uma estrutura conhecida como
Red-Black Trees, que usam busca balanceada, usadas paras esses vetores*/

int main(int argc, char const *argv[])
{
    cout << "MAPA" << endl;
    map<int, string> mapa;
    mapa = {{1, "pedro"},
            {2, "carlos"},
            {3, "jose"},
            {4, "henrique"},
            {5, "felipe"},
            {1, "leandro"},
            {2, "mateus"},
            {3, "vitor"},
            {6, "henrique"},
            {1, "erique"}};

    map<int, string>::iterator it = mapa.begin();
    for (it; it != mapa.end(); it++)
    {
        cout << it->first << ": " << it->second << endl;
    }
    cout << endl;

    it = mapa.find(2);
    mapa.erase(it);

    for (int i = 1; i <= mapa.size(); i++)
    {
        if (mapa.find(i) == mapa.end())
        {
            cerr << "Elemento vazio" << endl;
            mapa.insert({i, "--vazio--"});
            continue;
        }

        cout << mapa.count(i) << " - " << mapa.at(i) << endl;
    } // a função count é mais util com multimapas
    cout << endl;

    for (it = mapa.begin(); it != mapa.end(); it++)
    {
        cout << it->first << ": " << it->second << endl;
    }
    cout << endl;

    //MULTIMAPAS:
    cout << "MULTIMAPAS" << endl;
    multimap<int, string> mapa2;
    mapa2 = {{1, "pedro"},
             {1, "leandro"},
             {2, "carlos"},
             {2, "mateus"},
             {3, "jose"},
             {3, "vitor"},
             {4, "henrique"},
             {5, "felipe"},
             {6, "henrique"},
             {1, "erique"}};

    multimap<int, string>::iterator iter = mapa2.begin();
    for (iter; iter != mapa2.end(); iter++)
    {
        cout << iter->first << ": " << iter->second << endl;
    }
    cout << endl;

    multimap<int, string>::iterator itlow, itup;

    itlow = mapa2.lower_bound(2);
    itup = mapa2.upper_bound(4);

    for (iter = itlow; iter != itup; ++iter)
    {
        cout << iter->first << ": " << iter->second << endl;
    }
}