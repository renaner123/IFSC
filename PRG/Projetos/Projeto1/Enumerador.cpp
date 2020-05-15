#include <cstdlib>
#include <iostream>
#include "Diretorio.h"
#include "prglib.h"
#include "Enumerador.h"
#include <time.h>    

using namespace std;
using namespace prglib;

Enumerador::Enumerador(string caminho) {
    caminho_inicial = caminho;
}

void Enumerador::buscaEmLargura(string nome, string nome1) {
   try { 
    prglib::fila<string> q(1000);           //  Criação da fila que controla a busca
    prglib::fila<string> qdir(64000);       //  Enfileiramento dos diretórios
    prglib::fila<string> qprog(64000);      //  Enfileiramento dos programas
    prglib::fila<string> qarq(64000);       //  Enfileiramento dos arquivos
    prglib::fila<string> qlink(64000);      //  Enfileiramento Link
    prglib::fila<string> qall(64000);       //  Enfileiramento de tudo
    q.enfileira(caminho_inicial);           //  Enfileiramento do diretorio raiz das buscas

    while (not q.vazia()) {
        string caminho = q.desenfileira();  // Recebe o nome do primeiro item da fila
        Diretorio raiz(caminho);            //  Criação do objeto "raiz" da classe diretorio
                                            //  Para controle e gerenciamento das entradas de cada diretorio
                                            //  Que esteja na fila
        try {                               //  Try e catch declarados para tratativas de exceções
            raiz.inicia_listagem();
        } catch (int e) {
            cout << "error: " << e;
        }
        while (not raiz.fim_listagem()) {   //  Enquanto o objeto "raiz" não estiver no fim da listagem
            try {                           //  As entradas serão tratadas de acordo com as escolhas 
                                            //  Do usuário, definidas no manual.
                Entrada arq = raiz.proximo();
                
                int pos = arq.nome.find('.');
                    if (arq.nome == "." || arq.nome == "..")
                        continue;
              
                   qall.enfileira(raiz.caminho() + '/' + arq.nome); // Enfileira todas as entradas que estiverem no "caminho"
                 
                if ((arq.nome == nome)||(arq.nome.substr(pos+1,10) == nome)) {
                    cout << "entrada " << nome << " de " << arq.nome << " achada em: " << raiz.caminho_absoluto() << endl;
                } 
                                                                                     //  Se alguma entrada coincidir 
                else {                                                               //  Com a procura do usuário, sera enfileirado em sua fila específica
                    switch (arq.tipo) {                                              //  Caso contrario, se for encontrado um diretório no caminho que está 
                        case Tipo::Diretorio:                                        //  Sendo desenfileirado, o mesmo será colocado na fila para ser analisado posteriormente
                            q.enfileira(raiz.caminho() + '/' + arq.nome);
                            qdir.enfileira(raiz.caminho() + '/' + arq.nome);
                            break;
                            
                        case Tipo::Arquivo:                               
                            qarq.enfileira("Arquivo: " + arq.nome + "-- Achado em: " + raiz.caminho());
                            break;
                            
                        case Tipo::Programa:                               
                            qprog.enfileira("Programa: " + arq.nome + "-- Achado em: " + raiz.caminho());
                            break;
                            
                        case Tipo::Link:                               
                            qlink.enfileira("Link: " + arq.nome + "-- Achado em: " + raiz.caminho());
                            break;

                    }                                                       
                }                                                         
            } catch (int e) {
                cout << "error: " << e;
            }

        }
        
        if(nome1=="-d"){                                                     // vai mostras os diretorios se o tipo for -d
            while(!qdir.vazia()){
                cout << qdir.desenfileira()<< endl;
            }
        }
        
        if(nome1=="-p"){      // Se Programa                                  // Testes para saber o que o usuário quer procurar
            while(!qprog.vazia()){                                            // de acordo com os argumentos passados via linha de comando.
                cout << qprog.desenfileira()<< endl;
            }
        }
        
        if(nome1=="-a"){    // Se arquivo
            while(!qarq.vazia()){
                cout << qarq.desenfileira()<< endl;
            }
        }
        
        if(nome1=="-link"){ // Se Link
            while(!qlink.vazia()){
                cout << qlink.desenfileira()<< endl;
            }
        }
        
        if((nome1=="all")||(nome1=="ALL")) throw -1;{ // Se tudo
            while(!qall.vazia()){
                cout << qall.desenfileira()<< endl;
            }
        }   
    }
	} catch (int e) { cout <<"Não consegue acessar esse diretório" << endl;} 
}

void Enumerador::buscaEmProfundidade(string nome, string nome1) {
try {	
    prglib::pilha<string> p(100);       // Criação pilha que controla a busca;
    prglib::pilha<string> pdir(1000);   // criação da pilha pra empilhar os diretórios
    prglib::pilha<string> pprog(64000); // criação da pilha pra empilhar os programas
    prglib::pilha<string> parq(64000);  //criação da pilha pra empilhar os arquivos
    prglib::pilha<string> plink(64000); // criação da pilha pra empilhar os links
    prglib::pilha<string> pall(64000);  // criação da pilha pra empilhar tudo;
    
    p.push(caminho_inicial);            // Enmpilhamento do diretorio raiz das buscas;
    
    while (not p.vazia()) {
        string caminho = p.pop();       // Recebe o nome do primeiro item da pilha;
        Diretorio raiz(caminho);        // Criação do objeto "raiz" da classe diretorio;
                                        // Para controle e gerenciamento das entradas de cada diretorio
                                        // Que esteja na pilha;
        try {                           // Try e catch declarados para tratativas de exceções;
            raiz.inicia_listagem();
        } catch (int e) {
            cout << "error: " << e;
        }
                
        while (not raiz.fim_listagem()) { // Enquanto o objeto "raiz" não estiver no fim da listagem
                                          // As entradas serão tratadas de acordo com as escolhas 
                                          // Do usuário, definidas no manual.
            try {
                Entrada arq = raiz.proximo();
                    int pos = arq.nome.find('.');                
                    if (arq.nome == "." || arq.nome == "..")
                        continue;
                    
                pall.push(raiz.caminho() + '/' + arq.nome);
                if ((arq.nome == nome)||(arq.nome.substr(pos+1,10) == nome)) {
                    cout << "entrada " << nome << " de " << arq.nome << " achada em: " << raiz.caminho_absoluto() << endl;
                } 
                     
                else {                                                          //  Se alguma entrada coincidir 
                    switch (arq.tipo) {
                        case Tipo::Diretorio:                                   //  Com a procura do usuário, sera empilhado em sua pilha específica            
                            p.push(raiz.caminho() + '/' + arq.nome); 
                            pdir.push(raiz.caminho() + '/' + arq.nome);         //  Caso contrario, se for encontrado um diretório no caminho que está 
                            break;  
                                                                                //  Sendo desempilhado, o mesmo será colocado na pilha para ser analisado posteriormente              
                        case Tipo::Arquivo:                              
                            parq.push("Arquivo: " + arq.nome + "-- Achado em: " + raiz.caminho());
                            break;
                            
                        case Tipo::Programa:                               
                            pprog.push("Programa: " + arq.nome + "-- Achado em: " + raiz.caminho());
                            break;
                            
                        case Tipo::Link:                               
                            plink.push("Link: " + arq.nome + "-- Achado em: " + raiz.caminho());
                            break;
                    }                                               
                }                                                   

            }catch (int e) {
                cout << "error: " << e;
             }
        }
        if(nome1=="-d"){ // Se Diretorio
            while(!pdir.vazia()){
                cout << pdir.pop()<< endl;
            }
        }                                               // Testes para mostrar o resultado da busca que o usuário 
                                                        // informou por linha de comando, de acordo com os argumentos
        if(nome1=="-p"){ // Se programa                 // disponiveis no manual.
            while(!pprog.vazia()){
                cout << pprog.pop()<< endl;
            }
        }
        
        if(nome1=="-a"){ // Se arquivo
            while(!parq.vazia()){
                cout << parq.pop()<< endl;
            }
        }
        if(nome1=="-link"){ // se link
            while(!plink.vazia()){
                cout << plink.pop()<< endl;
            }
        }
        
        if((nome1=="all")||(nome1=="ALL")){ // se for tudo
            while(!pall.vazia()){
                cout << pall.pop()<< endl;
            }
        }   
    }
} catch (int e) {cout << "Não consegue acessar esse Diretório" << endl;}
}
