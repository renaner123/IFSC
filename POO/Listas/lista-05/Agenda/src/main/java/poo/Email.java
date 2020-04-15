package poo;

import java.util.HashMap;

public class Email {
    private HashMap<String,String> dados = new HashMap<>();;

    public boolean add(String r, String e){
        String emailER =
                "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

        String email = e;
        if((email.matches(emailER)==true)){
            this.dados.put(r,e);
            return true;
        }else{
            return false;
        }
    }
    public boolean remove(String r){
        this.dados.remove(r);
        return true;
    }

    public boolean update(String r,String e){
        this.add(r,e);
        return true;
    }
    public void getEmais(){
        dados.forEach((chave, valor)-> {
            System.out.println(chave + " " + valor);
        });
    }


    @Override
    public String toString() {
        return "Email{" +
                "dados=" + dados +
                '}';
    }
}
