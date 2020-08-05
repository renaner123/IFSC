/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   interface.h
 * Author: renan
 *
 * Created on 3 de Setembro de 2017, 13:27
 */

#ifndef INTERFACE_H
#define INTERFACE_H
#include "idhm.h"

class Interface {
//  Métodos da interface.
//  Recebe caminho para o construtor do Idhms.
    
public:

    Interface(string e,string u);
    virtual ~Interface();
   
    int MenuPrincipal(int e); ////Mostra o menu principal e retorna a opção.
    int Testa_Incon(int cont);  
private:    //Cria uma classe igual a Idhms;
    
    Idhms Tele;
    int cont_teste;
    
};

#endif /* INTERFACE_H */

