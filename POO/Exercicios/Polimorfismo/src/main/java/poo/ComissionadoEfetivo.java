package poo;

public class ComissionadoEfetivo extends Comissionado
{

    public double salarioBaseComissionado = 1000; //

    public ComissionadoEfetivo(String nome, String sobrenome, String numeroSeguroSocial, String cpf, double vendas, double comissao) {
        super(nome, sobrenome, numeroSeguroSocial, cpf, vendas, comissao);

    }

    @Override
    public double calculaSalario() {
        return salarioBaseComissionado + (vendas*comissao);
    }


    @Override
    public void setComissao(double comissao) {

    }

}