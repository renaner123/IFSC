/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   idhm.h
 * Author: Renan
 *
 * Created on 3 de Setembro de 2017, 13:27
 */

#ifndef IDHM_H
#define IDHM_H
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
using prglib::thash;
using namespace std;
using namespace prglib;

struct IDHM {
//  Criação da struct IDHM que receberá todos os valores do arquivo idhm.csv;
    
    string municipio;
    int ano;
    int uf;
    int Codmun6;
    int Codmun7;
    float idhm;
    float idhm_e;
    float idhm_l;
    float idhm_r;      
    string chave2;
    //ANO,UF,Codmun6,Codmun7,Município,IDHM,IDHM_E,IDHM_L,IDHM_R
   // As colunas ANO, UF, C odmun6, Codmun7 e Município são únicas
  bool operator == (const IDHM & outro){     
      
      
      /* 1 2 3 4
         1 3 4 5
       * 2 3 4
         2 3     
       
       */
 
      if(to_string((ano+Codmun6+Codmun7)) + municipio == to_string((outro.ano+outro.Codmun6+outro.Codmun7))+outro.municipio){     
      return to_string((ano+Codmun6+Codmun7)) + municipio  == to_string((outro.ano+outro.Codmun6+outro.Codmun7)) + outro.municipio;    
      } 
      
      if(ano+uf+Codmun6+Codmun7 != outro.ano+outro.uf+outro.Codmun6+outro.Codmun7){     
      return ano+uf+Codmun6+Codmun7  == outro.ano+outro.uf+outro.Codmun6+outro.Codmun7;    
      }
      
      
      /*
      if(uf+Codmun6+Codmun7==outro.uf+outro.Codmun6+outro.Codmun7){     
      return (uf+Codmun6+Codmun7) == outro.uf+outro.Codmun6+outro.Codmun7;   
      }
      
      if(to_string(Codmun6)+to_string(Codmun7)+municipio!=to_string(Codmun6)+to_string(Codmun7)+municipio){     
      return (to_string(Codmun6)+to_string(Codmun7)+municipio) == to_string(Codmun6)+to_string(Codmun7)+municipio;   
      }
   */
     } 
    
    IDHM(const string & linha) {       
    //  O construtor receberá uma linha.
    //  Em seguida, irá separar as informações desta linha utilizando a vírgula como referência
    //  e as guardará em cada posição da struct 
        
    lista<string> teste;   //Utilizado para anexar na lista base.
    
    char sep=',';
    int pos=0;
    string usa = linha;
    int cont=0,i=0;
        for(int u=0;u<usa.size();u++){
            if(usa[u]==sep) cont=cont +1;
        }
    
        for(int i=0;i<cont+1;i++){
            int pos = usa.find(sep);     
            string teste1 = usa.substr(0,pos);
            usa.erase(0,pos+1);        
            teste.anexa(teste1);          
        }        

        teste.inicia();
    
        ano= stoi(teste.proximo());
        uf=stoi(teste.proximo());
        Codmun6=stoi(teste.proximo());
        Codmun7=stoi(teste.proximo());
        municipio=teste.proximo();
        idhm=stof(teste.proximo());
        idhm_e=stof(teste.proximo());
        idhm_l=stof(teste.proximo());
        idhm_r=stof(teste.proximo());   
        
      
   
    }
 
  IDHM() {
  // Possibilita criar um Numero vazio
  }
  
};


class Idhms {

public:
    
    Idhms (string caminho, string caminho_log); 
    //  Recebe o caminho onde consta o arquivo que será aberto e construirá a lista base.
    
    ~ Idhms() {};
    //  Todos os métodos da classe Idhms.
    //  Retorna todos os municipios com seus valores de idhm ...
    

    
    void IDHM_Mun(string Municipio_Espec); 
    //  Retorna o IDHM de N municípios em ordem crescente.    
    int Codmun6(int teste);
    //  Retorna o IDHM de N municipios em ordem decrescente.
    int Testa_Incon(int cont);
  
    
   

 
private:                 
    thash<IDHM> tab_base;
    int conta_inconsistencia; 
    string caminho_verifica,caminho_log_verifica;
    
    //  lista que será usada em todas as funções como base.
    
   //  estado_str será utilizado para salvar o nome do código de cada UF.
     
 
    //  Lista que salva os UF.
   
};



#endif /* IDHM_H */

