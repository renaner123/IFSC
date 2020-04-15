# Comandos git e linguagem de programação Java

+ ## Linguagem de programação Java
  + ### Estruturas de decisão
    ```Java
    public class Decisao{
      public static void main(String[] args) {

        int i=2,j=1;

        //Estrutura if/else
        if(i>2){
            System.out.println("i é maior que 2");
        }else{
            System.out.println("i é menor");
        }

        //Estrutura else if
        if(i>2){
            System.out.println("i é maior que 2");
        }else if(i > 0){
            System.out.println("i é maior que 0");
        }else{
            System.out.println("i é menor que 0");
        }
        //Operador ternário
        System.out.println((i > j) ? "Maior" : "Menor");
      }
    }
    ```


  + ### Métodos da classe String
    ```Java
    public class Texto{
      public static void main(String[] args) {

      String texto1 = new String("Qualquer texto entre aspas é uma String");
      String nome1 = "Renan";
      String nome2 = "Rodolfo";

      // Invocando um método da classe String
      System.out.println(texto1.length());
      //Comparando Strings
      System.out.println(nome1 == nome2 ? "Nome igual" : "Nome diferente");
      }
    }
    ```
  + ### Interação com o usuário
    ```Java
    import java.util.Scanner;
    public class Principal {
      public static void main(String[] args) {

          Scanner teclado = new Scanner(System.in);
          int inteiro;
          String texto;

          System.out.println("Digite um inteiro");
          inteiro = teclado.nextInt();
          System.out.println("Digite uma string");
          texto = teclado.next();

          System.out.println("inteiro: " + inteiro + " " + "String: " + texto);
      }
    }
    ```


+ ## Comandos git
  + ### Fluxo de trabalho usando ramos
    ```shell
    git checkout master
    git merge decisao
    trabalho
    git status
    git add Readme.md
    git commit -m "Exercício 07 concluído"
    ```

    ```shell
    git checkout master
    git merge string
    trabalho
    git status
    git add Readme.md
    git commit -m "Exercício 08 concluído"
    ```
