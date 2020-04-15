package poo;


import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int posX=0; int posY=0; int area=0; int posString= 0 ;
        char frente=' ';
        String comandos ="";

        while(teclado.hasNext()){
            area = teclado.nextInt();
            posX = teclado.nextInt();
            posY = teclado.nextInt();
            frente = teclado.next().charAt(0);
            while(teclado.hasNext()) {
                comandos = comandos + teclado.next().charAt(0);
                posString ++;
            }
            break;
        }


        Robo r = new Robo(posX,posY,frente,area);

        String[] pegar;

        pegar = r.explorar(comandos);

        for(int i =0;i < pegar.length;i++){
            System.out.println(pegar[i]);
        }







    }
}
