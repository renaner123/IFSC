## Lista 3: Normalização

### Respostas

1. Verdadeira

    ```txt
    6 grande -> vale

    6 pequeno -> vale

    3 pequeno -> vale

    3 grande -> vale
    ```

1. Verdadeira
    ```txt
    6 -> vale

    3 -> vale
    ```

1. Falso
    ```
    preto -> 5

    preto -> 4
    ```
1. Falso
    ```
    Vale -> 6

    Vale -> 3
    ```
1. Falso
    ```
    6 grande antigo -> preto 5 vale centimetro

    6 grande antigo -> prata 5 vale centimetro
    Falso

    6 pequeno antigo -> prata 4 vale centimetro
    Verdade

    3 grande novo -> preto 4 vale polegada
    Verdade

    3 grande antigo -> preto 4 vale polegada
    Verdade

    3 pequeno novo -> preto 4 vale polegada
    Verdade
    ```

1.

A → B, em uma relação R, será uma dependência transitiva se existir um
conjunto de atributos C que não é uma chave candidata e nem um
conjunto qualquer de chaves de R, e ambas A → C e C → B forem
asseguradas

### Uma relação R estará na 3FN se
* satisfazer a 2FN(dependência funcional total); e
* não possuir atributos que não pertençam a uma chave,
funcionalmente determinados por outro atributo (ou conjunto de
atributos) que também não pertença a uma chave.
  * Todo atributo não-chave não pode ser transitivamente dependente da
chave primária

### 1FN

| __estudante_ | __professor_ | __Disciplina_ | fase | Sala     | Nota | Livro             | profEmail  |
|-----------|-----------|------------|------|----------|------|-------------------|------------|
| Clerina   | Rosa      | CAL        | 4f   | Sala 16  | 6    | Cálculo integral  | rosa@ifsc  |
| João      | Carlos    | BCD        | 1f   | LabSW II | 7    | Sistemas BD       | c@ifsc     |
| João      | Juca      | POO        | 2f   | LabProg  | 8    | Como programar OO | ju@ifsc    |
| Ana       | Carlos    | BCD        | 1f   | LabSW II | 6    | Sistemas BD       | c@ifsc     |
| Jucelina  | Rosa      | CAL        | 4f   | Sala 16  | 8    | Cálculo integral  | rosa@ifsc  |
| Silvia    | Juca      | STD        | 5f   | LabSW I  | 4    | SD: teoria        | ju@ifsc    |
| Célia     | Rosso     | CAL        | 4f   | Sala 15  | 3    | Cálculo integral  | rosso@ifsc |


{professor, Disciplina} -> fase, Sala, Livro, profEmail

| professor | Disciplina | fase | Sala     |  Livro             | profEmail  | estudante  |
|-----------|------------|------|----------|--------------------|------------|------------|
| Rosa      | CAL        | 4f   | Sala 16  |  Cálculo integral  | rosa@ifsc  | Clerina    |
| Carlos    | BCD        | 1f   | LabSW II |  Sistemas BD       | c@ifsc     | João       |
| Juca      | POO        | 2f   | LabProg  |  Como programar OO | ju@ifsc    | João       |
| Carlos    | BCD        | 1f   | LabSW II |  Sistemas BD       | c@ifsc     | Ana        |
| Rosa      | CAL        | 4f   | Sala 16  |  Cálculo integral  | rosa@ifsc  | Jucelina   |
| Juca      | STD        | 5f   | LabSW I  |  SD: teoria        | ju@ifsc    | Silvia     |
| Rosso     | CAL        | 4f   | Sala 15  |  Cálculo integral  | rosso@ifsc | Célia      |


| estudante | Nota |  
|-----------|------|
| Clerina   |6    |  
| João      |7    |   
| João      |8    |   
| Ana       |6    |   
| Jucelina  |8    |   
| Silvia    |4    |  
| Célia     |3    | 

7. 

| uID | email   | Nome      | Sobrenome | Cidade        | Estado | CEP       |
|-----|---------|-----------|-----------|---------------|--------|-----------|
| 123 | jo@ifsc | João      | Silva     | São José      | SC     | 88103-310 |
| 456 | aa@ifsc | Ana       | Silva     | São Paulo     | SP     | 19223-120 |
| 789 | ht@ifsc | Hélio     | Trave     | Florianópolis | SC     | 88223-540 |
| 432 | fb@ifsc | Francisco | Bulie     | Curitiba      | PR     | 44203-155 |
| 222 | hf@ifsc | Hélio     | Feitosa   | Curitiba      | PR     | 44433-000 |

(a) Essa tabela está na 1FN?;

```
    Sim. Possui somente valores atômicos
```

(b) Essa tabela está na 2FN?;

    Sim, possui dependência total já que tem somente uma chave

(c) Essa tabela está na 3FN? Se não estiver, então normalize-a para a 3FN.

    Não, Estado é transitivamente a Cidade

| uID | email   | Nome      | Sobrenome |CEP       |
|-----|---------|-----------|-----------|-----------|
| 123 | jo@ifsc | João      | Silva     | 88103-310 |
| 456 | aa@ifsc | Ana       | Silva     | 19223-120 |
| 789 | ht@ifsc | Hélio     | Trave     | 88223-540 |
| 432 | fb@ifsc | Francisco | Bulie     | 44203-155 |
| 222 | hf@ifsc | Hélio     | Feitosa   | 44433-000 |


|CEP         | Cidade        | Estado | 
|-----------|---------------|--------|
| 88103-310 | São José      | SC     |
| 19223-120 | São Paulo     | SP     |
| 88223-540 | Florianópolis | SC     |
| 44203-155 | Curitiba      | PR     |
| 44433-000 | Curitiba      | PR     |

8. 
```  
    Pagamentos(_mutuarioID_, nome, endereco, totalEmprestimo,dataInicioDoEmprestimo, dataPagamento, valorDoPagamento)
```

1 endereço

n emprestimos, mas com data de inicio distinta


mutuario(mutuarioID, nome, endereco)

emprestimo(mutuarioID, dataInicioDoEmprestimo, totalEmprestimo)

pagamento(dataPagamento, valorDoPagamento, mutuarioID)



9. 

Hospedagem(idHospedagem, dataCheckin, dataCheckOut)

Hospede(idHospede, nomeHospede, enderecoHospede, cidade, estado, CEP)

centroDeCusto(idCentroDeCusto, nomeDoCentro)

Produtos(idProdutos, descricao, valor)

1 Hospede tem n Hospedagem

1 centro de custo tem N produtos

n Hospedes tem n Produtos

