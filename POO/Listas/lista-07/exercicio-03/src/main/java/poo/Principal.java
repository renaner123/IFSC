package poo;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.*;
import java.util.*;


/**
 * Classe main do Projeto, responsável pela Agenda.
 */

public class Principal {

    public static void main(String[] args){
        List<Pessoa> pessoas = new ArrayList<>();
        List<Pessoa> pessoas2 = new ArrayList<>();
        //nome, sobrenome e data de nascimento



        pessoas.add(new Pessoa ("Joao", "Santos" , LocalDate.of(1991,01,01)));
        pessoas.add(new Pessoa ("Ana",  "Paula" , LocalDate.of(1989,01,01)));
        pessoas.add(new Pessoa ("Mello",  "Xuntengerg" , LocalDate.of(2000,01,01)));
        pessoas.add(new Pessoa ("Joao", "Silva", LocalDate.of(1980,01,01)));
        pessoas.add(new Pessoa ("Joao", "Silva" , LocalDate.of(1990,01,01)));
        pessoas.add(new Pessoa ("Renan", "Amaranto" , LocalDate.of(2013,01,01)));
        pessoas.add(new Pessoa ("Mello",  "Xuntengerg" , LocalDate.of(1995,01,01)));
        pessoas.add(new Pessoa ("Renan", "xibata" , LocalDate.of(2011,01,01)));
        pessoas.add(new Pessoa ("Amanda", "Zebra" , LocalDate.of(2011,01,01)));

        System.out.println(pessoas);
        Collections.sort(pessoas);
        System.out.println("Ordenado");
        System.out.println(pessoas);


    }

}
