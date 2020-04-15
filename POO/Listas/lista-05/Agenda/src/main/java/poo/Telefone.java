package poo;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.*;

public class Telefone {

    private HashMap<String, String> dados = new HashMap<>();
    private StringBuilder sb = new StringBuilder();

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

    public void getTelefones(){
        dados.forEach((chave, valor)-> {
            System.out.println(chave + " " + this.formata("+55 (##) #########",valor));
        });
    }

    public boolean remove(String r){
        this.dados.remove(r);
        return true;
    }

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
