/* 
 * File:   arvore.h
 * Author: msobral
 *
 * Created on 12 de Agosto de 2016, 13:12
 */

#ifndef ARVORE_H
#define	ARVORE_H

#include <libs/BasicTree.h>

namespace prglib {
    
template <typename T> class arvore : private BasicTree{
 public:
  arvore();
  //arvore(const arvore<T> & outra);
  arvore(const T & dado);
  virtual ~arvore();

  void adiciona(const T& algo);
  T& obtem(const T & algo);
  void listeInOrder(lista<T> & result);
  void listePreOrder(lista<T> & result);
  void listePostOrder(lista<T> & result);
  void listeEmLargura(lista<T> & result);
  unsigned int tamanho() const;  
  unsigned int altura() ;
  int fatorB() ;
  arvore<T> * balanceia();
  arvore<T> * balanceia(bool otimo);
  
  void inicia();
  bool fim();
  T& proximo();
  
  void iniciaPeloFim();
  bool inicio();
  T& anterior();

  T remove(const T & algo);
  T & obtemMenor() const;
  T & obtemMaior() const;
  
  void obtemMenoresQue(lista<T> & result, const T & algo);
  void obtemMaioresQue(lista<T> & result, const T & algo);
  
  // obtém todos valores entre "start" e "end" (inclusive)
  void obtemIntervalo(lista<T> & result, const T & start, const T & end);
 protected:
     T data;
     
    // atribuição: *p1 <- *p2
    virtual void atribui(void * p1, void * p2);
    // compararação de igualdade
    virtual bool ehIgual(void * p1, void * p2);
    // comparação de precedência: *p1 < *p2
    virtual bool ehMenor(void * p1, void * p2);
    // destroi dado
    virtual void destroi(void * p1);
    
    virtual BasicTree * create(void * p_dado);
    
  arvore<T> * rotacionaL();
  arvore<T> * rotacionaR();
    
};

} // fim do namespace

#include <libs/arvore-impl.h>

#endif	/* ARVORE_H */

