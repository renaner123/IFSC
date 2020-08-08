package poo;



import java.time.*;
import java.util.*;


/**
 * Classe responsável por criar pessoas
 *
 * @author Renan Rodlofo da Silva
 */

public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    private Telefone telefones;
    private Email emails;

    /**
     *
     * @param nome recebe o nome da Pessoa
     * @param sobrenome recebe sobrenome da Pessoa
     * @param dataNasc recebe data de nascimento da Pessoa
     */
    public Pessoa(String nome, String sobrenome, LocalDate dataNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.telefones = new Telefone();
        this.emails = new Email();
    }

    public Pessoa() {
        this.nome = "Renan";
        this.sobrenome = "Rodolfo da Silva";
        this.dataNasc = LocalDate.of(1993, 12, 6); ;
        this.telefones = new Telefone();
        this.emails = new Email();
    }

    /**
     *
     * @param r recebe rótulo do telefone da Pessoa
     * @param n recebe número da Pessoa
     * @return  true caso tenha sucesso, se não false.
     */
    public boolean addTelefone(String r, String n){
        return this.telefones.add(r,n);

    }

    /**
     *
     * @param r define rótulo do Email da Pessoa
     * @param n recebe e-mail da Pessoa
     * @return true caso tenha sucesso, se não false.
     */

    public boolean addEmail(String r, String n){
        return this.emails.add(r,n);

    }

    /**
     *
     * @param r recebe rótulo do telefone a ser removido
     * @return true caso tenha sucesso, se não false.
     */
    public boolean removeTelefone(String r){
        return this.telefones.remove(r);

    }

    /**
     *
     * @param r recebe rótulo do e-mail a ser removido
     * @return true caso tenha sucesso, se não false.
     */
    public boolean removeEmail(String r){
        return this.emails.remove(r);

    }

    /**
     *
     * @param r recebe rótulo do telefone da Pessoa
     * @param n recebe número do telefone da Pessoa
     * @return true caso tenha sucesso, se não false.
     */
    public boolean updateTelefone(String r, String n){
        return this.telefones.update(r,n);

    }

    /**
     *
     * @param r recebe rótulo do e-mail da Pessoa
     * @param n recebe e-mail da Pessoa
     * @return true caso tenha sucesso, se não false.
     */
    public boolean updateEmail(String r, String n){
        return this.emails.update(r,n);

    }

    /**
     *
     * @return Retorna uma Pessoa.
     */
    public Pessoa getPessoa(){
        return this;
    }

    /**
     *
     * @return Retorna o nome da Pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Retorna o sobrenome da Pessoa
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     *
     * @return Retorna a Data de nascimento da Pessoa
     */
    public LocalDate getDataNasc() {
        return dataNasc;
    }

    /**
     * Imprime na tela os telefones salvos na Agenda.
     */
    public void getTelefone() {
        this.telefones.getTelefones();
    }

    /**
     * Imprime na tela os e-mails salvos na Agenda.
     */
    public void getEmails() {
        this.emails.getEmais();
    }



    /*
    -1 menor que
     1 maior que
     0 igual
     */

    private int returnAsciiSum(String aux){
        int cont =0;
        for(int i=0;i<aux.length();i++){
            cont = cont + aux.charAt(i);
        }
        return cont;
    }

    public int compareTo(Pessoa o) {
        Object dado = o;
        if(this.nome.equals(o.nome)){
            if(this.sobrenome.equals(o.sobrenome)){
                if(this.dataNasc.equals(o.dataNasc)){
                    return 0;
                }else{
                    return this.dataNasc.compareTo(o.dataNasc);
                }
            }else{
                return this.sobrenome.compareTo(o.sobrenome);
            }
        }else{
            return this.nome.compareTo(o.nome);
        }
    }

    /**
     *
     * @return Imprime na tela os dados das Pessoas da Agenda.
     */
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNasc=" + dataNasc +
                ", telefones=" + telefones +
                ", emails=" + emails +
                ", '\n'" ;
    }
}
