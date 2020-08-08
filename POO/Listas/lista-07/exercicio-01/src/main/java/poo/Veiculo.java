package poo;

public abstract class Veiculo implements VeiculoTerrestre {

    private String nome;
    private int velocidade;

    public Veiculo(String nome) {
        this.nome = nome;
    }

    @Override
    public void frear(int intensidade) {
        if(this.velocidade-intensidade>= VELMIN){
            this.velocidade = this.velocidade - intensidade;
        }else{
            this.velocidade = this.velocidade;
        }
    }

    @Override
    public void acelerar(int intensidade) {
        if(this.velocidade+intensidade<=VELMAX){
            this.velocidade = this.velocidade + intensidade;
        }else{
            this.velocidade = this.velocidade;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
}