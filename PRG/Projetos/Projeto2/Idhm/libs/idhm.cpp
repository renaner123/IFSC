#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
#include "idhm.h"


using namespace std;
using namespace prglib;

Idhms::Idhms(string caminho) {
    
    fstream f(caminho);
    f.ignore(24000, '\n');
    if (not f.is_open()) {
        cout << "Não foi possível abrir o arquivo" << endl;
    }
    lista<IDHM> tab;      // cria lista de struct
    
    string linha;
    while (getline(f, linha)) {
        // processa linha
        try {
            IDHM dado(linha);            // cria objeto dado com uma linha do arquivo e salva na sctruc dado
            // cout << dado.ano << " " << dado.idhm << endl;            
            usar.anexa(dado); //        anexa na lista geral
            contar_mun.anexa(dado.uf);
        } catch (...) {
            cout << "+++ Erro: " << linha << endl;  // se tiver alguma linha fora do padrao vai aparecer
        }
    

    }  
      
    
}


void Idhms::buscar() { // pra testar    

    cout << usar.comprimento() << endl;
    usar.inicia();                            // apenas uns teste pra ver se a lista esta certa
    IDHM teste;
    
    while(!usar.fim()){
        teste = usar.proximo();
        cout << teste.municipio << endl;    }
  
}    

    
    void Idhms::IDHM_Mun(string Mun){
        
        usar.inicia();
        IDHM teste2;
        
        while(!usar.fim()){
            teste2 = usar.proximo();
            if(teste2.municipio == Mun)
                   cout << teste2.ano << " " << teste2.uf <<" " << teste2.municipio << " " << teste2.idhm << " " << teste2.idhm_e << " " << teste2.idhm_l << " " << teste2.idhm_r << endl;             
        }
        cout << endl; 
    }


    void Idhms::Maiores_IDHM(int Qtd_Maior) {
    
    }

    void Idhms::Menores_IDHM(int Qtd_Menor) {
    
    }
    
    void Idhms::IDHM_Estado(int estado) {        
        
        usar.inicia();        
        IDHM Media_estado;
       // string estado_str;
        
        
        double aux_IDHM=0,aux_IDHM_E=0,aux_IDHM_L=0,aux_IDHM_R=0,media;
        double Media_aux_IDHM=0,Media_aux_IDHM_E=0,Media_aux_IDHM_L=0,Media_aux_IDHM_R=0;
        int cont =0;
        while(!usar.fim()){
            Media_estado = usar.proximo();
            
            if(Media_estado.uf==estado){
                aux_IDHM = Media_estado.idhm + aux_IDHM;
                aux_IDHM_E = Media_estado.idhm_e + aux_IDHM_E;
                aux_IDHM_L = Media_estado.idhm_l + aux_IDHM_L;
                aux_IDHM_R = Media_estado.idhm_r + aux_IDHM_R;
                cont = cont +1;
            }
   
        }
                
            Media_aux_IDHM = aux_IDHM / cont;
            Media_aux_IDHM_E = aux_IDHM_E / cont;
            Media_aux_IDHM_L = aux_IDHM_L /  cont;
            Media_aux_IDHM_R = aux_IDHM_R / cont;
        
    cout << estado_str <<" IDHM:" << Media_aux_IDHM << " IDHM_E:" << Media_aux_IDHM_E << " IDHM_L:" << Media_aux_IDHM_L <<" IDHM_R:" << Media_aux_IDHM_R << endl;
    
    }
    
    void Idhms::IDHM_Limiar(double Idhm_Limiar) {      
        /*Criar funçao pra tirar ufs repitidas e salvar em uma lista
         ai cada valor proximo compara com toda lista usar e faz um contator se for igual e > limiar
         no final salva o valor da lista de uf e o contator. 
         */
        Separar_Ufs();
        
        lista<int> estado1, qtd_municipio;
        
        IDHM Mun_conta;
        usar.inicia();
        contar_mun.inicia();
        int uf=0,cont_mun=0,k=0,soma=0,pega;
        usar.inicia();
                
        for(int cont=0; cont<contar_mun.comprimento();cont++){
            pega = contar_mun.obtem(cont);
            usar.inicia();
            while(!usar.fim()){               
                Mun_conta=usar.proximo();        
                if((pega==Mun_conta.uf)&&(Mun_conta.idhm>Idhm_Limiar)) soma= soma+1;
            }
                
           estado1.anexa(pega);
           qtd_municipio.anexa(soma);
           soma =0;
   
            
        }
        
        cout << endl;
        
        estado1.inicia();
        qtd_municipio.inicia();
        
        
        while(!qtd_municipio.fim()) {
            int muda = estado1.proximo();
            Estado(muda);
            
            cout << estado_str << " Quantidade: " << qtd_municipio.proximo() << endl;
        }

        
        cout << endl;
        
        
       
        
        
        
        
        
    }
  
    
    int Idhms::Estado(int codigo){
    if(codigo ==11){
        estado_str = "Rondônia/RO";
    }
    if(codigo ==12){
        estado_str = "Acre/AC";
    }
    if(codigo ==13){
        estado_str = "Amazonas/AM";
    }
    if(codigo ==14){
        estado_str = "Roraima/RR";
    }
    if(codigo ==15){
        estado_str = "Pará/PA";
    }
    if(codigo ==16){
        estado_str = "Amapa/AP";
    }
    if(codigo ==17){
        estado_str = "Tocantis/TO";
    }
    if(codigo ==21){
        estado_str = "Maranha/MA";
    }
    if(codigo ==22){
        estado_str = "Piaui/PI";
    }
    if(codigo ==23){
        estado_str = "Ceara/CE";
    }
    if(codigo ==24){
        estado_str = "Rio Grande do Norte/RN";
    }
    if(codigo ==25){
        estado_str = "Paraiba/PB";
    }
    if(codigo ==26){
        estado_str = "Pernambuco/PE";
    }
    if(codigo ==27){
        estado_str = "Alagoas/AL";
    }
    if(codigo ==28){
        estado_str = "Sergipe/SE";
    }
    if(codigo ==29){
        estado_str = "Bahia/BA";
    }
    if(codigo ==31){
        estado_str = "Minas Gerais/MG";
    }
    if(codigo ==32){
        estado_str = "Espirito Santo/ES";
    }
    if(codigo ==33){
        estado_str = "Rio de Janeiro/RJ";
    }
    if(codigo ==35){
        estado_str = "São Paulo/SP";
    }
    if(codigo ==41){
        estado_str = "Parana/PR";
    }
    if(codigo ==42){
        estado_str = "Santa Catarina/SC";
    }
     if(codigo ==43){
        estado_str = "Rio Grande do Sul/RS";
    }
     if(codigo ==50){
        estado_str = "Mato Grosso do Sul/MS";
    }
     if(codigo ==51){
        estado_str = "Mato Grosso/MT";
    }
     if(codigo ==52){
        estado_str = "Goais/GO";
    }
     if(codigo ==53){
        estado_str = "Distrito Federal/DF";
    }
}
    
    
    void Idhms::Separar_Ufs() {
      
       lista<int> Aux_cont;       
  
       int i=0,t=0;
        
       for(int i =0;i<contar_mun.comprimento();i++){          
           int algo=contar_mun.obtem(i);
           contar_mun.retira(algo);           
           contar_mun.insere(algo);          
           Aux_cont.anexa(algo);           
        }
        
       
       
        
        
      
    }
    