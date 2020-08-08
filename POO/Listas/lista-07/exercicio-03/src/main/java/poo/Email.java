package poo;

import java.util.HashMap;

/**
 * Classe responsável pelo Email de Pessoa
 * @author  Renan Rodolfo da Silva
 */

public class Email {
    private HashMap<String,String> dados = new HashMap<>();;

    /**
     *
     * @param r recebe rótulo do Email
     * @param e recebe Email da Pessoa
     * @return true caso tenha sucesso, se não false.
     */

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

    /**
     *
     * @param r recebe rótulo do Email a ser removido
     * @return true caso tenha sucesso, se não false.
     */
    public boolean remove(String r){
        this.dados.remove(r);
        return true;
    }

    /**
     *
     * @param r recebe rótulo do e-mail
     * @param e recebe e-mail da Pessoa
     * @return true caso tenha sucesso, se não false.
     */
    public boolean update(String r,String e){
        this.add(r,e);
        return true;
    }

    /**
     * Imprime na tela os e-mails.
     */
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
