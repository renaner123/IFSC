package poo;

import java.util.HashMap;

/**
 * Classe responsável por adicionar Misc
 * @author Renan Rodolfo da SIlva
 */
public class Misc extends Entrada  {
    /**
     *
     * @param id identifiação          - obrigatório
     * @param author Nome do author    - opcional
     * @param title Título do misc     - obrigatório
     * @param year Ano do misc         - opcional
     * @param month Mês do misc        - opcional
     * @param address Endereço do misc - opcional

     */
    private String address; // Não conseguir herdar de Masterthesis por não ter um construtor com somente title

    /**
     * Construtor obrigatório padrão
     * @param id identificação da entrada
     * @param title Título - Obrigatório
     */
    public Misc(String id, String title) {
        super(id,title);
        publicacao.put("title",title);
        publicacao.put("Tipo","misc");
        baseBibliografica.put(id, publicacao);

    }
    /**
     *
     * @param id identifiação
     * @param title Título do misc
     * @param address Endereço do misc
     */
    public Misc(String id, String title, String address) {
        this(id,title);
        this.address = address;
        publicacao.put("address",this.address);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do misc
     * @param address Endereço do misc
     */
    public Misc(String id, String title, String address, String author) {
        this(id,title,address);
        publicacao.put("author",author);
    }

    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do misc
     * @param month Mês do misc
     * @param address Endereço do misc
     */
    public Misc(String id, String title, String address, String author,int month) {
        this(id,title,address,author);
        publicacao.put("month",Integer.toString(month));
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do misc
     * @param year Ano do misc
     * @param month Mês do misc
     * @param address Endereço do misc
     */
    public Misc(String id, String title, String address, String author,int month,int year) {
        this(id,title,address,author,month);
        publicacao.put("year",Integer.toString(year));
    }
    /**
     *
     * @param id identifiação
     * @param title Título do misc
     * @param year Ano do misc
     */
    public Misc(String id, String title, int year) {
        this(id,title);
        publicacao.put("year",Integer.toString(year));
    }

    /**
     *
     * @return entrada Misc
     */
    public HashMap<String,String> getMisc(){
        return publicacao;
    }





}
