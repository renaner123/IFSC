
## Listas

* [Lista 01](lista-01/Readme.md) - Modelo Entidade-Relacionamento
* [Lista 02](lista-02/Readme.md) - Modelo relacional
* [Lista 03](lista-03/Readme.md) - Normalização

### Observações

As seguintes observações/correções devem ser analisadas nas resoluções dos exercícios

#### Lista 01
- Exercício 2
  - Partida não está indicando quais times participaram
  - Não representou a possibilidade de jogadores trocarem de time em diferentes temporadas
  - Uma liga está associada com uma única temporada?
- Exercício 3
  - Departamento não pode estar associado a vários campi
  - Curso não pode estar associado a vários Departamentos
  - Não permtiu registrar notas e faltas dos alunos
  - Atributo disciplina em professor não é o adequado para indicar suas capacidades
- Exercício 4
  - e) Porquê nem todo funcionário é certificado para voar em algum tipo de aeronave. 
#### Lista 02
- Exercício 01
  - Senha obriga a ter um atendente associado
- Exercício 02
  - idEmpregado deveria fazer parte da chave primária da tabela Dependente
- Exercício 04
  - Não atende o requisito que jogadores e treinadores podem trocar de times
  - Não sabe quais times participaram de uma temporada
- Exercício 05
  - TecnicoAdm não faz sentido existir
- Exercício 06
  - Não indica quais disciplinas o professor está apto a ministrar.
  - Não permite registrar presença por dia de aula e nem a nota de cada avaliação
  - Não atende a "cadeia de pré-requisitos de disciplinas"