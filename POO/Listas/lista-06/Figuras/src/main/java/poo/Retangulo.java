package poo;
/**
 * Classe responsável por criar um retangulo na posição X Y com tamanho base,altura
 * @author  Renan Rodolfo da Silva
 */
public class Retangulo extends FiguraGeometrica {

    private int base;
    private int alltura;

    /**
     *
     * @param posicaoX valor de x para posição inicial
     * @param posicaoY valor de y para posição inicial
     * @param base valor da base do rentangulo
     * @param alltura valor da altura do retangulo
     */
    public Retangulo(int posicaoX, int posicaoY, int base, int alltura) {
        super(posicaoX, posicaoY);
        this.base = base;
        this.alltura = alltura;
    }
    /**
     * Imprime na tela o tipo do senho e a posição
     */
    public void desenhar(){
        System.out.println("Retangulo de base= "+this.base + " altura= "+this.alltura +", centralizado no ponto " + ponto.posicaoX +","+ponto.posicaoY);
    }

    /**
     *
     * @return cálculo da área do retangulo
     */
    public double calcularArea(){
        return this.base*this.alltura;
    }

    /**
     *
     * @return valor da base
     */
    public int getBase() {
        return base;
    }

    /**
     *
     * @param base atribuir valor da base
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     *
     * @return valor da altura
     */
    public int getAlltura() {
        return alltura;
    }

    /**
     *
     * @param alltura atribuir valor da altura
     */
    public void setAlltura(int alltura) {
        this.alltura = alltura;
    }
}
