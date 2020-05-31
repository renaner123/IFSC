package poo;


public class Horista extends Funcionarios
{
    private double valorHora; // salário por hora
    private double horas; // horas trabalhadas durante a semana

    public Horista(String nome, String sobrenome, String numeroSeguroSocial, String cpf, double salarioHora, double horas) {
        super(nome, sobrenome, numeroSeguroSocial, cpf);
        this.valorHora = salarioHora;
        this.horas = horas;
    }
//
    @Override
    public double calculaSalario() {
        return salarioFixoMensal + (this.valorHora *horas);
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

}