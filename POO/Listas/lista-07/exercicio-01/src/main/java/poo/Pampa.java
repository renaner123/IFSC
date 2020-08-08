package poo;

public class Pampa extends Veiculo implements TracaoIntegral {

    private boolean cacamba;
    private boolean tracao;

    public Pampa(String nome) {
        super(nome);
    }

    @Override
    public boolean ativarDesativarTracao() {
        if(this.getVelocidade()==0){
            if(this.tracao==false){
                this.tracao = true;
            }else{
                this.tracao = false;
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean abrirCacamba(){
        if(this.getVelocidade()==0){
            return this.setCacamba(true);
        }
            return false;
    }

    public boolean fecharCacamba(){
        if(this.getVelocidade()==0){
            return this.setCacamba(false);
        }else{
            return false;
        }
    }

    public boolean isCacamba() {
        return cacamba;
    }

    private boolean setCacamba(boolean cacamba) {
        if(cacamba == true && this.cacamba==true){
            return false;
        }else if(cacamba == false && this.cacamba==false){
            return false;
        }else{
            this.cacamba = cacamba;
            return true;
        }
    }

    public boolean isTracao() {
        return tracao;
    }


}
