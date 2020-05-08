package poo;

import java.util.HashMap;

/**
 * Classe responsável por adicionar Masterthesis
 * @author Renan Rodolfo da SIlva
 */
public class Masterthesis extends Entrada{
    /**
     *
     * @param id identifiação                   - obrigatório
     * @param author Nome do author             - obrigatório
     * @param title Título do book              - obrigatório
     * @param year Ano do masterthesis          - obirgatório
     * @param month Mês do masterthesis         - opcional
     * @param address Endereço do masterthesis  - opcional

     */
    private String address;


    public Masterthesis(){

    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     */
    public Masterthesis(String id, String author, String title, int year) {  //construtor padrão obrigatório
        super(id, author, title, year);

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("Tipo","masterthesis");

        baseBibliografica.put(id, publicacao);

    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     * @param month Mês do masterthesis

     */
    public Masterthesis(String id, String author, String title, int year,int month) {
        super(id, author,month, title, year);

        publicacao.put("month",Integer.toString(month));
        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("Tipo","masterthesis");

        baseBibliografica.put(id, publicacao);

    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     * @param address Endereço do masterthesis
     */
    public Masterthesis(String id, String author, String title, int year,String address) {
        this(id, author, title, year);
        this.address = address;
        publicacao.put("address",this.address);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     * @param month Mês do masterthesis
     * @param address Endereço do masterthesis
     */
    public Masterthesis(String id, String author, String title, int year, int month, String address) {
        this(id, author, title, year,month);
        this.address = address;
        publicacao.put("address",address);
    }

    /**
     *
     * @return entrada Masterthesis
     */
    public HashMap<String,String> getMaster(){
        return publicacao;
    }



}
