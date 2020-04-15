package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {


    public static void menu(){
        Scanner teclado = new Scanner(System.in);
        int op=0;

        Drone d = new Drone();
        while (true) {
            System.out.println("1. Drone");
            System.out.println("2. Câmera");
            System.out.println("3. Motor");
            System.out.println("4. Sair");
            try {
                op = teclado.nextInt();
                if(op == 1) {
                    System.out.println("1. Fazer decolagem");
                    System.out.println(("2. Alterar altitude"));
                    System.out.println("3. Mover para um direção");
                    System.out.println("4. Posição atual");
                    System.out.println("5. Carregar plano de voo e iniciar voo autônomo");
                    System.out.println("6. Verificar nível da bateria");
                    System.out.println("7. Retornar para base");
                    System.out.println("8. Verificar caminho percorrido");
                    System.out.println("9. Menu principal");
                    op = teclado.nextInt();

                    if (op == 1) {
                        d.decolar();
                    } else if (op == 2) {
                        System.out.println("1. Subir");
                        System.out.println("2 . Descer");
                        op = teclado.nextInt();
                        if (op == 1) {
                            d.subir();
                        } else if (op == 2) {
                            d.descer();
                        }
                    } else if (op == 3) {
                        System.out.println("1. Frente");
                        System.out.println("2. Trás");
                        System.out.println("3. Direita");
                        System.out.println("4. Esquerda");
                        op = teclado.nextInt();
                        if (op == 1) {
                            d.frente();
                        } else if (op == 2) {
                            d.tras();
                        } else if (op == 3) {
                            d.direita();
                        } else if (op == 4) {
                            d.esquerda();
                        }

                    } else if (op == 4) {
                        d.getPosicaoAtual();
                    }else if (op == 5) {
                        ArrayList<String> a = new ArrayList<>();
                        String posicao;
                        teclado.nextLine();
                        while (true) {
                            a.add("000");
                            System.out.println("Digite uma posicao para inserir no plano. Ex: 111(xyz). Digite 'quit' para finalizar");
                            posicao = teclado.nextLine();
                            a.add(posicao);
                            if (posicao.equals("quit")) {
                                d.decolar();
                                d.setPlano(a);
                                break;
                            }
                        }
                    } else if (op == 6) {
                        d.getBaterialAtual();
                    } else if (op == 7) {
                        d.voltarInicio();
                    }else if(op == 8){
                        d.getPercurso();
                    }
                }else if(op ==2){
                    System.out.println("1. Tirar uma foto");
                    System.out.println("2. Iniciar filmagem");
                    System.out.println("3. Ligar Infra vermelho");
                    System.out.println("4. Ver fotos salvas");
                    System.out.println("5. Menu principal");
                    op = teclado.nextInt();
                    if(op==1){
                        d.tirarFoto();
                    }else if(op ==2){
                        d.filmar();
                    }else if(op ==3){
                        d.ligarIF();
                    }else if(op ==4){
                        d.getFotosSalvas();
                    }
                }else if(op == 3){
                    System.out.println("1. Aumentar rotação");
                    System.out.println("2. Diminuir rotação");
                    op = teclado.nextInt();
                    if(op ==1){
                        System.out.println("Qual rotor deseja aumentar? 0,1,2 ou 3");
                        op = teclado.nextInt();
                        if(op>=0 && op<=4){
                            d.aumentarRotacao(op);
                        }else{
                            System.out.println("Rotor inválido");
                        }

                    }else if(op ==2){
                        System.out.println("Qual rotor deseja aumentar? 0,1,2 ou 3");
                        op = teclado.nextInt();
                        if(op>=0 && op<=4){
                            d.diminuirRotacao(op);
                        }else{
                            System.out.println("Rotor inválido");
                        }
                    }

                }else if(op == 4){
                    System.out.println("Aplicativo encerrado!");
                    break;
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
        menu();
    }
}
