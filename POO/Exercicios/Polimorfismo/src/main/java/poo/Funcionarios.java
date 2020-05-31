package poo;

public abstract class Funcionarios
{
    private String nome;
    private String sobrenome;
    private String numeroSeguroSocial;
    private String cpf;
    public final double salarioFixoMensal = 2000.00;
//
    public Funcionarios(){};

    public Funcionarios(String nome, String sobrenome, String numeroSeguroSocial, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public abstract double calculaSalario();

    @Override
    public String toString() {
        return "Funcionarios{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", numeroSeguroSocial='" + numeroSeguroSocial + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }


}