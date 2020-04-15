import java.util.*;

public class Exercicio01 {

   public static void main(String args[]) {

       String tipo = "";
       int valor = 0;
       String [][] first;
       String [][] second ;
       Scanner teclado = new Scanner(System.in);

       if(args.length==0){
        System.out.println("Digite os argumentos");
       }else{
        tipo = args[0];
        valor = Integer.valueOf(args[1]);
       }


       while(true) {
           if (tipo.equals("quadrado")) {

               if (((valor % 2) == 0) && valor >= 4) {
                   first = new String[valor][valor];

                   // Para deixar espaços vazios na matriz depois de preencher
                   for(int r=0; r < valor;r++){
                       for(int c=0; c < valor;c++){
                           first[r][c] = " ";
                       }
                   }
                   // Adicionar o formato de quadrado na matriz
                   for(int r=0; r < valor;r++){
                       for(int c=0; c < valor;c++){
                           if(r==0){
                               first[r][c] = "*";
                           }else if(r==(first.length-1)) {
                               first[r][c] = "*";
                           }else if((c==0) || (c == first.length-1)) {
                               first[r][c] = "*";
                           }
                       }
                   }

                   // Imprimindo a matrix
                   for(int r = 0; r < valor; r++)
                   {
                       for(int c = 0; c < valor; c++)
                       {
                           System.out.print(first[r][c]);
                       }
                       System.out.println(" ");
                   }
                  /*   0 1 2 3
                    0  * * * *
                    1  *     *
                    2  *     *
                    3  * * * *
                    1 0     1 3
                    2 0     2 3
                   */
                   break;

               } else {
                   System.out.println("Digite um número par e maior ou igual a 4");
                   valor = teclado.nextInt();

               }

           } else if (tipo.equals("losango")) {

               if (((valor % 2) != 0) && valor >= 3) {
                   //par
                   second = new String[valor][valor];
                   int metade = (int) Math.ceil(valor/2);
                   int metade_sup = metade;
                   int metade_inf = metade;
                   int metade_sup2 = valor-1;
                   int metade_inf2 = metade;
                   int aux_cont = 1;

                   // Para deixar espaços vazios na matriz depois de preencher
                   for(int r=0; r < valor;r++){
                       for(int c=0; c < valor;c++){
                           second[r][c] = " ";
                       }
                   }

                   for(int r=0; r < valor;r++){
                       for(int c=0; c < valor;c++){
                           // Arrumando a parte de cima do losango
                           //System.out.println(r + " " + c);
                           if(r > 0 && r < metade){
                               if(c == metade_sup-1){
                                   //System.out.println("sup " + r + " " + c);
                                   second[r][c] = "*";
                                   metade_sup--;
                               }else if(c == metade_inf +1  ){
                                   //System.out.println("inf " + r + " " + c);
                                   second[r][c] = "*";
                                   metade_inf ++;
                                   break;
                               }
                           }else if(r> metade && r < second.length-1){
                               if(c == metade_sup2-1){
                                   //System.out.println("sup " + r + " " + c);
                                   second[r][c] = "*";
                                   metade_sup2--;
                               }
                           }

                           if((r==metade)&&((c==0)||(c == second.length-1))){ // prenche o centro
                               second[r][c] = "*";
                           }else if((r==0) || (r == second.length-1)) { // preenche top e bot
                               second[r][metade] = "*";
                           }
                       }
                   }
                    /* 7
                      0 1 2 3 4 5 6
                    0       *            0 3
                    1     *   *       1 2   1 4         1 2  1 4 2 1 2 5
                    2   *       *     2 1   2 5
                    3 *           *   3 0   3 6
                    4   *       *     4 1   4 5
                    5     *   *       5 2   5 4
                    6       *            6 3
                   */
                    // Inserir a parte que faltou

                   for(int i = metade+1;i<valor-1;i++){
                       second[i][aux_cont] = "*";
                       aux_cont ++;
                   }

                   // Imprimindo a matrix
                   for(int r = 0; r < valor; r++)
                   {
                       for(int c = 0; c < valor; c++)
                       {
                           System.out.print(second[r][c]);
                       }
                       System.out.println(" ");
                   }
                   break;
               } else {
                   System.out.println("Digite um número ímpar e maior ou igual a 3");
                   valor = teclado.nextInt();
               }

           } else {
               System.out.println("Tipo inválido! quadrado ou losango ?");
               tipo = teclado.next();
           }
       }



   }


}






