## Auto-Completar Palavras

Manual do Usuário
> Objetivo:
Este software tem como objetivo auxiliar o usuário na digitação das palavras. Ou seja, ao
digitar parte de uma palavra (a partir do início da mesma), o software dará opções para que esteja
palavra seja completada de acordo com a necessidade do usuário.
> Para executar o programa, basta apenas compila-lo e executar, o arquivo de palavras
disponíveis está junto com os arquivos do programa (palavras.txt).
> Exemplo:O usuário digitou a seguinte frase
```shell
teste barb
```

> Após digitar a primeira palavra, ao pressionar a tecla TAB o software mostrará as palavras que
possuem as iniciais informadas pelo usuário:
0 Ignorar 1 barba 2 barbeador 3 barbeiro 4 barbie 5 barbicha

+ Caso o usuário aperte TAB, e exista apenas uma palavra com esse determinado prefixo, ele
irá auto completa-ló ;
+ Caso não exista nenhuma palavra relacionada com o prefixo, ele irá retornar para a linha de
onde ele estava (retorna o próprio o prefixo). Caso aperte TAB novamente para esse mesmo
prefixo, ele irá sempre copiá-lo.
+ Caso o usuário digite apenas espaço e aperte TAB, irá aparecer a lista de todas as palavras
disponíveis, o usuário deve então digitar a palavra desejada (numeração neste caso é
apenas para indicar a quantidade), ou ignorar, e continuar digitando as pŕoximas palavras
normalmente.
+ Caso aperte TAB e apareça mais que uma opção de palavras, pode se escolher a opção de
0 a 9, ou se tiver mais que 9 palavras, terá que digitar a palavra desejada.