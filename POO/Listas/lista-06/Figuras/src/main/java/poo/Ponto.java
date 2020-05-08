package poo;
/**
 * Classe responsável por criar um ponto na posição X Y
 * @author  Renan Rodolfo da Silva
 */

public class Ponto {

    protected int posicaoX;
    protected int posicaoY;

    /**
     *
     * @param posicaoX valor de x no plano cartesiano
     * @param posicaoY valor de y no plano cartesiano
     */
    public Ponto(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    /**
     * Imprime na tela o tipo do senho e a posição
     */
    public void desenhar(){
        System.out.println("Desenhando um ponto em: " +  this.posicaoX + ", " + this.posicaoY);
    }

    /**
     *
     * @return posição de X
     */
    public int getPosicaoX() {
        return posicaoX;
    }

    /**
     *
     * @return posição de y
     */
    public int getPosicaoY() {
        return posicaoY;
    }

    /**
     *
     * @param posicaoX seta a posição de x
     */
    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    /**
     *
     * @param posicaoY seta a posição de y
     */
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
}
