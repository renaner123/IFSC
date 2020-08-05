/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ajustes.h
 * Author: renan
 *
 * Created on 15 de Outubro de 2017, 16:45
 */

#ifndef AJUSTES_H
#define AJUSTES_H
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
 
using namespace std;
using namespace prglib;


class Oraculo {
 public:
  // construtor: carrega as palavras contidas no arquivo
  Oraculo(const string & arquivo_de_palavras);
 
  // destrutor
  ~ Oraculo() {};
 
  // adiciona mais palavras, as quais são lidas de um arquivo
  void adiciona_palavras(const string & arquivo_de_palavras);
 
  // adiciona mais palavras, as quais estão contidas em uma lista
  void adiciona_palavras(lista<string> & lista_de_palavras);
 
  // Busca todas as palavras que possuem o prefixo
  int busca(const string& prefixos);
 
 private:
     arvore<string> * a;
     lista <string> busca_tudo;
 
};



#endif /* AJUSTES_H */

