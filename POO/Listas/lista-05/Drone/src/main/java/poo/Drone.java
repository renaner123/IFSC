package poo;

import java.util.ArrayList;

public class Drone {
    private int posX=0;
    private int posY=0;
    private int posZ=0;
    private Camera camera = new Camera();
    private Motor[] motor = new Motor[4];
    private ArrayList<String> percurso = new ArrayList();
    private final int posPadrao = 0;
    private int posXX;
    private int posYY;
    private int posZZ;
    private String posicaoAtual;
    private String posicaoDestino;
    private boolean permiteDecolar=false;

    public Drone(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        percurso.add(Integer.toString(posX)+Integer.toString(posY)+Integer.toString(posZ));
        this.motor[0] = new Motor();
        this.motor[1] = new Motor();
        this.motor[2] = new Motor();
        this.motor[3] = new Motor();


    }
    public Drone() {
        this.posX = posPadrao;
        this.posY = posPadrao;
        this.posZ = posPadrao;
        percurso.add(Integer.toString(this.posPadrao)+Integer.toString(this.posPadrao)+Integer.toString(this.posPadrao));
        this.motor[0] = new Motor();
        this.motor[1] = new Motor();
        this.motor[2] = new Motor();
        this.motor[3] = new Motor();

    }

    public void coordenadaAtual(){
        System.out.println("Posição atual: " + posX + " " + posY + " " + posZ);
    }



    public void tirarFoto( ){
        this.camera.tirarFoto(this.posX,this.posY,this.posZ);
    }
    public void filmar(){
        this.camera.filmar();
    }

    public void ligarIF(){
        this.camera.ligarIF();
    }

    public void getFotosSalvas(){
        this.camera.getFotosSalvas();
    }

    public double verificarBateria(){
       return (this.motor[0].getBateria());
    }

    public void aumentarRotacao(int a){
        this.motor[a].aumentarRotacao();
    }

    public void diminuirRotacao(int a) {
        this.motor[a].diminuirRotacao();

    }
    public void decolar(){
        System.out.println("Decolando. Dados atuais:");
        System.out.println("Bateria " + this.motor[0].getBateria() + " " + "Posição: " + " " + this.posX + " " + this.posY + " " + this.posZ);
        this.permiteDecolar = true;
    }

    public void subir(){
        if(this.permiteDecolar == true) {

            if(this.verificarBateria()>1) {
                System.out.println("Posição atual: " + this.posX + " " + this.posY + " " + this.posZ +
                        " Bateria atual: " + this.motor[0].getBateria() +
                        " Posião destino: " + this.posX + " " + (this.posY + 1) + " " + (this.posZ + 1) +
                        " Bateria após: " + this.motor[0].consumoManobra(this.posX, this.posY, this.posZ, this.posX, this.posY + 1, this.posZ + 1)
                );
                this.posY++;
                this.posZ++;
                percurso.add(Integer.toString(this.posX) + Integer.toString(this.posY) + Integer.toString(this.posZ));
            }else{
                this.voltarInicio();
            }
        }
        else{
            System.out.println("Precisa decolar antes");
        }
    }

    public void descer(){
        if(this.permiteDecolar == true) {
            if(this.verificarBateria()>1) {
                System.out.println("Posição atual: " + this.posX + " " + this.posY + " " + this.posZ +
                        " Baterial atual: " + this.motor[0].getBateria() +
                        " Posião destino: " + this.posX + " " + (this.posY - 1) + " " + (this.posZ - 1) +
                        " Bateria após: " + this.motor[0].consumoManobra(this.posX, this.posY, this.posZ, this.posX, (this.posY - 1), (this.posZ - 1))
                );
                this.posY--;
                this.posZ--;
                percurso.add(Integer.toString(this.posX) + Integer.toString(this.posY) + Integer.toString(this.posZ));
            }else{
                 this.voltarInicio();
                }
        }else{
            System.out.println("Precisa decolar antes");
        }

    }

    public void frente(){
        if(this.permiteDecolar == true) {
            if(this.verificarBateria()>1) {
                System.out.println("Posição atual: " + this.posX + " " + this.posY + " " + this.posZ +
                        " Baterial atual: " + this.motor[0].getBateria() +
                        " Posião destino: " + (this.posX + 1) + " " + (this.posY) + " " + (this.posZ) +
                        " Bateria após: " + this.motor[0].consumoManobra(this.posX, this.posY, this.posZ, (this.posX + 1), this.posY, this.posZ)
                );
                this.posX++;
                percurso.add(Integer.toString(this.posX) + Integer.toString(this.posY) + Integer.toString(this.posZ));
            }else{
                this.voltarInicio();
            }
        }else{
            System.out.println("Precisa decolar antes");
        }
    }

    public void tras(){
        if(this.permiteDecolar == true) {
            if(this.verificarBateria()>1) {
                System.out.println("Posição atual: " + this.posX + " " + this.posY + " " + this.posZ +
                        " Baterial atual: " + this.motor[0].getBateria() +
                        " Posião destino: " + (this.posX + 1) + " " + (this.posY) + " " + (this.posZ) +
                        " Bateria após: " + this.motor[0].consumoManobra(this.posX, this.posY, this.posZ, (this.posX - 1), this.posY, this.posZ)
                );
                this.posX--;
                percurso.add(Integer.toString(this.posX) + Integer.toString(this.posY) + Integer.toString(this.posZ));
            }else{
                this.voltarInicio();
            }
        }else{
            System.out.println("Precisa decolar antes");
        }

    }

    public void direita(){
        if(this.permiteDecolar == true) {
            if(this.verificarBateria()>1) {
                this.diminuirRotacao(1);
            }else{
                this.voltarInicio();
            }

        }else{
            System.out.println("Precisa decolar antes");
        }
    }

    public void esquerda(){
        if(this.permiteDecolar == true) {
            if(this.verificarBateria()>1) {
                this.diminuirRotacao(0);
            }else{
                this.voltarInicio();
            }
        }else{
            System.out.println("Precisa decolar antes");
        }
    }
    public void voltarInicio(){

        this.posicaoAtual = percurso.get(0);
        this.posX = Character.getNumericValue(this.posicaoAtual.charAt(0));
        this.posY = Character.getNumericValue(this.posicaoAtual.charAt(1));
        this.posZ = Character.getNumericValue(this.posicaoAtual.charAt(2));
        System.out.println("Pouca bateria, voltando para posicação inicial: "+ this.posX + " " + this.posY + " " + this.posZ);
    }

    public void setPlano(ArrayList<String> a){

        for(int i=0; i<a.size();i++){
            this.posicaoAtual = a.get(i);
            this.percurso.add(this.posicaoAtual);
            this.posX = Character.getNumericValue(this.posicaoAtual.charAt(0));
            this.posY = Character.getNumericValue(this.posicaoAtual.charAt(1));
            this.posZ = Character.getNumericValue(this.posicaoAtual.charAt(2));
            try{
                this.posicaoDestino = a.get(i+1);
                this.posXX = Character.getNumericValue(this.posicaoDestino.charAt(0));
                this.posYY = Character.getNumericValue(this.posicaoDestino.charAt(1));
                this.posZZ = Character.getNumericValue(this.posicaoDestino.charAt(2));

            }catch (IndexOutOfBoundsException e){

            }

            if(motor[0].isBateriaAcabando()==true){
                this.voltarInicio();
            }else{
                System.out.println("Posição atual: " +this.posX + " " + this.posY + " " + this.posZ +
                        " Baterial atual: " + this.motor[0].getBateria() +
                        " Posião destino: " +this.posXX + " " + this.posYY + " " + this.posZZ +
                        " Bateria após: " + this.motor[0].consumoManobra(this.posX,this.posY,this.posZ,this.posXX,this.posYY,this.posZZ)
                );
            }
        }
    }

    public void getPercurso() {
        for(String a : this.percurso){
            System.out.println(a);
        }
    }
}
