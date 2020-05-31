package poo;

public class Mensalfixo extends Funcionarios
{

    public Mensalfixo(String nome, String sobrenome, String numeroSeguroSocial, String cpf) {
        super(nome, sobrenome, numeroSeguroSocial, cpf);
    }
//
    @Override
    public double calculaSalario() {
       return salarioFixoMensal;
    }



}