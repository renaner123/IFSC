
#include <iostream>
#include "interface.h"
#include "idhm.h"
#include <prglib.h>


Interface::Interface(int e) : Tele("/home/renan/Downloads/idhm.csv") {

}

Interface::~Interface() {
}







int Interface::MenuPrincipal() {
    int op, op2,codigo; //  Variáveis de controle para os switch case
    string Mun; //  String nome e int bytes: variaveis passadas como parametro
    double limiar;

    while (1) {  //  Criação do looping para o usuário fazer sua busca

        cout << "                               ..:Bem vindo ao localizador de arquivos!!:.." << endl;
        cout << "Escolha sua opção: " << endl;
        cout << "1- Para localizar IDHM de um municipio;" << endl;
        cout << "2- Para localizar IDHM de um estado;" << endl;
        cout << "3- Para localizar IDHM por um limiar;" << endl;
        cout << "4- Para sair do localizador." << endl;

        cin >> op;
  
        switch (op) {
            case 1: while (1) {
                    cout << "1- Para listar todos os municipios;" << endl;
                    cout << "2- Para localizar algum Municipio especifico;" << endl;
                    cout << "3- Para retornar ao menu anterior." << endl;
                    cin >> op2;

                    switch (op2) {
                        case 1: 
                            Tele.buscar();
                            break;
                        case 2:     
                            cout <<"Digite municipio" << endl;  
                            cin.ignore();
                            getline (cin,Mun);
                            Tele.IDHM_Mun(Mun);
                            break;                           
                        case 3: MenuPrincipal();;               
                    }
           
            
            }

            case 2: while (1) {
                    cout << "1- Para mostrar média de um estado;" << endl;                
                    cout << "3- Para retornar ao menu anterior." << endl;
                    cin >> op2;

                    switch (op2) {
                        case 1: 
                            cout <<"Digite código do estado" << endl;
                            cin >> codigo;       
                            Tele.Estado(codigo);
                            Tele.IDHM_Estado(codigo);
                            cout << endl;
                            break;
                        case 2:                       
                                                      
                        case 3: MenuPrincipal();;               
                    }
                      
            }
             case 3: while (1) {
                    cout << "1- Contar Municipios dos estados com base num limiar" << endl;                
                    cout << "3- Para retornar ao menu anterior." << endl;
                    cin >> op2;

                    switch (op2) {
                        case 1: 
                            cout << "Digite um Limiar" << endl;
                            cin >> limiar;
                            Tele.IDHM_Limiar(limiar);
                            break;
                        case 2:                       
                                                     
                        case 3: MenuPrincipal();;               
                    }
                      
            }   
                
                
                
                
                
                
            case 4: return 0; //  Encerra o programa
        }
    

    
    
     
    }
}


