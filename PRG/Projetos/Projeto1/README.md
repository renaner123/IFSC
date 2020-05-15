>Esse software possui o objetivo de localizar arquivos dentro do sistema operacional Linux. Através de uma única linha de comando, é possível obter a listagem de todos os diretórios existentes a partir do diretório raiz. Outra função do software está na busca de arquivos como extensões determinadas pelo usuário (.txt, .pdf…).
O software possui como padrão de fábrica a localização através da busca em largura,
mas é possível realizar a busca pelo modo de profundidade, inserindo o argumento -P ou -p.

### Executando o Software
Para executar o software Enumerador, siga o procedimento abaixo:
1. Realize o download do software: Enumerador.zip
2. Descompacte o arquivo;
3. Entre no diretório onde o Enumerador foi descompactado: cd Enumerador
4. Compile o software. Para realizar a compilação, digite o comando: make
5. Execute o programa utilizando o comando: dist/Debug/GNU-Linux/enumerador ou
./enumerador caso esteja no diretório GNU-Linux
6. Ao executar o software conforme o passo anterior, sem nenhum argumento na linha
de comando, o software irá listar apenas os diretórios por busca em largura no
diretório /home.
7. Para buscar um tipo de arquivo ou extensão, o usuário poderá especificar a busca
utilizando os argumentos da tabela abaixo. O caminho inicial deverá ser sempre o
primeiro argumento na linha de comando.
8. O caminho inicial para as buscas deve ser informado como primeiro argumento da
linha de comando.
Método utilizado na busca:
Método Comando
Busca em largura -L ou -l
Busca em profundidade -P ou -p
2
Tipo de busca:
Tipo Comando
Diretório -d
Arquivo Regular -a
Link -link
Programa -p
Todos os resultados all ou ALL
Exemplos de utilização:
Buscar um determinado diretório:
./enumerador -> busca padrão de diretórios em /home
./enumerador /home -l txt   -> busca em largura extensão txt com início em /home
./enumerador /home -l -d   -> busca em largura todos os diretórios apartir /home
./enumerador /home -p Fotos  -> busca em profundidade arquivos nome Fotos
Observações:
- Caso deseje escolher uma extensão, poderá tanto digitar o nome quanto apenas sua
extensão sem o uso de “.”
Ex.: “text.txt” ou apenas “txt”.
- O software não permite ter mais de um argumento de cada tipo na linha de comando.
Ex.: Não é permitido ter simultaneamente nos argumentos (“-d” e “-a”) ou (“text.txt”
e “txt”).




