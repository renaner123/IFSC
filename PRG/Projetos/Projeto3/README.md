## Limpador de dados

## Executando o software
   
> Para executar o programa, abra o terminal do linux e digite o diretório onde se encontra
o projeto, utilize make para compilar. Na execução, deve ter como primeiro argumento da linha
de comando o caminho onde se encontra o arquivo idhm-raw.csv e o segundo argumento será
o caminho onde o log será salvo.

 >exemplo:

+ primeiro argumento -> /home/aluno/Downloads/idhm-raw.csv
+ segundo argumento -> /home/aluno/Downloads/log.txt
```shell
aluno: ./idhm /home/aluno/Downloads/idhm-raw.csv /home/aluno/Downloads/log.txt
```
Se ao menos uma inconsistência ocorrer na hora da execução, o
programa termina e alerta o usuário. Nesse caso, cabe ao usuário analisar o
arquivo de log e selecionar as linhas com os dados corretos, e ao final copiá-las para o arquivo
de dados. Quando o arquivo de dados estiver correto, o usuário poderá fazer uma nova
execução do programa para conseguir fazer as consultas aos dados carregados.


## Utilizando o programa

>Ao inicializar o software, são mostradas as seguintes opções, caso o arquivo não tenha
nenhuma inconsistência:

1. Para buscar IDHM de um município.
1. Para sair do analisador de dados sobre IDHM.

> Caso a opção escolhida tenha sido a de número "1", são apresentadas as seguintes opções:
> 
1. Para buscar usando um nome municipio.
1. Para buscar usando codmun6.
1. Para retornar ao menu anterior.

> Se a opção "1" foi selecionada, será apresentada a seguinte informação na tela:
"Digite município conforme está no arquivo:"
Caso contenha o município no arquivo, será retornado os dados dele.

> Se a opção "2" foi selecionada, será apresentada a seguinte informação na tela:
"Digite o código do município desejado"
Caso contenha o código do município no arquivo, será retornado os dados dele.


## Restrições da aplicação

>Linhas redundantes devem ser retiradas do arquivos.
Dados fica sem linhas redundandtes.
Se existir inconsistência todas as linhas envoldidas devem ser retiradas do arquivo e salvas em um arquivo de log.
Arquivo de log com inconsistência;
Se tiver ao menos 1 inconsistência, o programa termina e avisa ao usuário.
Se não tiver nenhuma incosistência, tratar o arquivo e possibilita as buscas.



