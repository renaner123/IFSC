package poo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Pai das publicações.
 * @author Renan Rodolfo da Silva
 */
public class Entrada {

    private String author;
    private int month;
    private String title;
    private int year;
    private String id;
    public static HashMap<String,HashMap<String,String>> baseBibliografica = new HashMap<String,HashMap<String,String>>();
    public HashMap<String,String> publicacao = new HashMap<String,String>(); //para conseguir usar Construtor dentro de um construtor

    /**
     *
     * @param author Nome do autor
     * @param month Mês da publicação
     * @param title Título da publicação
     * @param year Ano da publicação
     * @param id Identificação única.
     */
    public Entrada(String id,String author, int month, String title, int year) {
        this(id,author,title,year);
        this.month = month;
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título da entrada
     * @param year Ano da entrada
     */
    public Entrada(String id,String author, String title, int year) {
        this(id,title);
        this.author = author;
        this.year = year;
    }
    /**
     *
     * @param id identifiação
     * @param title Título da entrada
     */
    public Entrada(String id,String title) {
        this.title = title;
        this.id = id;
    }

    public Entrada() {
    }

    /**
     *
     * @return Base bibliográfica
     */
    public HashMap<String, HashMap<String, String>> getBaseBibliografica() {
        return baseBibliografica;
    }










}
