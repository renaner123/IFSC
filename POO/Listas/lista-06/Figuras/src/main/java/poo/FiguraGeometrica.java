package poo;
/**
 * Classe Pai que possui métodos e atributos comuns a todos
 * @author  Renan Rodolfo da Silva
 */
public class FiguraGeometrica {

    protected Ponto ponto;

    /**
     *
     * @param posicaoX valor de x para posição inicial
     * @param posicaoY valor de y para posição inicial
     */
    public FiguraGeometrica(int posicaoX, int posicaoY){
        ponto = new Ponto(posicaoX,posicaoY);
    }

    public void desenhar(){
        System.out.println("Figura geométrica");
    }



}
