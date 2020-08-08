package poo;

public class Panther extends Veiculo implements Conversivel,TracaoIntegral, VeiculoAnfibio {

    private int temp;
    private boolean rodas;
    private boolean capota;
    private boolean tracao;


    public Panther(String nome) {
        super(nome);
    }

    @Override
    public boolean abrirCapota() {
        if(this.getVelocidade()==0) {
            return this.setCapota(true);
        }else{
            return false;
        }
    }
    @Override
    public boolean fecharCapota() {
        if(this.getVelocidade()==0){
            return this.setCapota(false);
        }else{
            return false;
        }
    }

    @Override
    public boolean ativarDesativarTracao() {

        if(this.isRodas()==true){
            if(this.tracao==false){
                this.tracao = true;
                return true;
            }else{
                this.tracao = false;
                return true;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean recolherRodas() {
        if(this.temp==0) {
            if (this.setRodas(false) == true) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean abrirRodas() {
        if(this.setRodas(true)==true){
            return true;
        }else{
            return false;
        }
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        if(temp>0 && temp<200){
            this.temp = temp;
        }
    }

    public boolean isCapota() {
        return capota;
    }

    private boolean setCapota(boolean capota) {
        if(capota == true && this.capota==true){
            return false;
        }else if(capota == false && this.capota==false){
            return false;
        }else{
            this.capota = capota;
            return true;
        }
    }

    public boolean isTracao() {
        return tracao;
    }

    private void setTracao(boolean tracao) {
        this.tracao = tracao;
    }

    public boolean isRodas() {
        return rodas;
    }

    private boolean setRodas(boolean rodas) {
        if(rodas == true && this.rodas==true){
            return false;
        }else if(rodas == false && this.rodas==false){
            return false;
        }else{
            this.rodas = rodas;
            return true;
        }
    }


    @Override
    public void esvaziarLastro() {
        this.temp = 0;
    }
}

