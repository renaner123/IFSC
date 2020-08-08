package poo;

public class Ferrari extends Veiculo implements Conversivel{

    private boolean farolNeblina=false;
    private boolean capota;

    public Ferrari(String nome) {
        super(nome);
    }

    @Override
    public boolean abrirCapota() {
        if(this.getVelocidade()<=20) {
            return this.setCapota(true);
        }else{
            return false;
        }
}
    @Override
    public boolean fecharCapota() {
        if(this.getVelocidade()<=20){
            return this.setCapota(false);
        }else{
            return false;
        }
    }

    public boolean isFarolNeblina() {
        return farolNeblina;
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

    public boolean ligarFarolNeblina(){
        if(this.farolNeblina==false){
            this.farolNeblina = true;
        }else{
            this.farolNeblina =false;
        }
        return true;
    }
}
