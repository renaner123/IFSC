package poo;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Ferrari f1 = new Ferrari("Trovao");
        Pampa p1 = new Pampa("Fedida");
        Panther ph1 = new Panther("Tubarao");

        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(f1);
        veiculos.add(p1);
        veiculos.add(ph1);

        /*
       OK   –Só é possível abrir a caçamba se o carro estiver parado
       Ok   –Só é possível ativar ou desativar a tração integral se o veículo estiver parado
       Ok     –Só é possível ativar a tração integral se o veículo anfíbio estiver com as rodas abertas
       Ok   –Só é possível abrir ou fechar a capota se o carro estiver parado,  com exceção daFerrari,
                pois essa permite fazer isso se a velocidade estiver abaixo dos 20km/h
       Ok    –Ao recolher as rodas é necessário esvaziar o lasto
        */

        for(Veiculo obj : veiculos){
            if(obj instanceof Ferrari){
                System.out.println((((Ferrari) obj).abrirCapota() ? "Abriu capota" : "Não pode abrir capota"));
                obj.acelerar(50);
                System.out.println((((Ferrari) obj).fecharCapota() ? "Fechou capota" : "Não pode fechar capota"));
                obj.frear(35);
                System.out.println((((Ferrari) obj).fecharCapota() ? "Fechou capota" : "Não pode fechar capota"));
                System.out.println(" ");

            }else if(obj instanceof Pampa){
                obj.acelerar(60);
                System.out.println((((Pampa) obj).abrirCacamba() ? "Abriu caçamba" : "Não pode abrir caçamba"));
                obj.frear(60);
                System.out.println((((Pampa) obj).abrirCacamba() ? "Abriu caçamba" : "Não pode abrir caçamba"));
                System.out.println((((Pampa) obj).ativarDesativarTracao() ? "Ativou/Desativou tração" : "Não pode Ativar/Desativar tração"));
                System.out.println(" ");

            }else if(obj instanceof Panther){
                System.out.println(((Panther) obj).ativarDesativarTracao() ? "Ativou/Desativou tração" : "Não pode Ativar/Desativar tração");
                System.out.println((((Panther) obj).abrirRodas() ? "Abriu rodas" : "Não pode abrir rodas"));
                System.out.println(((Panther) obj).ativarDesativarTracao() ? "Ativou/Desativou tração" : "Não pode Ativar/Desativar tração");
                ((Panther) obj).setTemp(50);
                System.out.println(((Panther) obj).recolherRodas()? "Recolheu rodas" : "Não pode recolher rodas");
                ((Panther) obj).esvaziarLastro();
                System.out.println(((Panther) obj).recolherRodas()? "Recolheu rodas" : "Não pode recolher rodas");

            }else{
                continue;
            }





        }




    }
}
