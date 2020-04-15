package poo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);
        int op;
        String[] vet = new String[10];
        Soldado x = new Soldado();
        System.out.println("Bem vindo ao jogo de guerra de soldados. Escolha as opções a baixo");
        while(true){
            int cont =0;
            System.out.println(" ");
            System.out.println("1. Criar um soldado");
            System.out.println(("2. Verificar total de soldados"));
            System.out.println("3. Movimentar um soldado");
            System.out.println("4. Movimentar todos os soldados");
            System.out.println("5. Atacar");
            System.out.println("6. Finalizar interface");
            op = teclado.nextInt();

            if(op==1){
                x = new Soldado();
            }else if(op==2){
                System.out.println(x.getSoldados());
            }
            else if(op==3){
                int op2;
                System.out.println("Escolha a distância ou deixe 0 para usar distância padrão");
                op2 = teclado.nextInt();
                if(op2 == 0) {
                    x.movimentar();
                }else {
                    x.movimentar(op2);
                }
            }
            else if(op==4){
                int op2;
                System.out.println("Escolha a distância ou deixe 0 para usar distância padrão");
                op2 = teclado.nextInt();
                if(op2 == 0) {
                    x.movimentarTodos(x.getDistanciaPadrao());
                }else {
                    x.movimentarTodos(op2);
                }
            }else if(op==5){
                String op2;
                System.out.println("Escolha uma arma(fuzil, baioneta, punho) ou digite qualquer coisa para usar a padrão");
                op2 = teclado.next();
                if(op2.equals("fuzil") || op2.equals("baioneta") || op2.equals("punho")){
                    x.atacar(op2);
                }else {
                    x.atacar();
                }
            }else if(op==6){
                break;
            }


        }




    }
}
