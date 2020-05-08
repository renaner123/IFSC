package poo;
/**
 * Classe responsável por criar uma linha na posição X Y até X Y
 * @author  Renan Rodolfo da Silva
 */
public class Linha extends Ponto {

    private int posicaoXfinal;
    private int posicaoYfinal;

    /**
     *
     * @param posicaoX valor de x para posição inicial
     * @param posicaoY valor de y para posição inicial
     * @param posicaoXfinal valor de x para posição final
     * @param posicaoYfinal valor de y para posição final
     */
    public Linha(int posicaoX, int posicaoY, int posicaoXfinal, int posicaoYfinal) {
        super(posicaoX, posicaoY);
        this.posicaoXfinal = posicaoXfinal;
        this.posicaoYfinal = posicaoYfinal;

    }
    /**
     * Imprime na tela o tipo do senho e a posição
     */
    public void desenhar(){
        System.out.println("Desenhando uma linha na posição: "+ posicaoX+","+posicaoY+ " até: "+this.posicaoXfinal+","+this.posicaoYfinal);
    }

    /**
     *
     * @return posição final de x
     */
    public int getPosicaoXfinal() {
        return posicaoXfinal;
    }

    /**
     *
     * @param posicaoXfinal seta posição final de x
     */
    public void setPosicaoXfinal(int posicaoXfinal) {
        this.posicaoXfinal = posicaoXfinal;
    }

    /**
     *
     * @return posição final de y
     */
    public int getPosicaoYfinal() {
        return posicaoYfinal;
    }

    /**
     *
     * @param posicaoYfinal seta posição final de y
     */
    public void setPosicaoYfinal(int posicaoYfinal) {
        this.posicaoYfinal = posicaoYfinal;
    }
}
