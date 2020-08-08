package poo;

public enum Valores {
    AS(1),DOIS(2),TRES(3),QUATRO(4),CINCO(5),SEIS(6),SETE(7),OITO(8),NOVE(9),DEZ(10),VALETE(11),DAMA(12),REI(13);

    public int valorCarta;

    Valores(int valorCarta) {
        this.valorCarta = valorCarta;
    }
    Valores() {

    }
    public static Valores getByCodigo(int c){
        for (Valores carta: Valores.values()){
            if (c == carta.valorCarta){
                return carta;
            }
        }
        throw new IllegalArgumentException("ćodigo inv́alido");
    }
}