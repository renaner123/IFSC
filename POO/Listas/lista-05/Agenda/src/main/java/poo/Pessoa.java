package poo;

import java.time.*;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    private Telefone telefones;
    private Email emails;


    public Pessoa(String nome, String sobrenome, LocalDate dataNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.telefones = new Telefone();
        this.emails = new Email();
    }

    public boolean addTelefone(String r, String n){
        return this.telefones.add(r,n);

    }
    public boolean addEmail(String r, String n){
        return this.emails.add(r,n);

    }
    public boolean removeTelefone(String r){
        return this.telefones.remove(r);

    }
    public boolean removeEmail(String r){
        return this.emails.remove(r);

    }
    public boolean updateTelefone(String r, String n){
        return this.telefones.update(r,n);

    }
    public boolean updateEmail(String r, String n){
        return this.emails.update(r,n);

    }

    public Pessoa getPessoa(){
        return this;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void getTelefone() {
        this.telefones.getTelefones();
    }

    public void getEmails() {
        this.emails.getEmais();
    }


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
