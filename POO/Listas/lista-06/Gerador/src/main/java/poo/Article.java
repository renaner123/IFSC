package poo;

import java.util.HashMap;
/**
 * Classe responsável por adicionar uma Entrada do tipo Article
 *
 * @author Renan Rodolfo da Silva
 */
public class Article extends Entrada {

    /**
     * @param id identificador         - obrigatório
     * @param author Nome do autor     - obrigatório
     * @param title Título             - obrigatório
     * @param year Ano de publicação   - obrigatório
     * @param journal Nome do jornal   - obrigatório
     * @param month Mes de publicação  - Opcional
     * @param number número da edição  - opcional
     * @param pages número de páginas  - opcional
     * @param volume Volume            - opcional
     */
    private String journal;
    private int number;
    private int pages;
    private int volume;
    private HashMap<String,String> auxArticle = new HashMap<String,String>(); //para conseguir usar Construtor dentro de um construtor

    /**
     *
     * @param id     Identificação única da publicação
     * @param author Autor da publicação
     * @param title  Título da publicação
     * @param year   Ano da publicação
     * @param journal Nome do jornal
     */
    public Article( String id, String author,String title, int year, String journal) {
        // Construtor base sem uso de Month
        super(id, author, title, year);
        this.journal = journal;

        auxArticle.put("author",author);
        auxArticle.put("title",title);
        auxArticle.put("year",Integer.toString(year));
        auxArticle.put("journal",this.journal);
        auxArticle.put("Tipo","article");

        baseBibliografica.put(id,auxArticle);
    }

    /**
     *
     * @param id Identificação única da publicação
     * @param author Autor da publicação
     * @param title Título da publicação
     * @param year Ano da publicação
     * @param journal Nome do jornal
     * @param month Mês da publicação
     */
    public Article( String id, String author,String title, int year, String journal,int month) {
        // Construtor base com uso de Month
        super(id, author,month, title, year);

        this.journal = journal;
        auxArticle.put("author",author);
        auxArticle.put("title",title);
        auxArticle.put("year",Integer.toString(year));
        auxArticle.put("journal",this.journal);
        auxArticle.put("month",Integer.toString(month));
        auxArticle.put("Tipo","article");

        baseBibliografica.put(id,auxArticle);
    }

    /**
     *
     * @param id Identificação única da publicação
     * @param author Autor da publicação
     * @param title Título da publicação
     * @param year Ano da publicação
     * @param journal Nome do jornal
     * @param month Mês da publicação
     * @param number Número da publicação
     */
    public Article( String id, String author,String title, int year, String journal,int month,int number) {
        this(id,author,title,year,journal,month);
        this.number = number;
        auxArticle.put("number",Integer.toString(number));
    }

    /**
     *
     * @param id Identificação única da publicação
     * @param author Autor da publicação
     * @param title Título da publicação
     * @param year Ano da publicação
     * @param journal Nome do jornal
     * @param month Mês da publicação
     * @param number Número da publicação
     * @param pages Número de páginas da publicação
     */
    public Article( String id, String author,String title, int year, String journal,int month,int number, int pages) {
        this(id,author,title,year,journal,month,number);
        this.pages=pages;
        auxArticle.put("pages",Integer.toString(pages));
    }
    /**
     * @param id identificador
     * @param author Nome do autor
     * @param title Título
     * @param year Ano de publicação
     * @param journal Nome do jornal
     * @param month Mes de publicação
     * @param number número da edição
     * @param pages número de páginas
     * @param volume Volume
     */
    public Article( String id, String author,String title, int year, String journal,int month,int number, int pages,int volume) {
        this(id,author,title,year,journal,month,number,pages);
        this.volume=volume;
        auxArticle.put("volume",Integer.toString(volume));
    }

    /**
     *
     * @return Tabela que contém a entrada do Article
     */
    public HashMap<String,String> getArticle(){
        return auxArticle;
    }




}
