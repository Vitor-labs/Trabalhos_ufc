#include <iostream>
#include <string>
#include <map>
#include <stack>

using namespace std;

struct Expresaum {
private:
    map<string, int> expresao;
public:
    void set(string chave, int value){
        expresao.insert(pair<string, int>(chave, value));};

    int get(string chave){
        map<string, int>::iterator iter;
        iter = expresao.find(chave);

        if(iter != expresao.end()){
            expresao.erase (iter);}

        return expresao.find(chave) -> second;};
};
bool validar(string aux){
    int cont = 0;
    for(int i = 0; i < aux.length(); i++){
        if(aux[i] == ' '){
            cont++;}
    }
    if(cont > 2){
        cout << "ERRO: Input invalido, deve conter apenas (:) + 'nome variavel' + 'valor(inteiro)'" << endl;
        return false;}
    return true;
}
void add(Expresaum expre, string nome, string valor){
        int aux = stoi(valor);
        expre.set(nome, aux);
}
string find(string expre){
    string aux;
    for(int i = 0; i < expre.length(); i++){
        if((expre[i] >= 65 && expre[i] <= 90) || (expre[i] >= 97 && expre[i] <= 122)){ // usando valores ASCII para encontrar letras
            aux += expre[i];}
    }
    return aux;}

int compararPrioridade(char op1, char op2){
    int p_op1 = 0, p_op2 = 0;

    if(op1 == '*' || op1 == '/')      { p_op1 = 2; }
    else if(op1 == '+' || op1 == '-') { p_op1 = 1; }
    else if(op1 == '(')               { p_op1 = 0; }
    else                              { p_op1 = 4; }

    if(op2 == '*' || op2 == '/')      { p_op2 = 2; }
    else if(op2 == '+' || op2 == '-') { p_op2 = 1; }
    else if(op2 == '(')               { p_op2 = 0; }
    else                              { p_op2 = 4; }

    if(p_op1 = 0)           { return 4; }
    else if(p_op1 = 4)      { return 3; }
    else if(p_op1 > p_op2)  { return 0; }
    else if(p_op1 < p_op2)  { return 1; }
    else if(p_op1 == p_op2) { return 2; }
}

bool temPrioridade(char op1, char op2){
    bool temPrioridade;
    int v_prioridade = compararPrioridade(op1, op2);
    switch (v_prioridade){
    case 0:
        temPrioridade = true;
        break;
    case 1:
        temPrioridade = false;
        break;
    case 2:
        temPrioridade = true;
        break;
    case 3: 
        temPrioridade = true;
        break;
    case 4:
        temPrioridade = true;
    default:
        break;}

    return temPrioridade;}

int main(int argc, char const *argv[]){
    cout << "Para ATRIBUIR VARIAVEIS utilize o prefixo (:) seguido pelo nome da varievel e o seu valor" << endl
         << "EX: >> : A 5" << endl
         << "Para EXPRESSOES utilize o prefixo (!) seguido pela expressao" << endl
         << "EX: >> ! (A+B)*C" << endl;

    Expresaum exp;                         // guardar as variaveis criadas e seus valores 
    while(true){
        string temp;
        getline(cin, temp);
        char op = temp[0]; // operador
        if(op == ':'){
            // criar variáveis
            string nome, valor;
            nome = find(temp);
            valor = find(temp);
            if(validar(temp)){
                if(nome.empty())       
                    cout << "ERRO: nao foi identificado o nome a variavel" << endl;
                else if(valor.empty()) 
                    cout << "ERRO: nao foi identificado o valor da variavel" << endl;
                else{ 
                    add(exp, nome, valor); }
                cout << "Nome: "<< nome << endl;                                   
                cout << "Valor: "<< valor << endl;}
        }
        else if(op == '!'){
            // resovler expressões
            string resposta;
            stack<char> op_stack;
            // * verificar se as variáveis foram criadas
            
            for(int i = 0; i < temp.length(); i++){
                if( (temp[i] >= 40 && temp[i] <= 43) || (temp[i] == '-') || (temp[i] == '/') ){ // operadores (,),*,+,-,/
                    // verifciar se segue a regra de prioridades
                    if(!op_stack.empty())
                        op_stack.push(temp[i]); // adicionando operador na pilha de operadores
                    else{
                        if(temPrioridade(temp[i], op_stack.top())){
                            // add op na pilha
                            op_stack.push(temp[i]);}
                        else{// add op na string
                            string aux;
                            aux += temp[i];
                            resposta.append(aux);}
                        // tem prioridade

                        if(temp[i] == ')'){
                            for(int i = 0; i < op_stack.size(); i++){
                                op_stack.pop();
                                if( (op_stack.top() == '*') || (op_stack.top() == '/') || (op_stack.top() == '+') || (op_stack.top() == '-')){        
                                    string aux;
                                    aux += temp[i];
                                    resposta.append(aux);}
                            }
                        }

                    }
                }
                else if((temp[i] >= 65 && temp[i] <= 90) || (temp[i] >= 97 && temp[i] <= 122)){
                    string aux;
                    aux += temp[i];
                    resposta.append(aux);} // adicionando variáveis à string de resposta
                else{
                    cout << "ERRO: expressao invalida, por favor verifique e tente novamente" << endl;}
            }
 }
        else{
            cout << "ERRO: Prefixo nao identificado por favor, verifique e tente novamente" << endl;
        }
    }
    return 0;}