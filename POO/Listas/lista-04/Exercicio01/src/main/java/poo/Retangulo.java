package poo;
import java.util.*;

public class Retangulo {

    private int altura;
    private int largura;
    private String[][] mat;
    private final static int tamanho = 4;


    public Retangulo(){
       this(4,4);

    }

    public Retangulo(int altura, int largura) {

        if((altura >= 2 && largura >= 3) || (altura >= 3 && largura >= 2)) {

            this.altura = altura;
            this.largura = largura;

        }else{
            System.out.println("Valor inválido, redefinido para o padrão");
            this.altura = tamanho;
            this.largura = tamanho;
        }
    }


    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {

        if((altura >= 2 && largura >= 3) || (altura >= 3 && largura >= 2)) {
            if (altura != largura) {
                this.altura = altura;
            }else{
                System.out.println("Valor inválido, redefinido para altura 4");
            }
        }else{
            System.out.println("Valor inválido, redefinido para altura 4");
        }
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {

        if((altura >= 2 && largura >= 3) || (altura >= 3 && largura >= 2)) {
            if (altura != largura) {
                this.largura = largura;
            }else{
                System.out.println("Valor inválido, redefinido para altura 4");
            }
        }else{
            System.out.println("Valor inválido, redefinido para largura 4");
        }
    }

    public void desenharASCII() {
        while (true) {
            if (altura >0) {
                mat = new String[altura][largura];
                // Para deixar espaços vazios na matriz depois de preencher
                for (int r = 0; r < altura; r++) {
                    for (int c = 0; c < largura; c++) {
                        mat[r][c] = " ";
                    }
                }
                //row/altura    colum/largura
                // Adicionar o formato de retangulo na matriz
                for (int r = 0; r < altura; r++) {
                    for (int c = 0; c < largura; c++) {
                        if(r==0 && c==0){
                            mat[r][c] = "+";
                        }else if((r==altura-1) && c==0){
                            mat[r][c] = "+";
                        }else if((r==0) && c==largura-1){
                            mat[r][c] = "+";
                        }else if((r==altura-1) && c==largura-1){
                            mat[r][c] = "+";
                        }else if(r==0 || r==altura-1){
                            mat[r][c] = "-";
                        }else if(c==0 || c==largura-1){
                            mat[r][c] = "|";
                        }
                    }
                }
                // Imprimindo a matrix
                for (int r = 0; r < altura; r++) {
                    for (int c = 0; c < largura; c++) {
                        System.out.print(mat[r][c]);
                    }
                    System.out.println(" ");
                }
                break;
            } else {
            }
        }
    }

    public void desenharUTF8(){
        mat = new String[altura][largura];
        while (true) {


            if (altura >0) {
                // Para deixar espaços vazios na matriz depois de preencher
                for (int r = 0; r < altura; r++) {
                    for (int c = 0; c < largura; c++) {
                        mat[r][c] = " ";
                    }
                }
                //row/altura    colum/largura
                // Adicionar o formato de retangulo na matriz
                for (int r = 0; r < altura; r++) {
                    for (int c = 0; c < largura; c++) {
                        if(r==0 && c==0){
                            mat[r][c] = "\u250c\u2500";
                        }else if((r==altura-1) && c==0){
                            mat[r][c] = "\u2514\u2500";
                        }else if((r==0) && c==largura-1){
                            mat[r][c] = "\u2500\u2510";
                        }else if((r==altura-1) && c==largura-1){
                            mat[r][c] = "\u2500\u2518";
                        }else if(r==0 || r==altura-1){
                            mat[r][c] = " ";
                        }else if(c==0){
                            mat[r][c] = "\u2502";
                        }else if(c==largura-1){
                            mat[r][c] = "  \u2502";
                        }
                    }
                }
                // Imprimindo a matrix
                for (int r = 0; r < altura; r++) {
                    for (int c = 0; c < largura; c++) {
                        System.out.print(mat[r][c]);
                    }
                    System.out.println(" ");
                }
                break;
            } else {
            }
        }

//        System.out.println("\n");//
//        System.out.println("\u250c\u2500");
//        System.out.println("\u2500\u2510");
//        System.out.println("\n\u2502");
//        System.out.println("\u2514\u2500");
//        System.out.println("\u2500\u2518");
//        System.out.println("\u2014");//
//        System.out.println("\u250c\u2500\u2500\u2510\n\u2502  \u2502\n\u2514\u2500\u2500\u2518");
    }
}
