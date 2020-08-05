/* 
 * File:   lista-impl.h
 * Author: msobral
 *
 * Created on 11 de Agosto de 2016, 09:02
 */

#ifndef LISTA2_IMPL_H
#define	LISTA2_IMPL_H

#include <chrono>

namespace prglib {

    /*string minuscula(string & algo) {
        int i=0;
        string nova = algo;
        while (i < nova.size()) {
            nova[i] = tolower(nova[i]);
            i++;
        }
        return nova;
    }*/
    
template <typename T> lista<T>::lista() {
    atual = this->begin();
}

template <typename T> lista<T>::lista(const lista<T> & outra) {
    *this = outra;    
}

template <typename T> lista<T>::~lista() {
}

template <typename T> void lista<T>::insere(const T& algo) {
    this->push_front(algo);
}

template <typename T> void lista<T>::anexa(const T& algo) {
    this->push_back(algo);
}

template <typename T> int lista<T>::comprimento() const {
    return this->size();
}

template <typename T> void lista<T>::esvazia() {
    this->clear();
}

template <typename T> void lista<T>::insere(const T& algo, int posicao) {
    if (posicao >= this->size()) this->push_back(algo);
    else {
        typename std::list<T>::iterator it = this->begin();
    
        for (;posicao > 0; it++, posicao--);
        this->insert(it, algo);
    }
}

template <typename T> T& lista<T>::obtem(int posicao) const {
    if (posicao >= this->size()) throw -1;
    
    typename std::list<T>::const_iterator it = this->begin();
    for (;posicao > 0; it++, posicao--);
    return (T&)*it;
}

template <typename T> T& lista<T>::operator[](int pos) const {
    return obtem(pos);
}

template <typename T> void lista<T>::escrevaSe(std::ostream& out) const {    
    escrevaSe(out, "\n");
}

template <typename T> void lista<T>::escrevaSe(std::ostream& out, const std::string & delim) const {
    if (this->empty()) return;
    
    typename lista<T>::const_iterator it;
    int len = this->size();
    for (it = this->begin(); len > 1; it++, len--) {
        out << *it << delim;        
    }
    out << *it;
}

template <typename T> T lista<T>::remove(int posicao) {
    if (posicao >= this->size()) throw -1;

    typename std::list<T>::iterator it = this->begin();
    for (;posicao > 0; it++, posicao--);
    T dado = *it;
    this->erase(it);
    return dado;
}

template <typename T> void lista<T>::retira(const T& algo) {
    std::list<T>::remove(algo);
}

template <typename T> bool lista<T>::vazia() const {
    return this->empty();
}

template <typename T> void lista<T>::insereOrdenado(const T & algo) {
    typename std::list<T>::iterator it = this->begin();
    
    for (it = this->begin(); it != this->end(); it++) {
        if (*it > algo) break;
    }
    this->insert(it, algo);
}

template <typename T> void lista<T>::ordena() {
    this->sort();
}


template <typename T> T& lista<T>::procura(const T& algo) const {
    typename std::list<T>::const_iterator it = std::find(this->begin(), this->end(), algo);
    if (it == this->end()) throw -1;
    return (T&)*it;
}

template <typename T> lista<T>& lista<T>::procuraMuitos(const T& algo, lista<T>& outra) const {
    typename std::list<T>::const_iterator it = this->begin();
    
    while (true) {
        it = std::find(it, this->end(), algo);
        if (it == this->end()) break;
        outra.anexa(*it);
        it++;
    }
    
    return outra;    
}

template <typename T> std::shared_ptr<lista<T>> lista<T>::procuraMuitos(const T& algo) const {
    std::shared_ptr<lista<T>> outra(new lista<T>);
    procuraMuitos(algo, *outra.get());
    return outra;
}

template <typename T> lista<T>& lista<T>::operator=(const lista<T>& outra) {
    atual = outra.atual;
    static_cast<std::list<T>*>(this)->operator=(outra);
}

template <typename T> bool lista<T>::operator==(const lista<T>& outra) const {
    if (this->size() != outra.size()) return false;
    return std::equal(this->begin(), this->end(), outra.begin());    
}

template <typename T> void lista<T>::inverte() { 
    this->reverse();
}

template <typename T> bool lista<T>::inicio() const {
    return atual == this->begin();
}

template <typename T> bool lista<T>::fim() const {
    return atual == this->end();
}

template <typename T> void lista<T>::inicia() {
    atual = this->begin();
}

template <typename T> void lista<T>::iniciaPeloFim() {
    atual = this->end();
}

template <typename T> T& lista<T>::proximo() {
    if (atual == this->end()) throw -1;
    typename std::list<T>:: iterator it = atual;
    atual++;
    return *it;
}

template <typename T> T& lista<T>::anterior() {
    if (atual == this->begin()) throw -1;
    atual--;
    return *atual;
}

template <typename T> lista<T>& lista<T>::sublista(unsigned int pos1, unsigned int pos2, lista<T> & outra) const {   
    if ((pos1 >= this->size()) or (pos2 < pos1)) throw -1;
    if (pos2 >= this->size()) pos2 = this->size()-1;

    typename lista<T>::const_iterator it1, it2;
    pos2 -= pos1;
    for (it1 = this->begin();pos1 > 0; it1++, pos1--);
    for (it2 = it1;pos2 > 0; it2++, pos2--);
    
    std::copy(it1, it2, outra.begin());
    
    return outra;    
}

template <typename T> lista<T>* lista<T>::sublista(unsigned int pos1, unsigned int pos2) const {   
    lista<T> * outra = new lista<T>;
    try {
        sublista(pos1, pos2, *outra);
        return outra;
    } catch (int e) {
        delete outra;
        return nullptr;
    }
}

template <class T> void lista<T>::embaralha() {
    if (this->size() < 2) return;
    static bool _started = false;
    static std::default_random_engine generator;
    
    if (not _started) {
        auto t = std::chrono::high_resolution_clock::now();
        _started = true;
        generator.seed(std::chrono::high_resolution_clock::to_time_t(t));
    }
    shuffle(this->begin(), this->size(), generator);
}
  
template <class T> void lista<T>::shuffle(typename lista<T>::iterator p1, int len, std::default_random_engine & generator) {
    if (len < 2) return;
    
    static std::uniform_int_distribution<int> dist(0,1024); 
    
    typename lista<T>::iterator ptr;
    int n = len/2;
    for (ptr=p1; n > 0; n--,ptr++);
    
    shuffle(p1, len/2, generator);
    shuffle(ptr, len-len/2, generator);
        
    typename lista<T>::iterator i=p1, j=ptr;
    while (i != ptr and j != this->end()) {
        if (dist(generator) < 512) {
            T dado = *i;
            *i = *j;
            *j = dado;
        }
        i++;
        j++;
    }
    
}

} // fim namespace

#endif	/* LISTA_IMPL_H */

