package poo;
/**
 * Classe responsável por criar um cubo na posição X Y com tamanho aresta
 * @author  Renan Rodolfo da Silva
 */
public class Cubo extends FiguraGeometrica{

    private int aresta;

    /**
     *
     * @param posicaoX valor de x para posição inicial
     * @param posicaoY valor de y para posição inicial
     * @param aresta tamanho da aresta do cubo
     */
    public Cubo(int posicaoX, int posicaoY, int aresta) {
        super(posicaoX, posicaoY);
        this.aresta = aresta;
    }
    /**
     * Imprime na tela o tipo do senho e a posição
     */
    public void desenhar(){
        System.out.println("Cubo de arestas "+this.aresta + ", centralizado no ponto " + ponto.posicaoX +","+ponto.posicaoY);
    }

    /**
     *
     * @return valor da área do cubo
     */
    public double calcularArea(){
        return 6*this.aresta;
    }

    /**
     *
     * @return valor da aresta
     */
    public int getAresta() {
        return aresta;
    }

    /**
     *
     * @param aresta seta valor da aresta
     */
    public void setAresta(int aresta) {
        this.aresta = aresta;
    }
}
