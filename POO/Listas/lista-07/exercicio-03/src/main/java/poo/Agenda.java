package poo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Classe responsável pela Agenda da Pessoa
 * @author Renan Rodolfo da Silva
 */

public class Agenda {

    private CopyOnWriteArrayList<Pessoa> contatos = new CopyOnWriteArrayList<Pessoa>();

    public void addPessoa(Pessoa p){
        this.contatos.add(p);
    }

    /**
     *
     * @param n Recebe nome da Pessoa
     * @param s Recebe sobrenome da Pessoa
     * @return true caso tenha sucesso, se não false.
     */
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

    /**
     *
     * @param r recebe rótulo do telefone
     * @param n recebe número da Pessoa
     * @param pindex recebe posição em que o contato está na agenda
     * @return true caso tenha sucesso, se não false.
     */
    public boolean addTelefone(String r, String n, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.addTelefone(r,n);

    }

    /**
     *
     * @param r recebe rótulo do e-mail
     * @param e recebe e-mail da Pessoa
     * @param pindex recebe posição em que o contato está na agenda
     * @return true caso tenha sucesso, se não false.
     */
    public boolean addEmail(String r,String e, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.addEmail(r,e);

    }

    /**
     *
     * @param r recebe rótulo do telefone
     * @param e recebe telefone da Pessoa
     * @param pindex recebe posição em que o contato está na agenda
     * @return true caso tenha sucesso, se não false.
     */
    public boolean updateTelefone(String r,String e, int pindex) {
        return this.addTelefone(r,e,pindex);

    }
    /**
     *
     * @param r recebe rótulo do e-mail
     * @param e recebe e-mail da Pessoa
     * @param pindex recebe posição em que o contato está na agenda
     * @return true caso tenha sucesso, se não false.
     */

    public boolean updateEmail(String r,String e, int pindex){
        return this.addEmail(r,e,pindex);

    }

    /**
     *
     * @param r recebe rótulo do telefone a ser removido
     * @param pindex recebe posição que o contato está na agenda
     * @return true caso tenha sucesso, se não false.
     */

    public boolean removeTelefone(String r, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.removeTelefone(r);

    }
    /**
     *
     * @param r recebe rótulo do e-mail a ser removido
     * @param pindex recebe posição que o contato está na agenda
     * @return true caso tenha sucesso, se não false.
     */
    public boolean removeEmail(String r, int pindex){
        Pessoa elemento = this.contatos.get(pindex);
        return elemento.removeEmail(r);

    }

    /**
     *
     * @param n recebe nome da Pessoa
     * @param b recebe sobrenome da Pessoa
     * Imprime na tela as informações da Pessoa
     */
    public void getContato(String n, String b){
        for(Pessoa elemento : contatos){
            if(elemento.getNome().equals(n) && elemento.getSobrenome().equals(b)){
                System.out.println(elemento);
                elemento.getTelefone();
                System.out.println("\n");
            }
        }
    }

    /**
     * Imprime todos os contatos na tela.
     */
    public void getContatos(){
        for(Pessoa elemento : contatos){
            System.out.println(elemento);
        }
    }

    /**
     *
     * @param n Recebe nome da Pessoa
     * @param s Recebe telefone da Pessoa
     * Imprime Telefone da Pessoa formatada.
     */
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
