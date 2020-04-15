package poo;


import java.time.*;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.*;
import java.util.Scanner;

public class Principal {

    public static void menu(){
        Scanner teclado = new Scanner(System.in);
        int op=0;
        String nome; String sobrenome;String[] data; String[] email; String[] telefone;int pindex;
        Agenda a = new Agenda();

        while (true) {
            System.out.println("1. Adicionar um contato");
            System.out.println(("2. Remover um contato"));
            System.out.println("3. Atualizar um contato");
            System.out.println("4. Listar dados de um contato");
            System.out.println("5. Lista todos os contatos");
            System.out.println("6. Sair");
            try {
                op = teclado.nextInt();
                if (op == 1) {
                    teclado.nextLine();
                    System.out.println("Digite o nome");
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome");
                    sobrenome = teclado.nextLine();
                    System.out.println("Digite a data de nascimento YYYY/MM/DD");
                    data  = teclado.nextLine().split("/|/\\s");
                    System.out.println("Digite o rótulo e telefome com DDD (Ex. Casa 33410171)");
                    telefone = teclado.nextLine().split(" |,\\s");
                    System.out.println("Digite o rótulo e-mail(Ex. Comercial renanrodolfo@yahoo.com.br)");
                    email = teclado.nextLine().split(" |,\\s");
                    Pessoa p = new Pessoa(nome,sobrenome,LocalDate.of(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])));
                    p.addTelefone(telefone[0],telefone[1]);
                    p.addEmail(email[0],email[1]);

                    a.addPessoa(p);

                }else if(op == 2){
                    teclado.nextLine();
                    System.out.println("Digite o nome a ser excluído");
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome a ser excluído");
                    sobrenome = teclado.nextLine();
                    a.removePessoa(nome,sobrenome);
                }else if(op == 3){
                    nome = teclado.nextLine();
                    System.out.println("1. Atualizar email");
                    System.out.println("2. Atualizar telefone");
                    op = teclado.nextInt();

                    if(op == 1){
                        nome = teclado.nextLine();
                        System.out.println("Digite a posição na agenda");
                        pindex = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Digite o novo rótulo e-mail(Ex. Comercial renanrodolfo@yahoo.com.br)");
                        email = teclado.nextLine().split(" |,\\s");
                        System.out.println(email[0] + " " + email[1] + " " + pindex);
                        System.out.println(a.addEmail(email[0],email[1],pindex));
                    }if(op == 2){
                        nome = teclado.nextLine();
                        System.out.println("Digite a posição na agenda");
                        pindex = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Digite o novo rótulo e telefone(Ex. Comercial 48996478132");
                        telefone = teclado.nextLine().split(" |,\\s");
                        System.out.println(a.addTelefone(telefone[0],telefone[1],pindex));
                    }

                }else if(op == 4){
                    Scanner tel = new Scanner(System.in);

                    System.out.println("Digite o nome a ser procurado");
                    nome = tel.nextLine();
                    System.out.println("Digite o sobrenome a ser procurado");
                    sobrenome = tel.nextLine();
                    a.getContato(nome,sobrenome);
                }

                else if(op == 5){
                    //System.out.println(a.toString());
                    a.getContatos();
                }else if(op ==6){
                    System.out.println("Finalizando a agenda");
                    return;

                }

            }catch (java.util.InputMismatchException e) {
                    System.out.printf("Erro " + e.toString() + " ### " + "Digite um número interno \n");
                    menu();
            }catch(Exception e) {
                menu();
            }

        }
    }




    public static void main(String[] args) {

        System.out.println("Agenda Telefônica");
        menu();

    }

}
