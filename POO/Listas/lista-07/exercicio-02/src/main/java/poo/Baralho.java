package poo;

import java.lang.reflect.Array;
import java.util.*;

public class Baralho{

    private List<Carta> baralho = new ArrayList<Carta>();
    private Random gerador = new Random();
    private final Naipes NAIPEDEFAULT = Naipes.OUROS;
    private final Valores VALORDEFAULT = Valores.AS;


    public Baralho() {

    }

    /**
     * Gera um baralho com 52 cartas
     */
    public void criarBaralho(){
        for(Naipes nai_card : Naipes.values()){
            for(Valores val_card : Valores.values()){
                baralho.add(new Carta(val_card,nai_card));
            }
        }
    }

    /**
     * Embaralho o baralho.
     */
    public void embaralhar(){
        Collections.shuffle(baralho);
    }

    /**
     *
     * @return a quantidade de cartas atual no baralho
     */
    public int getQuantidadeCartasBaralho(){
        return baralho.size();
    }

    /**
     *
     * @return uma carta com valor e naipe aleatório
     */
    public Carta retirarUmaCartaAleatoria(){
        Carta aux = baralho.get(gerador.nextInt(baralho.size()-1));
        Iterator<Carta> iteracao = baralho.iterator();
        while(iteracao.hasNext()){
            Carta elemento = iteracao.next();

            if (elemento.equals(aux)){
                iteracao.remove();
            }
        }
        return aux;

    }

    /**
     *
     * @param n Quantidade de cartas a serem retiradas do baralho
     * @return um ArrayList contendo as cartas retiradas.
     */
    public ArrayList<Carta> retirarNCartasAleatorias(int n){
        ArrayList<Carta> cards = new ArrayList<>();
        for(int i=0;i<n;i++) {
            Carta aux = baralho.get(gerador.nextInt(baralho.size()-1));
            Iterator<Carta> iteracao = baralho.iterator();
            while (iteracao.hasNext()) {
                Carta elemento = iteracao.next();
                if (elemento.equals(aux)) {
                    iteracao.remove();
                }
            }
            cards.add(aux);
        }
        return cards;
    }

    /**
     *
     * @param card Naipe que se deseja retirar uma carta
     * @return uma carta do Naipe recebido em card
     */
    public Carta retirarUmaCartaNaipe(Naipes card) {
        Carta aux = new Carta(VALORDEFAULT,NAIPEDEFAULT);
        Iterator<Carta> iteracao = baralho.iterator();
        while (iteracao.hasNext()) {
            Carta elemento = iteracao.next();
            if (elemento.getNaipes().equals(card)) {
                iteracao.remove();
                aux = elemento;
                break;
            }
        }
        return aux;
    }

    /**
     *
     * @param card Valor que se deseja retirar uma carta
     * @return uma carta do Valor recebido em card
     */
    public Carta retirarUmaCartaValores(Valores card){
        Carta aux = new Carta(VALORDEFAULT,NAIPEDEFAULT);
        Iterator<Carta> iteracao = baralho.iterator();
        while (iteracao.hasNext()) {
            Carta elemento = iteracao.next();
            if (elemento.getValores().equals(card)) {
                iteracao.remove();
                aux = elemento;
                break;
            }
        }
        return aux;
    }

    /**
     *
     * @param card que se deseja adiconar de volta ao baralho
     * @return true caso ela não exista no baralho ou false se já existir.
     */
    public boolean devolverCartaBaralho(Carta card){
        if(baralho.contains(card)){
            return false;
        }else{
            baralho.add(card);
            return true;
        }
    }

    /**
     *
     * @param cards ArrayList de cartas a serem adicionadas no baralho.
     */
    public void devolverCartaBaralho(ArrayList<Carta> cards){
     for(Carta runCards : cards){
         if(baralho.contains(runCards)){
             continue;
         }else{
             baralho.add(runCards);
         }
     }
    }

    /**
     * Imprime todas as cartas do baralho.
     */
    public void mostrarBaralho(){
        for(Carta cards : baralho){
            System.out.println(cards.getValores() + " " + cards.getNaipes());
        }
    }


}
