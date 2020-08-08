package poo;

public class Carta {

    private Naipes naipes;
    private Valores valores;

    public Carta(Valores valores,Naipes naipes) {
        this.naipes = naipes;
        this.valores = valores;
    }


    public Naipes getNaipes() {
        return naipes;
    }

    public void setNaipes(Naipes naipes) {
        this.naipes = naipes;
    }

    public Valores getValores() {
        return valores;
    }

    public void setValores(Valores valores) {
        this.valores = valores;
    }
}
