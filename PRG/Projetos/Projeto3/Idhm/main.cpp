#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <prglib.h>
#include "interface.h"
#include "idhm.h"

using namespace std;
using namespace prglib;
using prglib::thash;

int main(int argc, char** argv) {   
    
   string caminho, caminho_log;
     
        if(argc>2){   // Verifica se  o primeiro argumento é o caminho correto.
            caminho = argv[1];  
            caminho_log = argv[2];
            ifstream g(caminho);
            string linha;
            g >> linha;
            
            if(linha.size()==0){ 
                cout << "Arquivo vazio" << endl;
                return 0;
            }
            
            if(!g.is_open()){ 
                cout << "Erro ao abrir arquivo" << endl;
                return 0;
            }
        
        }
   
        else {
            cout << "caminho e caminho do log não estao no 1 e 2 segundo argumento" << endl;
            return 0;
        }
  
    Interface Inter(caminho, caminho_log);    
    //  Fornece o caminho para o construtor.    
 
    Inter.MenuPrincipal(0);       
    //  Chama o menu principal.
  
}