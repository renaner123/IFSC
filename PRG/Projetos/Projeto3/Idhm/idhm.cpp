#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
#include "idhm.h"
#include "interface.h"

using namespace std;
using namespace prglib;
using prglib::thash;

Idhms::Idhms(string caminho,string caminho_log) : tab_base(119){ 
//Recebe o caminho para construir a lista base.
    
string linha;
ifstream Caminho(caminho);     
ofstream salva_log(caminho_log);
thash<IDHM> tab_inco(1119);
    
    if(!Caminho.is_open()) cout <<" Erro" << endl;
    //Tabela para guardar as incosistências;
  
    while (getline(Caminho, linha)) {
        try {              
            IDHM dado(linha);  
            //Manda a linha para o construtor retornar o objeto dado;
            
            dado.chave2 = linha;    
            tab_base.adiciona(dado.chave2,dado);
            //Usando a linha como chave, será redundância se tiver linha repetida;
                
        } 
        catch (...) {
            cout << "+++ Erro: na linha: " << linha << endl;
            //Se houver alguma linha fora do padrão vai aparecer.
        }
    } 
  
auto valores1 = tab_base.valores();   
//Gera uma lista que aponta pros valores da tabela base;
    
valores1->inicia();
    
//Colunas ANO, UF, Codmun6, Codmun7 e Município são únicas;
string uff,anoo,seis,sete,testa1,testa2,testa3,testa4;
//Variáveis para testar se tem inconsistência;
//testa2 -> ano + 6 + 7 + municipio
//testa1 -> ano + uf + 6 + 7 
//testa3 -> 6 + 7 + ano
//testa4 -> uf + municipio + ano
    
IDHM teste_aux,teste_incos1,teste_incos2,teste_incos3,teste_incos4,imprimi_certo;           
//Objetos para cada teste realizado
auto valores2 = tab_base.valores();
//Gera lista que aponta para os valores e chaves da tabela base
auto chaves2 = tab_base.chaves();
    
chaves2->inicia();
valores2->inicia();
int conta_incons = 0,cont_testa1=0,cont_testa2=0,cont_testa3=0,cont_testa4=0;                
// variaveis pra contar inconsitencias, e caso tenha uma linha com 2 possiveis inconsistencia, ele não ira fazer caso ja tenha feito em outro teste

    while(!valores2->fim()){
        teste_aux = valores2->proximo();
        //converte os dados que devem ser unicos para string, para faciliar os testes
        anoo = to_string(teste_aux.ano);
        seis = to_string(teste_aux.Codmun6);
        sete = to_string(teste_aux.Codmun7);
        uff = to_string(teste_aux.uf);
        testa1=anoo+seis+sete+uff;                                              
        //Primeiro teste de inconsitencia;
       
    try{
        if(tab_inco.existe(testa1)){        //Adiciona na tabela de incon os valores da tabela base;         
            teste_incos1=tab_inco[testa1];  //Caso o proximo valor da tabela base corresponda a alguma ja salvo na tabela
            conta_incons ++;                //vai salvar os dois valores encontrados no arquivo de log
            cont_testa1++;                  //e remove-los da tabela base
                                            //testa2,testa3,testa4 funcionam dessa mesma forma.
            if(cont_testa1==1){
                salva_log << teste_incos1.ano << "," <<  teste_incos1.uf << ","<< teste_incos1.Codmun6 << "," << teste_incos1.Codmun7 << "," << teste_incos1.municipio << "," << teste_incos1.idhm << ","<< teste_incos1.idhm_e <<","<<teste_incos1.idhm_l<<","<<teste_incos1.idhm_r<< endl;
                salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                tab_base.remove(teste_incos1.chave2);                               
                //Se é o primeiro teste salva os dois no log;
                tab_base.remove(teste_aux.chave2);
            }
            else{
                salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                tab_base.remove(teste_aux.chave2);                                 
                // se já teve algum, salva apenas um valor.
            }
    
        }
            
        else{
            tab_inco.adiciona(testa1,teste_aux);
        }
    }
        
    catch (...) {}
    //testa2 funciona como descrito no testa1
        testa2=anoo+seis+sete+teste_aux.municipio;    
       
            if(cont_testa1==0){
            //Caso o outro teste estiver com contador em 0, ele fará o testa4, caso contrario, já foi realiado um teste de incosistencia com o valor da tabela base
                try{ 
                    if(tab_inco.existe(testa2)){
                        teste_incos2=tab_inco[testa2];        
                        conta_incons ++;
                        cont_testa2++;
            
                        if(cont_testa2==1){
                            salva_log << teste_incos2.ano << "," <<  teste_incos2.uf << ","<< teste_incos2.Codmun6 << "," << teste_incos2.Codmun7 << "," << teste_incos2.municipio << "," << teste_incos2.idhm << ","<< teste_incos2.idhm_e <<","<<teste_incos2.idhm_l<<","<<teste_incos2.idhm_r<< endl;
                            salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                            tab_base.remove(teste_incos2.chave2);           
                            //Se é o primeiro teste salva os dois no log
                            tab_base.remove(teste_aux.chave2);
                        }
                            
                        else{
                            salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                            tab_base.remove(teste_aux.chave2);              
                            //Se já teve algum, salva apenasu um valor
                        }
                    }
                    
                    else{
                        tab_inco.adiciona(testa2,teste_aux);   
                    } 
                    
                }
                
                catch (...) {}
            }
            else continue;
      
        
testa3=anoo+seis+sete;
// testa3 funciona como descrito no testa1
        
    if ((cont_testa1==0)&&(cont_testa2==0)){
    //caso os outros testes estiverem com contador em 0, ele fará o testa4, caso contrario, já foi realiado um teste de incosistencia com o valor da tabela base
        try{ 
            if(tab_inco.existe(testa3)){
                teste_incos3=tab_inco[testa3];        
                conta_incons ++;
                cont_testa3++;
            
                if(cont_testa3==1){
                    salva_log << teste_incos3.ano << "," <<  teste_incos3.uf << ","<< teste_incos3.Codmun6 << "," << teste_incos3.Codmun7 << "," << teste_incos3.municipio << "," << teste_incos3.idhm << ","<< teste_incos3.idhm_e <<","<<teste_incos3.idhm_l<<","<<teste_incos3.idhm_r<< endl;
                    salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                    tab_base.remove(teste_incos3.chave2);               
                    //Se é o primeiro teste salva os dois no log;
                    tab_base.remove(teste_aux.chave2);
                }
                        
                else{
                    salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                    tab_base.remove(teste_aux.chave2);                  
                    //Se á teve algum, salva apenasu um valor;
                }
            
            }
                
            else{
                tab_inco.adiciona(testa3,teste_aux);  
            }
                
        }
        catch (...) {}
    }
    else continue;
        
    testa4=uff+teste_aux.municipio+anoo;                                        
    // testa4 funciona como descrito no testa1
        if ((cont_testa1==0)&&(cont_testa2==0)&&(cont_testa3==0)){              
        //caso os outros testes estiverem com contador em 0, ele fará o testa4, caso contrario, já foi realiado um teste de incosistencia com o valor da tabela base
            try{ 
                if(tab_inco.existe(testa4)){
                    teste_incos4=tab_inco[testa4];        
                    conta_incons ++;
                    cont_testa4++;
                        if(cont_testa4==1){
                            salva_log << teste_incos4.ano << "," <<  teste_incos4.uf << ","<< teste_incos4.Codmun6 << "," << teste_incos4.Codmun7 << "," << teste_incos4.municipio << "," << teste_incos4.idhm << ","<< teste_incos4.idhm_e <<","<<teste_incos4.idhm_l<<","<<teste_incos4.idhm_r<< endl;
                            salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                            tab_base.remove(teste_incos4.chave2);               
                            // se é o primeiro teste salva os dois no log
                            tab_base.remove(teste_aux.chave2);
                        }
                        
                        else{
                            salva_log << teste_aux.ano << "," <<  teste_aux.uf << ","<< teste_aux.Codmun6 << "," << teste_aux.Codmun7 << "," << teste_aux.municipio << "," << teste_aux.idhm << ","<< teste_aux.idhm_e <<","<<teste_aux.idhm_l<<","<<teste_aux.idhm_r<< endl;
                            tab_base.remove(teste_aux.chave2);                  
                            // se já teve algum, salva apenasu um valor
                        }
            
                }
                
                else{
                    tab_inco.adiciona(testa4,teste_aux);
                } 
            }
            catch (...) {}
        }
        else continue;
        
    cont_testa1=0,cont_testa2=0,cont_testa3=0,cont_testa4=0;
      
    }
    
conta_inconsistencia = conta_incons;
auto valores3 = tab_base.valores();
ofstream salva_arq_dados(caminho);                                          
// abre o arquivo de dados pra escrita, e escreve os daods sem redundancia e inconsistencia
   
//ANO,UF,Codmun6,Codmun7,Município,IDHM,IDHM_E,IDHM_L,IDHM_R
valores3->inicia();
    while(!valores3->fim()){
        imprimi_certo = valores3->proximo();
        salva_arq_dados << imprimi_certo.ano << "," <<  imprimi_certo.uf << ","<< imprimi_certo.Codmun6 << "," << imprimi_certo.Codmun7 << "," << imprimi_certo.municipio << "," << imprimi_certo.idhm << ","<< imprimi_certo.idhm_e <<","<<imprimi_certo.idhm_l<<","<<imprimi_certo.idhm_r<< endl;
    }
        
}

 int Idhms::Codmun6(int codigo_mun){
     
thash<lista<IDHM>> Busca_Mun(1119);
auto valores_tab_base = tab_base.valores();
//Cria uma lista com os valores da tab_base;

string Converte = to_string(codigo_mun); 
//Convertendo pra string pra facilitar as buscas na tabela;

valores_tab_base->inicia();

IDHM buscar,mostrar_Busca;
//Structs para trabalhar com os valores

lista<IDHM> listar_Codmun6_repetido; 
//Lista pra guardar dados de um mesmo municipio
    
    while(!valores_tab_base->fim()) {
        buscar = valores_tab_base->proximo();                       
                                                                                                                            
        if(Busca_Mun.existe(Converte)){
            listar_Codmun6_repetido = Busca_Mun[Converte];                      
            //Enquanto a lista de dados não chega no fim, caso já tenha o codigo_mun
            //na chave, recebe o valor da tabela em uma lista, e anexa na lista o novo valor
            //do codigo_mun, e adiciona novamente a tabela.
            //Mas nesse caso, deixei apenas uma chave com o mesmo codigo_mun, 
            //e salvei todos os valores na lista, ao invés de criar uma chave pra cada codigo_mun                                                                   
            
            listar_Codmun6_repetido.anexa(buscar);                              
            Busca_Mun.adiciona(Converte,listar_Codmun6_repetido);               
        }
        
        else {
            listar_Codmun6_repetido.anexa(buscar);
            Busca_Mun.adiciona(Converte,listar_Codmun6_repetido);
        }
    }

int conta_certo =0;                                                         
//Incrementa caso não encontre nada na lista, se for igual ao comprimento da lista, quer dizer que não possui o código informado.

    if(Busca_Mun.existe(Converte)){      
        auto buscar2 = Busca_Mun[Converte];
        buscar2.inicia();                                                        
        //Como a chave é a mesma, listei apenas os valores(que é uma lista de struct);
        
            while(!buscar2.fim()){                                                   
            //Caso o cod_mun6 corresponda com o que foi informado, será retornado os valores dele.
                int Cod_Mun = stoi(Converte);                                         
                mostrar_Busca = buscar2.proximo();
                    if(mostrar_Busca.Codmun6==Cod_Mun){               
                        cout << mostrar_Busca.ano << "," <<  mostrar_Busca.uf << ","<< mostrar_Busca.Codmun6 << "," << mostrar_Busca.Codmun7 << "," << mostrar_Busca.municipio << "," << mostrar_Busca.idhm << ","<< mostrar_Busca.idhm_e <<","<<mostrar_Busca.idhm_l<<","<<mostrar_Busca.idhm_r<< endl;
                    }
                
                    else conta_certo ++;
            }
             
       
    if(buscar2.comprimento()==conta_certo){                            // 
        cout << "Codigo Municio 6  não encontrado no arquivo" << endl;
        cout << endl;
    }
       
    conta_certo =0; 
       
       
    }
    
 }
    

void Idhms::IDHM_Mun(string Municipio_Espec) {
    
thash<lista<IDHM>> Busca_Mun(1119);
auto valores_tab_base = tab_base.valores(); 
//Cria uma lista com os valores da tab_base

valores_tab_base->inicia();
IDHM buscar,mostrar_Busca;              
//Structs para trabalhar com os valores

lista<IDHM> listar_mun_repetido;        
//Lista pra guardar dados de um mesmo municipio
    
    while(!valores_tab_base->fim()) {
        buscar = valores_tab_base->proximo();                            
        //Enquanto a lista de dados não chega no fim, caso já tenha o municipio
        //na chave, recebe o valor da tabela em uma lista, e anexa na lista o novo valor
        //do municipio, e adiciona novamente a tabela.
        //Mas nesse caso, deixei apenas uma chave com o mesmo municipio, 
        //e salvei todos os valores na lista, ao invés de criar uma chave pra cada municpio
            
        if(Busca_Mun.existe(Municipio_Espec)){                           
                listar_mun_repetido = Busca_Mun[Municipio_Espec];            
                listar_mun_repetido.anexa(buscar);                           
                Busca_Mun.adiciona(Municipio_Espec,listar_mun_repetido);
            
            }
            else {
                listar_mun_repetido.anexa(buscar);                            
                //Caso ainda não exista uma municipio com o valor da chave, adiciona o valor na lista e adiciona na tabela.
                
                Busca_Mun.adiciona(Municipio_Espec,listar_mun_repetido);
            }
    }

string minusculo = Municipio_Espec;
int qtd = minusculo.size();
//Passa pra minusculo o que o usuário digitar, pra localizar o municipio. 
//Caso ele não digite em Maiusculo como está no arquivo
    
    for(int i=0;i<minusculo.size();i++){
      minusculo[i] = toupper(minusculo[i]);
    }
      
int conta_certo =0;                                                   
//Incrementa caso não encontre nada na lista, se for igual ao comprimento da lista, quer dizer que não possui o municio informado.
//Como a chave é a mesma, listei apenas os valores(que é uma lista de struct).   
//Caso o municipio corresponda com o que foi informado, será retornado os valores dele.

    if(Busca_Mun.existe(Municipio_Espec)){  
       auto buscar2 = Busca_Mun[Municipio_Espec];     
       buscar2.inicia();                                                  
      
            while(!buscar2.fim()){
                mostrar_Busca = buscar2.proximo();
                    
                    if((mostrar_Busca.municipio==Municipio_Espec)||(mostrar_Busca.municipio==minusculo)){                                                                                                    // vai listar todos os municipios que tem na tabela
                        cout << mostrar_Busca.ano << "," <<  mostrar_Busca.uf << ","<< mostrar_Busca.Codmun6 << "," << mostrar_Busca.Codmun7 << "," << mostrar_Busca.municipio << "," << mostrar_Busca.idhm << ","<< mostrar_Busca.idhm_e <<","<<mostrar_Busca.idhm_l<<","<<mostrar_Busca.idhm_r<< endl;
                    }
                    
                    else conta_certo ++;
       
            }
   
            if(buscar2.comprimento()==conta_certo){                            // 
                cout << "Municipio não encontrado no arquivo, ou possui acentos" << endl;
                cout << endl;
            }
       
        conta_certo =0;
      
    }
           
} 
 
int Idhms::Testa_Incon(int cont){    
    conta_inconsistencia;                                               
    // método pra verificar se tem inconsistência caso tenha termina o programa;
        
    return conta_inconsistencia;
    
}


  
    
 
        
