import java.util.*;

public class Exercicio03 {
   /*
   Total de ńumeros  ́unicos:
   Ńumero(s) com o maior ńumero de repeticoes:
   Total de ńumeros pares:
   Total de ńumeros  ́ımpares:
   Total de ńumeros primos:
    */

   public static int total(ArrayList<Integer> vet){
       ArrayList<Integer> listatotal = vet;
       int aux = 0;
       for(int i =0;i<listatotal.size()-1;i++){
           aux = listatotal.get(i);
           if(listatotal.get(i) == listatotal.get(i+1)){
               listatotal.remove(listatotal.get(i));
               i--;
           }
       }
       return listatotal.size();
   }

   public static int par(ArrayList<Integer> vet){
       int contpar = 0;
       for(int i =0;i<vet.size();i++){
           if(vet.get(i)%2==0){
               contpar ++;
           }
       }
       return contpar;
   }
   public static int impar(ArrayList<Integer> vet){
       int contimpar = 0;
       for(int i =0;i<vet.size();i++){
           if(vet.get(i)%2!=0){
               contimpar ++;
           }
       }
       return contimpar;
   }

   public static int primo(ArrayList<Integer> vet){
       int contador = 0;
       for(int i =0;i<vet.size();i++) {
           int num = vet.get(i);
           boolean flag = false;
           for (int k = 2; k <= num / 2; ++k) {
               // condition for nonprime number
               if (num % k == 0) {
                   flag = true;
                   break;
               }
           }
           if (!flag)
               contador ++;
       }
       return contador;
   }


   public static void main(String[] args) {
       int[] vet = new int[5];
       int aux = 0,aux_read =0,primos =0,par=0,impar=0,cont=0;

       ArrayList<Integer> lista = new ArrayList<Integer>();
       ArrayList<Integer> lista2 = new ArrayList<Integer>();
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

       Scanner teclado = new Scanner(System.in);
      
       while(teclado.hasNext()){
           aux_read = teclado.nextInt();
           lista.add(aux_read);
           lista2.add(aux_read);
       }


       Collections.sort(lista2);

       System.out.println("Números únicos: " + total(lista2));

       for(int i =0;i<lista.size();i++){
           aux = lista.get(i);
           for(int j =0;j<lista.size();j++){
               if(aux == lista.get(j)){
                   cont++;
               }
           map.put(aux,cont);
           }
           cont =0;
       }
       //https://www.leveluplunch.com/java/examples/sort-order-map-by-values/
       System.out.println("Ordem dos 5 mais repetidos Número=Quantidade:");
       map.entrySet().stream()
               .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
               .limit(5)
               .forEach(System.out::println); // or any other terminal method


       System.out.println("Números par: " + par(lista));
       System.out.println("Números ímpar: " + impar(lista));
       System.out.println("Número primos: " + primo(lista));



   }
}

