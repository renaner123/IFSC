package poo;

public class Motor {
    private static final double BATERIAFULL = 10;
    private static double consumo = 0.01;
    private static final int ROTACAOMIN =0;
    private static final int ROTACAOMAX = 100;
    private static final int VALORROTACAO = 10;
    private static boolean bateriaAcabando=false;
    private int rotacao=0;
    private static double bateria = BATERIAFULL;


    public void verificarBateria(){
        System.out.println(consumo);
    }

    public void aumentarRotacao(){
        if((rotacao)>=ROTACAOMIN && (rotacao)<=ROTACAOMAX){
            rotacao =+ VALORROTACAO;
            bateria = bateria - (bateria*consumo);
            System.out.println("Rotacão aumentada, bateria foi para: " + bateria);
        }else{
            rotacao = rotacao;
            System.out.println("Rotacão permaneceu igual, excedeu o valor");
        }
    }

    public void diminuirRotacao() {
        if((rotacao)>=ROTACAOMIN && (rotacao)<= ROTACAOMAX){
            rotacao =- VALORROTACAO;
            bateria = bateria - (bateria*consumo);
            System.out.println("Rotacão diminuida, bateria foi para: " + bateria );
        }else{
            rotacao = rotacao;
            System.out.println("Rotacão permaneceu igual, excedeu o valor");
        }

    }

    public double consumoManobra(int xa, int ya, int za, int xb, int yb, int zb){
        double result;
        result = Math.sqrt((Math.pow((xb - xa), 2)) + (Math.pow((yb - ya), 2)) + (Math.pow((zb - za), 2)));
        if(bateria+result >=1) {
            bateria = bateria - result;
            return (bateria);
        }else{
            bateriaAcabando = true;
            return 0;
        }
    }

    public double getBateria() {
        return bateria;
    }

    public boolean isBateriaAcabando() {
        return bateriaAcabando;
    }
}

