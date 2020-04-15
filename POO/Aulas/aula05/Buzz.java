package poo;
import java.util.*;

public class Buzz {

    private List frases = new ArrayList();
    private String laser = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    private boolean assas;
    private boolean capacete;


    public String oberFrase(){
        Random Rand = new Random();
        frases.add("Isto não é voar. Isto é cair, com estilo!");
        frases.add("Ao infinito e além!");
        frases.add("Nunca duvidei de mim mesmo, Comandante, e não vou começar agora!");
        frases.add("Embora você tenha tentado acabar comigo, a vingança não é um ideal que promovemos no meu planeta.");
        frases.add("Deus não é aquilo que vai no infinito e no além. O nome disso é Buzz Lightyear. Deus é outra coisa.");
        frases.add("Eu sou seu Buzz Lightyear\n" +
                "Vamo voar\n" +
                "Pra bem longe daqui\n" +
                "Ao infinito e além!");
        int aux = Rand.nextInt(6);
        return frases.get(aux).toString();
    }

    public boolean ativarAssa(){

        if(assas == false){
            assas = true;
        }
        return assas;
    }
    public boolean desativarAssa(){

        if(assas == true){
            assas = false;
        }
        return assas;
    }

    public String dispararLaser(){
        return laser;
    }

    public boolean retrairCapacete(){

        if(capacete == false){
            capacete = true;
        }else if(capacete == true){
            capacete = false;
        }
        return capacete;
    }




}
