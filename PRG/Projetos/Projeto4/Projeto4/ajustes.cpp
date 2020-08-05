#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
#include "ajustes.h"

using namespace std;
using namespace prglib;

Oraculo::Oraculo(const string & arquivo_de_palavras) {

    
    a = new arvore<string>("a");    //define a raiz da arvore da classe
 
    ifstream q(arquivo_de_palavras);
    
    string linha;
    while(getline(q,linha)){        // adiciona as palavras do arquivo na arvore base.
        a->adiciona(linha);
    }
    
               
    a = a->balanceia();
  
   
   
      }

  int Oraculo::busca(const string& prefixos) {
      
    string arquivo,final;    // variaveis para auxiliar na busca; 
    thash<string> tab(213);
    int cont_zero =0;    
    auto a_aux = new arvore<string>("a");   // lista auxiliar para mostrar as opçoes
      
      
      system("stty raw");
      system("stty -echo");
      
      char prefixo;
    
      string completa,aux,tudo,tudo2;  // variaveis para auxiliar a busca, tudo = todos os caracteres;
      int cont_tab=0;
      cout << " > " ;
      while(true){
       
          cout.flush();
          if(prefixo==13) return 0;      // se teclar enter sai do editor de texto
          
          cin.get(prefixo);              // capturar os caracteres.
          if(prefixo!=9) completa += prefixo; // salva todos os caracteres em uma string, tornando-a completa
          
           
      if (prefixo==9) {                 // quando for pressionado tab entra no processo de verificar as palavras disponiveis.
        cont_tab++; 
     
      cout << '\r' << endl;
      cout << endl;        
      int pos1=completa.find_last_of(' ');              // pega posição do ultimo espaço pra definir que é o prefixo
      try{                                                  // tratativa de erro caso não consiga pegar do espaço em diante            
      aux = completa.substr(pos1+1, 10);                    // salva apenas o prefixo que se deseja completar 
      if(cont_tab==1)tudo2 = completa.substr(0,pos1);       // se for o primeiro tab o proprio prefixo é tudo
      else tudo2 = tudo2 + " " +completa.substr(0,pos1) ;   // soma o que foi digitado antes do prefixo com o restante do que foi digitado
      }catch (...) { aux = completa;}
      
      a->obtemIntervalo(busca_tudo,aux,aux+"zzzzzzzzzz");    // obtem uma lista com todos os valores que contenham o prefixo. 
      
     
      if(busca_tudo.comprimento()==0){              //se na lista não encontrar nada, nada sera feito, volta pra linha de comando;
      cont_zero++;
      cout <<'\r';
      cout  << " > " << tudo2 << " " << aux;
      if(completa==aux) completa=completa;
      else completa = aux;
      busca_tudo.esvazia();                         //limpa a lista e as variaveis envolvidas para próximo atuação
      final.erase(0,100);
          
      }
      
      
      
      if(busca_tudo.comprimento()==1){          // se tiver apenas uma palavra na lista, ele auto completa o prefixo
      busca_tudo.inicia();      
      string um;
      um = busca_tudo.proximo();
      cout <<'\r';      
      cout << " > " << tudo2 << " " << um;   
      
      completa = um;
      a_aux->adiciona(um);
      busca_tudo.esvazia();             //limpa a lista e as variaveis envolvidas para próximo atuação
      final.erase(0,100);
          
      }
      
      if(busca_tudo.comprimento()>1) {      //caso a lista tenha mais que uma opção para completa o prefixo
      
      busca_tudo.inicia();
      int cont=-1;
      string chave_tab,mostrar;             // cria uma chave para que o usuario ṕossa escolher a palavra que quer usar.
      string oioi;
      cout <<'\r';
      
      
      while(!busca_tudo.fim()){
             
          cont ++;
          if(cont==0){ mostrar = "Ignorar";                     // adiciona cada palava com uma valor na tabela pra fazer a escolha
          cout << "- "<< cont << " " << mostrar << " ";         // valor '0' será usado para ignorar a lista.
          chave_tab = to_string(cont);       
          tab.adiciona(chave_tab,mostrar);
          }
          else {
          mostrar = busca_tudo.proximo();
          cout <<"-" << cont << " " << mostrar << " ";
          chave_tab = to_string(cont);       
          tab.adiciona(chave_tab,mostrar);
          }
          
          
          
      }  
    
      char op;
      cout << endl;
      cout <<'\r';
      cout << '\r' << endl;
      cout << '\r';
      
      if(busca_tudo.comprimento()>9) op='0';  // se der espaço e apertar tab ira mostrar todas as palavras disponiveis para fazer os ajustes
      else                                    // ou se tiver mais que 9 opçoes tera que digitar a palavra;
      cin.get(op);     
      
     
      string converte="";
      converte[0]=op;
      converte = converte[0] + converte[1];       // converte os numeros/char para string
        
      cout <<'\r';  
      if(converte!="0"){
      cout << " > "  <<tudo2 << " " <<tab[converte];   // imprimi a opção escolhida com o restante da frase
      completa = tab[converte];                         //
      a_aux->adiciona(tab[converte]);
      busca_tudo.esvazia();
      cont =-1;
      final.erase(0,100);
      }else {          
      cout << " > " <<tudo2 << " " << aux;   
     
      completa = aux;
      a_aux->adiciona(tab[converte]);
      busca_tudo.esvazia();
      cont =-1;
      final.erase(0,100);   
          
          
      }
      }     
                            
      }else{
          cout << prefixo;
          cout.flush();
          
          }
         
          }
    system("stty cooked");
    system("stty echo");

      
     
  }
  
    void Oraculo::adiciona_palavras(const string & arquivo_de_palavras){
        
        ifstream arq(arquivo_de_palavras);
        
        if(!arq.is_open()) cout <<"Arquivo não foi aberto com sucesso" << endl;
        
        string linha,insere_valores;
        while(getline(arq,linha)){                               // recebe o nome de um arquivo e le todas as linhas
            a->adiciona(linha);                                 // contidas nele, e insere na arvore base
        }                                                        // e após salva todas essas palavras lidas com as qe já existiam   
                                                                    // novamente no arquivo base.
        a = a->balanceia();
        
        a->inicia();
        
        ofstream salva_arquivo("palavras.txt");
        
        while(!a->fim()){
            insere_valores = a->proximo();
            salva_arquivo << insere_valores;
        }
        
        
        
    }
    
    
    
      void Oraculo::adiciona_palavras(lista<string> & lista_de_palavras){
          
          lista_de_palavras.inicia();
          
          string prox_palavra,insere_valores;
          
          while(!lista_de_palavras.fim()){                              // recebe uma lista como parametro, itera ela e joga todos os valores para a arvore base
              prox_palavra = lista_de_palavras.proximo();               // e após salva todos os valores que já existiam junto com os valores da lista, no arquivo base
              a->adiciona(prox_palavra);              
              
          }
        a = a->balanceia();
        
        a->inicia();
        
        ofstream salva_arquivo("palavras.txt");
        
        while(!a->fim()){
            insere_valores = a->proximo();
            salva_arquivo << insere_valores;
        }
        
          
          
          
          
      }