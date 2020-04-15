import java.util.*;

public class Exercicio02 {

   public static void main(String args[]){
       int[] vet = new int[10];
       int aux = 0;
       int i = 0;
       Random gerador = new Random();

       for(int k=0;k<vet.length;k++){
           vet[k] = gerador.nextInt(100);
       }



       for(i = 0; i<vet.length; i++){
           for(int j = 0; j<vet.length-1; j++){
               if(vet[j] > vet[j + 1]){
                   aux = vet[j];
                   vet[j] = vet[j+1];
                   vet[j+1] = aux;
               }
           }
       }
       System.out.println("Ordenação bolha");
       for(i = 0; i<vet.length; i++){
           System.out.println(" "+vet[i]);
       }
   }

}

