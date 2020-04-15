package poo;

public class Soldado {

    private final int distanciaPadrao = 1;
    private final int maxSoldados = 10;
    private final int minSoldados = 3;
    private final String armaPadrao = "fuzil";

    private static int tamanhoExercito;
    private static int distanciaTodos;

    private int distancia;
    private String arma;
    private String nome;

    public Soldado() {
        if(tamanhoExercito<=10) {
            tamanhoExercito++;
            this.nome = "soldado" + Integer.toString(tamanhoExercito);
        }else{
            System.out.println("Exercito excedeu o tamanho, bora atacar");
        }
    }



    public int getDistanciaPadrao() {
        return distanciaPadrao;
    }

    public int getSoldados() {
        return tamanhoExercito -1;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void movimentar(int distancia){
        this.distancia = distancia;
        System.out.println(this.getNome() + " andou" + " " +this.distancia);
    }

    public void movimentar(){
        this.distancia = this.distanciaPadrao;
        System.out.println(this.getNome() + " andou" + " " +this.distanciaPadrao);
    }



    public void movimentarTodos(int d){
        distanciaTodos = d;
        System.out.println("Soldados andaram " + distanciaTodos);
    }

    public void atacar(String weapon){
        if(weapon.equals("fuzil") || weapon.equals("baioneta") || weapon.equals("punho")) {
            this.arma = weapon;
        }else{
            System.out.println("Arma inválida, mudando para o padrão");
            this.arma = armaPadrao;
        }
        if(tamanhoExercito <minSoldados+1) {
            System.out.println("ainda não, esperando o exército ficar maior");
        }else if(tamanhoExercito==this.maxSoldados+1){
            System.out.println("Atacando com todos os soldados");
        }
        else{
            System.out.println("ainda não há 10 soldados para atacar");
        }
        this.arma = weapon;

    }

    public void atacar(){
        this.arma = armaPadrao;
        if(tamanhoExercito <3) {
            System.out.println("ainda não, esperando o exército ficar maior");
        }else if(tamanhoExercito==10){
            System.out.println("Atacando com todos os soldados");
            }
        else{
            System.out.println("ainda não há 10 soldados para atacar");
        }
    }


}

