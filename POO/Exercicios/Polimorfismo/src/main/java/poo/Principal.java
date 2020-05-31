package poo;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Mensalfixo f1 = new Mensalfixo("Renan","Rodolfo","1245","08227502909");
        Horista f2 = new Horista("Pedro","Cunha","1030","12345678901",50,20);
        Comissionado f3 = new Comissionado("Naiara","Chagas","1232","12845631021",27150.50,0.12);
        ComissionadoEfetivo f4 = new ComissionadoEfetivo("Lara","Chagas","1456","12598745347",12780.80,0.12);
        ComissionadoEfetivo f5 = new ComissionadoEfetivo("Tonho","Parafuso","1456","12799746347",10780.80,0.10);

        ArrayList<Funcionarios> funcs = new ArrayList<>();

        funcs.add(f1);
        funcs.add(f2);
        funcs.add(f3);
        funcs.add(f4);
        funcs.add(f5);

        // Gerando folha de pagamento dos funcionários
        for(Funcionarios carreira : funcs){
            System.out.println(carreira.toString()+ " " + carreira.getClass());
            System.out.println("Salário Mensal: " + carreira.calculaSalario());

        }
        System.out.println("\nAcrescimo de 10% no salario base de ComissinadoEfetivo");

        // Gerancando acrescimo de 10% para salario base doComissionadaEfetico
        for(Funcionarios carreira : funcs){
            if(carreira instanceof ComissionadoEfetivo) {
                ((ComissionadoEfetivo) carreira).salarioBaseComissionado = ((ComissionadoEfetivo) carreira).salarioBaseComissionado *1.1;
                System.out.println(carreira.toString() + " " + carreira.getClass());
                System.out.println("Salário Mensal: " + carreira.calculaSalario());
            }else{
                continue;
            }
        }



    }


}
