package poo;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.*;

/**
 * Classe responsável pelos telefones de Pessoa
 *
 * @author Renan Rodolfo da Silva
 */

public class Telefone {

    private HashMap<String, String> dados = new HashMap<>();
    private StringBuilder sb = new StringBuilder();

    /**
     *
     * @param r recebe rótulo do telefone
     * @param n recebe número do telefone
     * @return true caso tenha sucesso, se não false.
     */

    public boolean add(String r,String n){
        if((n.matches("[0-9]+")==true)){
            this.dados.put(r,n);
            dados.forEach((chave, valor)->{
                sb.append(valor+"\n");
                });
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param mascara recebe máscara para ser formatada
     * @param valor recebe o valor que irá ficar conforme a máscara
     * @return Retorna o valor formatado com a máscara
     */
    private String formata(String mascara, String valor){
        MaskFormatter mask = null;
        String resultado = "";
        try {
            mask = new MaskFormatter(mascara);
            mask.setValueContainsLiteralCharacters(false);
            mask.setPlaceholderCharacter('_');
            resultado = mask.valueToString(valor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /**
     * Imprime na tela os telefones no formato "+55 (##) #########"
     */
    public void getTelefones(){
        dados.forEach((chave, valor)-> {
            System.out.println(chave + " " + this.formata("+55 (##) #########",valor));
        });
    }

    /**
     *
     * @param r recebe rótulo do telefone a ser removido
     * @return true caso tenha sucesso, se não false.
     */
    public boolean remove(String r){
        this.dados.remove(r);
        return true;
    }

    /**
     *
     * @param r recebe rótulo do telefone
     * @param n recebe o novo telefone
     * @return true caso tenha sucesso, se não false.a
     */
    public boolean update(String r,String n){
        this.add(r,n);
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "dados=" + dados +
                '}';
    }
}
