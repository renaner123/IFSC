package poo;

import java.util.HashMap;
/**
 * Classe responsável por adicionar uma Entrada do tipo Book
 * @author Renan Rodolfo da Silva
 */

public class Book extends Entrada{

    /**
     *
     * @param id identifiação          - obrigatório
     * @param author Nome do author    - obrigatório
     * @param publisher Nome do book   - obrigatório
     * @param title Título do book     - obrigatório
     * @param year Ano do book         - obrigatório
     * @param month Mês do book        - opcional
     * @param address Endereço do book - opcional
     * @param edition Edição da book   - opcional
     * @param editor Editor do book    - opcional
     * @param number Nùmero do book    - opcional
     * @param series Série do book     - opcional
     * @param volume Volume do book    - opcional
     */

    private String address;
    private String edition;
    private String editor;
    private int number;
    private String publisher;
    private int series;
    private int volume;


    /**
     *
     * @param id   Identificador
     * @param author Autor
     * @param publisher Publicação
     * @param title Título
     * @param year Ano de publicação
     */
    public Book(String id,String author,String publisher,String title,int year){
        super(id, author, title, year);  //Construtor padrão sem Month, obrigatório
        this.publisher = publisher;

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("publisher",this.publisher);
        publicacao.put("Tipo","book");

        baseBibliografica.put(id, publicacao);

    }

    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     */
    public Book(String id,String author,String publisher,String title,int year, int month){
        super(id, author,month, title, year);  //Construtor padrão com Month
        this.publisher = publisher;

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("publisher",this.publisher);
        publicacao.put("month",Integer.toString(month));
        publicacao.put("Tipo","book");

        baseBibliografica.put(id, publicacao);

    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     * @param address Endereço do book
     */
    public Book(String id,String author,String publisher,String title,int year, int month,String address){
        this(id,author,publisher,title,year,month);
        this.address = address;
        publicacao.put("address",this.address);
    }

    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     * @param address Endereço do book
     * @param edition Edição da book
     */
    public Book(String id,String author,String publisher,String title,int year, int month,String address,String edition){
        this(id,author,publisher,title,year,month,address);
        this.edition = edition;
        publicacao.put("edition",this.edition);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     * @param address Endereço do book
     * @param edition Edição da book
     * @param editor Editor do book
     */
    public Book(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor){
        this(id,author,publisher,title,year,month,address,edition);
        this.editor = editor;
        publicacao.put("editor",this.editor);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     * @param address Endereço do book
     * @param edition Edição da book
     * @param editor Editor do book
     * @param number Nùmero do book
     */
    public Book(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor,int number){
        this(id,author,publisher,title,year,month,address,edition,editor);
        this.number = number;
        publicacao.put("number",Integer.toString(this.number));
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     * @param address Endereço do book
     * @param edition Edição da book
     * @param editor Editor do book
     * @param number Nùmero do book
     * @param series Série do book
     */
    public Book(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor,int number, int series){
        this(id,author,publisher,title,year,month,address,edition,editor,number);
        this.series = series;
        publicacao.put("series",Integer.toString(this.series));
    }

    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     * @param month Mês do book
     * @param address Endereço do book
     * @param edition Edição da book
     * @param editor Editor do book
     * @param number Nùmero do book
     * @param series Série do book
     * @param volume Volume do book
     */
    public Book(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor,int number, int series, int volume){
        this(id,author,publisher,title,year,month,address,edition,editor,number,series);
        this.volume = volume;
        publicacao.put("volume",Integer.toString(this.volume));
    }

    /**
     *
     * @return Entrada de book
     */
    public HashMap<String,String> getBook(){
        return publicacao;
    }



}
