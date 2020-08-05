
#include <iostream>
#include "interface.h"
#include "idhm.h"
#include <prglib.h>
using prglib::thash;


Interface::Interface(string e, string u) : Tele(e,u) {  
//  Recebe o caminho como primeiro argumento e cria com o construtor.

}

Interface::~Interface() {
}




//  Método que recebe o menu do analisador de IDHM.
int Interface::MenuPrincipal(int e) {   

    if(Tele.Testa_Incon(0)>0) {
            cout <<"Arquivo possui " << Tele.Testa_Incon(0) << " inconsistências" <<  endl;
            return 0;
}
    

//  Variáveis de controle para os switch case,
//  assim como as variaveis passadas como parametro.
    
    int op, op2,N=0,codigo,N_Maiores,N_Menores; 
    string Municipio_Espec;
    int codigo_municipio=0;        
    
    

while (1) {  
//  Criação do looping para o usuário realizar a busca.

    cout << "Escolha sua opção: " << endl;
    cout << "1- Para buscar IDHM de um município;" << endl;
    cout << "2- Para sair do analisador de dados sobre IDHM." << endl;
   
    cin >> op;
  
    switch (op) {
        case 1: 
            while (1) { 
                cout << "1- Para buscar usando um nome municipio;" << endl;
                cout << "2- Para buscar usando codmun6;" << endl;
                cout << "3- Para retornar ao menu anterior." << endl;
                cin >> op2;

                switch (op2) {
                    case 1:     
                        cout <<"Digite municipio conforme está no arquivo" << endl;  
                        
                        try{
                            cin.ignore();
                            getline (cin,Municipio_Espec); 
                            cout << "Aguarde enquanto a procura é feita" << endl; 
                            Tele.IDHM_Mun(Municipio_Espec);
                            
                          }catch(...){}                   
                        //  Para acessar o método IDHM_Mun e retornar as informações
                        break;    
                    
                    
                    case 2: cout <<"Digite o código do municipio desejado" << endl; 
                            cin >> codigo_municipio;
                            cout << "Aguarde enquanto a procura é feita" << endl;    
                            Tele.Codmun6(codigo_municipio);
                            
                    //  Chama metódo para mostrar todos os estados com seus respectivos idhms.
                        break;
                            
                    
                        
                        //  Usa como parâmetro o município informado pelo usuario
                
                         
            
                    case 3: 
                        return MenuPrincipal(0);
        
                }
       
            }

                 
       
                
                       
        case 2:  
            return 0;
                  
    }
    
}


}
