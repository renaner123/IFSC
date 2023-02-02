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




