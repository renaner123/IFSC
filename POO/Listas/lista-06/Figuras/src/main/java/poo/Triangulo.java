package poo;
/**
 * Classe responsável por criar um triangulo na posição X Y de tamanho a,b,c
 * @author  Renan Rodolfo da Silva
 */
public class Triangulo extends FiguraGeometrica {

    private int ladoA;
    private int ladoB;
    private int ladoC;

    /**
     *
     * @param posicaoX valor de x para posição inicial
     * @param posicaoY valor de y para posição inicial
     * @param ladoA valor do lado a
     * @param ladoB valor do lado b
     * @param ladoC valor do labo c
     */
    public Triangulo(int posicaoX, int posicaoY, int ladoA, int ladoB, int ladoC) {
        super(posicaoX, posicaoY);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }
    /**
     * Imprime na tela o tipo do senho e a posição
     */
    public void desenhar(){
        System.out.println("Triangulo de ladoA =" + this.ladoA + " ladoB =" + this.ladoB +
                " ladoC =" + this.ladoC  +", centralizado no ponto " + ponto.posicaoX +","+ponto.posicaoY);
    }

    /**
     *
     * @return valor da área do triângulo
     */
    public double calcularArea(){
        int a = this.ladoA; int b = this.ladoB; int c = this.ladoC;

        if((a < b + c) && (b < a + c) && (c < a + b)){
            if ((a == b) && (a == c)) { //Triangulo Equilatero"
                return ((Math.pow(a, 2) * Math.sqrt(3)) / 4);
            } else if (a == b || a == c) { //Triangulo Isosceles")
                if(a==b){
                    return (c*a)/2;
                }else{
                    return (b*a)/2;
                }
            } else {
                return a*c/2;     // "Triângulo Escaleno"
            }
        }else{
            return 0;
        }

    }

    /**
     *
     * @return valor do lado a
     */
    public int getLadoA() {
        return ladoA;
    }

    /**
     *
     * @param ladoA atribuir valor para lado a
     */
    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    /**
     *
     * @return retorna valor do lado b
     */
    public int getLadoB() {
        return ladoB;
    }

    /**
     *
     * @param ladoB atribui um valor para o lado b
     */
    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    /**
     *
     * @return valor do lado c
     */
    public int getLadoC() {
        return ladoC;
    }

    /**
     *
     * @param ladoC atribuir valor para o lado c
     */
    public void setLadoC(int ladoC) {
        this.ladoC = ladoC;
    }
}
