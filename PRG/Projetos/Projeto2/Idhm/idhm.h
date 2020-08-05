/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   idhm.h
 * Author: renan
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
 
using namespace std;
using namespace prglib;
 
struct IDHM {
        string municipio;
        int ano;
        int uf;
        float idhm;
        float idhm_e;
        float idhm_l;
        float idhm_r;
        
         
 
  // possibilita criar um Numero com numero e nome 
  // fornecidos diretamente
  //Numero(const string & linha, const string & umNome) {
    IDHM(const string & linha) {               // vai receber uma linha e guardar em cada posição da struct   

    lista<string> teste;
      
   
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
    teste.proximo();
    teste.proximo();
    municipio=teste.proximo();
    idhm=stof(teste.proximo());
    idhm_e=stof(teste.proximo());
    idhm_l=stof(teste.proximo());
    idhm_r=stof(teste.proximo());   
   
  
     
  }
 
  // possibilita criar um Numero vazio
  IDHM() {}

 
};


class Idhms {

public:
 
    Idhms (string caminho);
    
    ~ Idhms() {};
    
    void buscar();            // funçoes a serem feites no idhm.cpp
    void IDHM_Mun(string Mun); 
    void Maiores_IDHM(int Qtd_Maior);
    void Menores_IDHM(int Qtd_Menor);
    void IDHM_Estado(int estado); 
    void IDHM_Limiar(double Idhm_Limiar);
    int Estado(int codigo);
    void Separar_Ufs();
    

 
private:             
    lista<IDHM> usar;  // lista que vai ser usado em todas as funcoes como base...
     string estado_str;
     lista<int> contar_mun;
};









#endif /* IDHM_H */

