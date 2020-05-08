package poo;
/**
 * Classe responsável por criar um circulo na posição X Y de tamanho r
 * @author  Renan Rodolfo da Silva
 */
public class Circulo extends FiguraGeometrica {

    private int raio;

    /**
     *
     * @param posicaoX valor de x para posição inicial
     * @param posicaoY valor de y para posição inicial
     * @param raio valor do raio
     */
    public Circulo(int posicaoX, int posicaoY, int raio) {
        super(posicaoX, posicaoY);
        this.raio = raio;
    }
    /**
     * Imprime na tela o tipo do senho e a posição
     */
    public void desenhar(){
        System.out.println("Circulo de raio "+this.raio + ", centralizado no ponto " + ponto.posicaoX +","+ponto.posicaoY);
    }

    /**
     *
     * @return valor da área do circulo
     */
    public double calcularArea(){
        return 3.14*Math.pow(this.raio,2);
    }

    /**
     *
     * @return valor do raio
     */
    public int getRaio() {
        return raio;
    }

    /**
     *
     * @param raio atruibui valor do raio
     */
    public void setRaio(int raio) {
        this.raio = raio;
    }
}
