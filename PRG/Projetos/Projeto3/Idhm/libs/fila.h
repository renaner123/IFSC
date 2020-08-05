/* 
 * File:   fila.h
 * Author: msobral
 *
 * Created on 11 de Agosto de 2016, 13:58
 */

#ifndef FILA_H
#define	FILA_H

#include <queue>

namespace prglib {
    
template <typename T> class fila : private std::queue<T> {
public:
    fila(unsigned int N);
    fila(const fila<T>& orig);
    virtual ~fila();
    fila<T>& operator=(const fila<T> & outra);
    void enfileira(const T & algo);
    T desenfileira();
    const T & frente() const;
    bool vazia() const;
    bool cheia() const;
    unsigned int comprimento() const;
    unsigned int capacidade() const;
private:
    unsigned int N;
};

}

#include <libs/fila-impl.h>

#endif	/* FILA_H */

