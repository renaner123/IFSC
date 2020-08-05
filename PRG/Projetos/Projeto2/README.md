## Projeto 2 - Analisador de dados sobre IDHM

## Como executar o programa	    

+ Passo 1):
	Descompacte o arquivo do projeto;

+ Passo 2):
	Para executar o programa, abra o terminal do linux e digite o diretório onde se encontra o projeto, utilize make para compilar, e na execução deve ter como primeiro argumento da linha de comando, o caminho onde se encontra o arquivo idhm.csv

> exemplo:

```shell
aluno:/ home# ./aluno/netbeans/Idhm/dist/Debug/GNU-Linux/idhm home/aluno/Downloads/idhm.csv   ou   ./idhm home/aluno/Downloads/idhm.csv - caso já esteja no diretório do executavel.
```

>Onde: 

"./aluno/netbeans/Idhm/dist/Debug/GNU-Linux/idhm" Diretório para executar o projeto.

"home/aluno/Downloads/idhm.csv" Diretório onde o arquivo idhm.csv se encontra.


	
## Utilizando o programa
-------------------------------------------------------------------------------------------------------------------------------

### Buscar IDHM de um município: 

Dispõe das seguintes opções:


	1. Para listar todos os municipios:
		-> Mostra todos os municipios contidos no arquivo;
 	2. Para buscar IDHM de um município específico:	
		-> Usuário deve informar o municipio a ser localizado, programa não reconhece palavras com acentos, localiza municipios apenas sem acentos(Acento buga);
	3. Para retornar ao menu anterior.
		-> Retorna ao menu geral de opções.
--------------------------------------------------------------------------------------------------------------------------------


### Mostrar IDHM de um estado específico: 

Dispõe das seguintes opções:

	1. Para mostrar IDHM de um estado específico (Média)
		-> Usuário deve informar o código do estado desejado, caso o código esteja certo, terá como resultado
		o nome do estado, e a média do IDHM, IDHM_E, IDHM_R e IDHM_L de seus municípios;
	2. Para retornar ao menu anterior.
		-> Retorna ao menu geral de opções.


---------------------------------------------------------------------------------------------------------------------------------
### Mostrar quantos municípios com IDHM acima de determinado valor(limiar) possui cada estado: 


Dispõe das seguintes opções:

	1. Para mostrar quantos municípios com IDHM acima de determinado valor possui cada estado:
		-> O usuário precisa informar um valor de limiar de 0 a 1(numéro fracionário deve ser separado por "." ex.: 0.200)	
O resultado apresenta o nome de cada estado acompanhado da quantidade de municípios identificados. 
	2) Para retornar ao menu anterior.
		-> Retorna ao menu geral de opções.

---------------------------------------------------------------------------------------------------------------------------------

### Para ordenar N municipios: 

Dispõe das seguintes opções:

	1)Lista N municipios em Ordem Crescente:  
		-> Usuário deve informar um valor inteiro, que corresponde a quantidade a ser mostrada em ordem ascendente.
	2)Lista N municipios em Ordem Decrescente:  
		-> Usuário deve informar um valor inteiro, que corresponde a quantidade a ser mostrada em ordem descendente.
	3) Para retornar ao menu anterior.
		-> Retorna ao menu geral de opções.



