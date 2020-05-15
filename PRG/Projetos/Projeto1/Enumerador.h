/*
 *
 */

#ifndef ENUMERADOR_H
#define ENUMERADOR_H

#include "Diretorio.h"

class Enumerador {
private:
    // o subdiretorio a partir de onde se fazem buscas
    string caminho_inicial;
    int bytes;
public:
    // construtor: cria um objeto Localizador que faz buscas
    // a partir de "caminho"
    Enumerador(string caminho);

    // destrutor: nada faz

    ~Enumerador() {
    };

    // Procura os arquivos "nome" usando busca em largura
    void buscaEmLargura(string nome, string nome1);

    // Procura os arquivos "nome" usando busca em profundidade
    void buscaEmProfundidade(string nome, string nome1);

};

#endif