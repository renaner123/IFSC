package poo;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Baralho b = new Baralho();


        b.criarBaralho();
        System.out.println(b.getQuantidadeCartasBaralho());
        //b.mostrarBaralho();
        b.embaralhar();
        //b.mostrarBaralho();
        Carta card1 = b.retirarUmaCartaAleatoria();
        System.out.println(card1.getValores() + " " + card1.getNaipes());
        Carta card2 = b.retirarUmaCartaAleatoria();
        System.out.println(card2.getValores() + " " + card2.getNaipes());
        System.out.println(b.getQuantidadeCartasBaralho());
        System.out.println(" ");
        ArrayList<Carta> cards1 = b.retirarNCartasAleatorias(5);
        for(Carta cardscin : cards1){
            System.out.println(cardscin.getValores() + " " + cardscin.getNaipes());
        }
        System.out.println(b.getQuantidadeCartasBaralho());
        System.out.println(" ");
        Carta card3 = b.retirarUmaCartaNaipe(Naipes.ESPADAS);
        System.out.println(card3.getValores() + " " + card3.getNaipes());
        Carta card4 = b.retirarUmaCartaValores(Valores.CINCO);
        System.out.println(card4.getValores() + " " + card4.getNaipes());
        System.out.println(b.getQuantidadeCartasBaralho());
        b.embaralhar();
        b.devolverCartaBaralho(card1);
        System.out.println(b.getQuantidadeCartasBaralho());
        b.devolverCartaBaralho(cards1);
        System.out.println(b.getQuantidadeCartasBaralho());







    }
}
