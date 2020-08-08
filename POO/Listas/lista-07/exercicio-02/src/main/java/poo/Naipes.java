package poo;

public enum Naipes {
    PAUS(1), COPAS(2), ESPADAS(3),OUROS(4);

    public int valorCarta;

    Naipes(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public static Naipes getByCodigo(int c){
        for (Naipes naipe: Naipes.values()){
            if (c == naipe.valorCarta){
                return naipe;
            }
        }
        throw new IllegalArgumentException("ćodigo inv́alido");
    }

}
