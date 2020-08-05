/* 
 * File:   main.cpp
 * Author: sobral
 *
 * Created on 8 de Outubro de 2016, 19:05
 */

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
#include "ajustes.h"

using namespace std;
using namespace prglib;

/*
 * 
 */
int main(int argc, char** argv) {
    
    string caminho,caminho_adiciona;
    int op=0;
    lista<string> lista_adiciona;
    cout << " ...:SEJA BEM VINDO:..." << endl;
    caminho="palavras.txt";
    
    Oraculo ora(caminho);
    
    ora.busca(" ");
    
   /* while(1){
         cout << "Escolha sua opção: " << endl;
         cout << "1- Para utilizar o terminal de texto usando auto completar;" << endl;
         cout << "2- Para adicionar mais palavras ao banco de dados de algum arquivo." << endl;
         cout << "3- Para adicionar mais palavras ao banco de dados de alguma lista." << endl;
         cout << "4- Para Sair." << endl;
        
        
     switch (op) {
        case 1: 
               ora.busca(" ");           
                       
        case 2:  
               cout << "Digite um arquivo que queira adicionar ao banco de dados"
               cin >> caminho_adiciona;
               ora.adiciona_palavras(caminho_adiciona);       
               break;
               
         case 3:
               cout << "Digite uma lista que queira adicionar ao banco de dados"
               cin >> lista_adiciona;
               ora.adiciona_palavras(caminho_adiciona);       
               break;
         case 4: return 0;
                   
    }
    
    }   
    */
    
    
  
    

}