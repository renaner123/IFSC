package poo;

public interface VeiculoTerrestre {

    public static final int VELMAX = 150;
    public static final int VELMIN = 0;

    public void frear(int intensidade);
    public void acelerar(int intensidade);
}
