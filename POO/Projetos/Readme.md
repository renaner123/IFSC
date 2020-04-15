## Projeto 1
### Programação Orientada a Objetos - POO29004

#### Engenharia de Telecomunicações

##### Instituto Federal de Santa Catarina



# Gerador de calendários iCalendar

## Especificação iCalendar

A especificação *Internet Calendaring and Scheduling Core Object Specification (iCalendar)* define um tipo de dados que permite o armazenamento e compartilhamento de eventos de calendário.. Arquivos iCalendar, seguem a   especificação [RFC 5545](https://tools.ietf.org/html/rfc5545) e geralmente possuem a extensão `.ics`. Tais arquivos podem ser importados por aplicações como o Google Agenda, Apple Calendário, etc.

Nesse projeto prático você precisará modelar um conjunto de classes que permita imprimir na tela um evento de calendário iCalendar de acordo com a especificação abaixo. 

> **Atenção:** esse projeto contempla somente uma pequena parte da especificação iCalendar. Respeite a especificação abaixo e não tente implementar tudo o que está descrito na [RFC 5545](https://tools.ietf.org/html/rfc5545).

O código abaixo apresenta um exemplo de um objeto iCalendar. No exemplo é indicado o dia e horário que inicia e termina a *Aula inicial de Programação Orientada a Objetos*.

```
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//IFSC//POO29004//PT
BEGIN:VEVENT
SUMMARY:Aula inicial de Programação Orientada a Objetos
UID:C94F455B-F97B-4186-926D-63E7FBBCA5F6
DTSTAMP:20190304T133000
DTSTART:20190304T133000
DTEND:20190506T152000
END:VEVENT
END:VCALENDAR
```

Um `VCALENDAR` é o principal elemento de um objeto iCalendar e suas principais propriedades são:

-   `VERSION` - Informação obrigatória que indica a versão da especificação. Atualmente o valor obrigatório para essa propriedade é `2.0`.
-   `PRODID` - Identificação do aplicativo que gerou o agendamento. Apesar de não haver na especificação uma regra rígida com relação ao seu conteúdo, uma boa prática é apresentada abaixo:
    -   `PRODID:-//Nome da empresa//Nome do aplicativo//CódigoDoIdioma`

Um `VCALENDAR` contém um ou mais elementos `VEVENT`, sendo esse último responsável por representar um evento.

```
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//IFSC//POO29004//PT
BEGIN:VEVENT
...
END:VEVENT
BEGIN:VEVENT
...
END:VEVENT
BEGIN:VEVENT
...
END:VEVENT
END:VCALENDAR
```

 As principais propriedades de um `VEVENT` são:

-   `SUMMARY` - O assunto do evento
-   `UID` - Um identificador único do evento. Não podem existir dois ou mais eventos com um mesmo identificador
-   `DTSTAMP` - Indica a data e hora que a instância do iCalendar foi criada. Essa informação deve ser representada no formato: `AAAAMMDDTHHMMSS`. Ou seja, para a instância criada às 13:30:00 do dia 04/03/2019 o valor será: `20190304T133000`
-   `DTSTART` - Indica a data e hora que o evento começa. O formato para representação é igual ao da propriedade `DTSTAMP`.
-   `DTEND` - Indica a data e hora que o evento termina. O formato para representação é igual ao da propriedade `DTSTAMP`.
-   `LOCATION` - Um texto livre para indicar o local do evento. Por exemplo, *Laboratório de Sistemas Digitais*

Um `VEVENT` pode ter ainda outras propriedades opcionais:

-   `RRULE:` - Especifica uma regra ou padrão de repetição para eventos recorrentes. Por exemplo, a Aula de POO acontece toda segunda-feira desde o início do semestre até o dia 02/07/2019. O conjunto de recorrência é gerado considerando a data inicial especificada no `DTSTART` e excluindo as datas especificadas com a propriedade `EXDATE` (explicado mais abaixo). Isto é, a propriedade `DSTART` define a primeira instância do conjunto de recorrências.
    -   `RRULE:FREQ=WEEKLY;INTERVAL=1;UNTIL=20190702T152000;BYDAY=MO`
    -   Os valores permitidos para cada propriedade de `RRULE` são:
        -   `FREQ` - DAILY, WEEKLY, MONTLHY, YEARLY
        -   `INTERVAL` - Indica o intervalo de repetição. Por exemplo, `FREQ=WEEKLY;INTERVAL=2` indica que o evento repete a cada 2 semanas. `FREQ=DAILY;INTERVAL=1` indica que o evento repete a cada dia.
        -   `UNTIL` - Data e hora no mesmo formato da propriedade `DTEND` que especifica o término da repetição.
        -   `BYDAY` - `SU, MO, TU, WE, TH, FR, SA` . Pode ser cada um desses valores, ou pode-se combinar um ou mais, separando-os por vírgula. Ex: `BYDAY=MO,TU` indica que o evento repete na segunda-feira e terça-feira.
-   `EXDATE` - Cada entrada especifica uma data e hora que deverá ser excluída de eventos recorrentes. Cada evento, que possua uma propriedade `RRULE`, poderá ter zero ou mais propriedades `EXDATE`. Por exemplo, a aula de POO acontece semalmente na segunda-feira, porém não haverá aula nos dias 04/03/2019 e 18/03/2019.

```bash
RRULE:FREQ=WEEKLY;INTERVAL=1;UNTIL=20190702T152000;BYDAY=MO
EXDATE:20190304T133000
EXDATE:20190318T133000
```

## Projeto

Modele um conjunto de classes de forma que seja possível instanciar objetos iCalendar.  O objeto deverá possuir, entre outros, um método `toString()` que retornará um calendário de acordo com as especificações apresentadas na seção anterior. Na modelagem é obrigatório fazer uso de associação entre classes. 

-   Deve-se colocar o diagrama de classes UML na raiz do repositório com o nome `diagrama.png`. O diagrama deverá obrigatoriamente listar todos os atributos e os principais métodos das classes
-   É necessário criar uma classe com o método `public static void main(String args[])` e nesse deve-se instanciar objetos e imprimir na tela o conteúdo do objeto iCalendar (semelhante a primeira listagem de código apresentada no início desse documento)
-   A classe deverá prover métodos que permitam a adição e alteração de detalhes sobre eventos, bem como a exclusão de eventos
-   É necessário respeitar o conceito de encapsulamento dos dados
-   Não se deve ter constantes literais espalhadas ao longo do código, opte por criar constantes membros de classe
-   Crie um projeto gradle na raiz de repositório
-   É necessário fazer um *commit* para cada funcionalidade implementada
-   É necessário fazer uso adequado do `.gitignore`
-   Garanta que seja possível executar seu projeto após o mesmo ser clonado via `git clone`. 

## Material de apoio

### Classe java.time.LocalDateTime

Use essa classe para gerar valores para as propriedades `DTSTAMP`, `DTSTART` e `DTEND`

```java
LocalDateTime localDateTime = LocalDateTime.of(2019, 04, 22, 13, 30, 00);
String dataFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
System.out.printf(dataFormatada); // Será impresso: 20190422T133000

// para obter a data e hora no momento que essa linha foi executada
LocalDateTime agora = LocalDateTime.now(); 
```

### Classe java.util.UUID

Use essa classe para gerar um identificador único universal (UUID) que pode ser usado como valor para a propriedade `UID`.

``` java
// Será impresso algo como: 48021fb2-78ca-4bf6-aa67-f96aa6f39413
System.out.printf(UUID.randomUUID().toString()); 
```

### Exemplos de calendários

#### Aulas de POO de 2020.01

Aulas de POO acontecem semalmente na quarta-feira das 13:30 às 15:20 e na sexta-feira das 15:40 às 17:30. Em 2020.01 não haverá aula nos dias: 10/04/2020, 01/05/2020 e 12/06/2020.

```
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//Emerson Mello//Gerador de Plano de Ensino 1.0.0//PT_BR
BEGIN:VEVENT
SUMMARY:Aula de Programação Orientada a Objetos
DTSTAMP:20200405T101500
DTSTART:20200212T133000
DTEND:20200212T152000
UID:4811f037-de71-4025-9c22-7820d5818ba1
RRULE:FREQ=WEEKLY;UNTIL=20200701T152000;BYDAY=WE
LOCATION:Laboratório de Sistemas Digitais
END:VEVENT
BEGIN:VEVENT
SUMMARY:Aula de Programação Orientada a Objetos
DTSTAMP:20200405T101500
DTSTART:20200214T154000
DTEND:20200214T173000
UID:0160b410-acca-4c20-9490-2b22d190ec3e
RRULE:FREQ=WEEKLY;UNTIL=20200701T173000;BYDAY=FR
EXDATE:20200410T173000
EXDATE:20200501T173000
EXDATE:20200612T173000
LOCATION:Laboratório CAD3
END:VEVENT
END:VCALENDAR
```

#### Aulas de Sistemas Distribuídos 2019.01

Aulas de STD acontecem:

-    Semalmente na quinta-feira das 13:30 às 15:20. 
-   A cada 14 dias (semana alternada) na segunda-feira das 13:30 às 15:20

Em 2020.01 não haverá aula nos dias: 24/02/2020, 19/03/2020 e 11/06/2020.

```
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//Emerson Mello//Gerador de Plano de Ensino 1.0.0//PT_BR
BEGIN:VEVENT
SUMMARY:Aula de Sistemas Distribuídos
DTSTAMP:20200405T101500
DTSTART:20200217T133000
DTEND:20200217T152000
UID:31d37f82-07fa-459f-9062-58824087f1f7
RRULE:FREQ=WEEKLY;INTERVAL=2;UNTIL=20200625T152000;BYDAY=MO
EXDATE:20200224T152000
LOCATION:Laboratório de Sistemas Digitais
END:VEVENT
BEGIN:VEVENT
SUMMARY:Aula de Sistemas Distribuídos
DTSTAMP:20200405T101500
DTSTART:20200213T133000
DTEND:20200213T152000
UID:32d20a53-742b-4389-add0-8b7e36dfc32a
RRULE:FREQ=WEEKLY;UNTIL=20200625T152000;BYDAY=TH
EXDATE:20200319T152000
EXDATE:20200611T152000
LOCATION:Laboratório de Sistemas Digitais
END:VEVENT
END:VCALENDAR
```

### Validador de iCalendar

Em https://icalendar.org/validator.html tem um validador de objetos iCalendar, use-o para verificar se String resultante gerada pelo seu código é válida. Basta copiar a String, colar no formulário nessa página e clicar no botão Validate.


