package poo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Agenda {

    private CopyOnWriteArrayList<Pessoa> contatos = new CopyOnWriteArrayList<Pessoa>();

    public void addPessoa(Pessoa p){
        this.contatos.add(p);
    }

    public boolean removePessoa(String n,String s){
        Iterator<Pessoa> iteracao = contatos.iterator();
        while(iteracao.hasNext()){
            Pessoa elemento = iteracao.next();
            if(elemento.getNome().equals(n) && (elemento.getSobrenome().equals(s))){
                iteracao.remove();
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean addTelefone(String r, String n, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.addTelefone(r,n);

    }
    public boolean addEmail(String r,String e, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.addEmail(r,e);

    }
    public boolean updateTelefone(String r,String e, int pindex) {
        return this.addTelefone(r,e,pindex);

    }
    public boolean updateEmail(String r,String e, int pindex){
        return this.addEmail(r,e,pindex);

    }
    public boolean removeTelefone(String r, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.removeTelefone(r);

    }
    public boolean removeEmail(String r, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.removeEmail(r);

    }
    public void getContato(String n, String b){
        for(Pessoa elemento : contatos){
            if(elemento.getNome().equals(n) && elemento.getSobrenome().equals(b)){
                System.out.println(elemento);
                elemento.getTelefone();
                System.out.println("\n");
            }
        }
    }

    public void getContatos(){
        for(Pessoa elemento : contatos){
            System.out.println(elemento);
        }
    }

    public void getTelefone(String n, String s){
        for(Pessoa elemento: contatos){
            if(elemento.getNome().equals(n) && (elemento.getSobrenome().equals(s))){
                elemento.getTelefone();
            }else{

            }
        }
    }



    @Override
    public String toString() {
        return "Agenda{" +
                "contatos=" + contatos +
                '}';
    }
}
