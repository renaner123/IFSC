package poo;

public class Comissionado extends Funcionarios
{
    protected double vendas; // vendas brutas semanais
    protected double comissao; // porcentagem da comissão



    public Comissionado(String nome, String sobrenome, String numeroSeguroSocial, String cpf, double vendas, double comissao) {
        super(nome, sobrenome, numeroSeguroSocial, cpf);
        this.vendas = vendas;
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario() {
        return vendas*comissao;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }


}