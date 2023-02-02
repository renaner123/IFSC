## Resolução da [lista-02](bcd-lista-02-relacional.pdf).

### Questão 1

![exericio 3](./Questao1.png)

### Questão 2

```SQL
DROP TABLE IF EXISTS `Empregado` ;
DROP TABLE IF EXISTS `Dependente` ;

create table Empregado
(
    idEmpregado INTEGER not null
        constraint Empregado_pk
        Primary key autoincrement,
    nome        TEXT    not null
);

create table Dependente
(
    idDependente INTEGER not null
        constraint Dependente_pk
        primary key autoincrement,
    nome         TEXT    not null, 
    empregado_idEmpregado INTEGER not null,
  	FOREIGN KEY (empregado_idEmpregado) REFERENCES Empregado(idmpregado)
);

```

### Questão 3

![exericio 3](./Questao3.png)

### Questão 4

![exericio 3](./Questao4.png)

### Questão 5

![exericio 3](./Questao5.png)

### Questão 6

![exericio 3](./Questao6.png)