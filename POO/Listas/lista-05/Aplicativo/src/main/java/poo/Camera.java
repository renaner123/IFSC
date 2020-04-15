package poo;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;

public class Camera {

    private boolean infraVermelho ;
    private ArrayList<String> fotos = new ArrayList<>();
    private boolean video;

    public void tirarFoto(int x, int y, int z){
        System.out.println("Foto capturada nas coordenadas " + " " + x + " " + y + " " + z);
        fotos.add(Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z));
    }

    public void filmar(){
        if(this.video==false){
            this.video = true;
            System.out.println("Iniciando a gravação");
        }else{
            this.video = false;
            System.out.println("Parando a gravação");
        }
    }

    public void ligarIF(){
        if(this.infraVermelho==false){
            this.infraVermelho = true;
            System.out.println("Infravermelho ligado");
        }else{
            this.infraVermelho = false;
            System.out.println("Infravermelho ligado");
        }
    }

    public void getFotosSalvas(){
        for(String mostra: fotos){
            System.out.println("Foto capturada em: " + mostra);
        }

    }

    @Override
    public String toString() {
        return "Camera{" +
                "infraVermelho=" + infraVermelho +
                ", fotos=" + fotos +
                ", video=" + video +
                '}';
    }
}
