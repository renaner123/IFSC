/*  
 * File: main.cpp
 * Authors: Ana Paula Hoog, Renan Rodolfo da SIlva
 */ 

#include <iostream>
#include "Enumerador.h"
#include <stdlib.h>
#include "prglib.h"
#include <fstream>
#include <time.h> 

using namespace std;
using namespace prglib;

int main(int argc, char * argv[]) { 
    
    prglib::fila<string> Largura(100); // criação de fila para separar os tipos possiveis de busca
    prglib::fila<string> Tipo(100);    //
    prglib::fila<string> Extensao(100);//
    
    string what;
    
        if(argc==1){                       // Caso não seja passado nenhum argumento, será listado todos os diretorios                    
                                           // por busca em largura que estão em /home
            string caminho = "/home",nome,nome1;              
            Enumerador loc(caminho);       // Criação do objeto da classe Localizador
            nome1="-d";
            nome= "";
            loc.buscaEmLargura(nome,nome1);
            cout << endl << "Fim da busca em Largura padrão de diretórios" << endl;
            
            return 0;
        }       
 
    Enumerador loc(argv[1]);  // Criação do objeto da classe Localizador apartir do primeiro argumento da linha de comando;   
    
        for (int i=2; i <argc; i++) {  //Separa todos os argumentos de acordo com seu tipo e guarda em sua respectiva fila     
            what = argv[i];
                if((what=="-a")||(what=="-p")||(what=="-d")||(what=="-link")||((what=="all")||(what=="ALL"))) Tipo.enfileira(what);
                else if((what=="P")||(what=="L")||(what=="p")||(what=="l")) Largura.enfileira(what);
                else if(what.size()>1) Extensao.enfileira(what);
                else cout << "Opções invalidas";
        }
    
    string nome,nome1; // variavéis para o serem enviados aos método de buscaEmLargura e buscaEmProfundidade 
    
        if(Largura.comprimento()>0){                                                            
            if((Tipo.comprimento()==1)&&(Extensao.comprimento()==1)) {      //Teste para verificar se foi passado apenas um tipo ou uma extensao nos argumentos
                cout<< "Você pode buscar apenas um Tipo ou uma Extensão";   
                return 0;
            } 
            
            if((Tipo.comprimento()==0)&&(Extensao.comprimento()==0)) {      // Verifica se foi digitado algum tipo para ser buscado, -d ou -a ou txt ...
                cout<< "Precisa definir o que vai querer procurar -d -a -p -link ou alguma extensao Ex. text.txt ou txt" << endl;
                return 0;
            } 
            
            if((Tipo.comprimento()>1)||(Extensao.comprimento()>1)) {        //Não deixar procurar mais que um tipo por vez, -d -a por exemplo ou txt e pdf...
                cout << "Você só pode buscar 1 tipo" <<endl;
                return 0;
            }
                    
            if(Largura.comprimento()>1) {                                   // Não deixa usuário fazer uma busca em largura e profundidade simultaneamente                        
                cout << "Você só pode buscar 1 tipo" <<endl;
                return 0;
            }

            if((Largura.frente()=="P")||(Largura.frente()=="p")){  //Se no comando tiver p, ele vai fazer uma busca em profundidade,
                if(Tipo.comprimento()>0){                          // ele ve analisar qual o tipo ou extensão que se deseja procurar
                    nome1 = Tipo.desenfileira();                   // e vai passar o tipo para método buscaemProfundidade;
                    nome = "";                                  
                    loc.buscaEmProfundidade(nome,nome1);   
                    cout << endl <<"Fim da busca em Profundidade" << endl;
                }
            
                else if(Extensao.comprimento()>0){                  // caso não seja algum tipo, e sim um extensao
                    nome = Extensao.desenfileira();                 // ele envia a extensão para o método buscaEmProfundidade
                    nome1 = "";
                    loc.buscaEmProfundidade(nome,nome1); 
                    cout << endl <<"Fim da busca em Profundidade" << endl;
                }
            
                else cout << "Não definiu um tipo ou extensao Ex. text.txt ou txt"; // Verificação de conteudo;
            }
            
            if((Largura.frente()=="l")||(Largura.frente()=="l")){//Se no comando tiver l, ele vai fazer uma busca em largura,
                if(Tipo.comprimento()>0){                        // ele ve analisar qual o tipo ou extensão que se deseja procurar
                    nome1 = Tipo.desenfileira();                 // e vai passar o tipo para método buscaEmLargura;
                    nome = "";              
                    loc.buscaEmLargura(nome,nome1);   
                    cout<<endl <<"Fim da busca em Largura" << endl;
                }
            
                else if(Extensao.comprimento()>0){          // caso não seja algum tipo, e sim um extensao
                    nome = Extensao.desenfileira();         // ele envia a extensão para o método buscaEmLargura
                    nome1 = "";
                    loc.buscaEmLargura(nome,nome1); 
                    cout << endl <<"Fim da busca em Largura" << endl;
                }
            
                else cout << "não definiu um tipo ou extensão Ex. text.txt ou txt";  
            }
        
        }
    
        else cout <<"Precisar definir um tipo de busca(P ou L)" << endl;
}
