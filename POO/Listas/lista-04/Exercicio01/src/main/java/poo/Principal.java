package poo;
import java.util.*;

public class Principal {

    public static void main(String[] args) {

        //testa se o modo está correto
        if((args.length==3) && ((args[0].equals("ascii") ||(args[0].equals("utf8"))))){
            //testa se os argumentos de largura e altura são números positivos
            if (args[1].matches ("[0-9]+") && (args[2].matches ("[0-9]+"))) {
                Retangulo r = new Retangulo(Integer.valueOf(args[1]),Integer.valueOf(args[2]));

                //imprimindo o retângulo conforme argumentos.
                if(args[0].equals("utf8")){
                    r.desenharUTF8();
                }else if(args[0].equals("ascii")){
                    r.desenharASCII();
                }
            }else{
                System.out.println("Digite um número positivo para altura/largura");
            }
        }else{
            System.out.println("Entre com um modo(ascii ou utf8)");
        }










    }
}
