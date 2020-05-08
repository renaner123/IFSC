package poo;

import java.util.HashMap;

/**
 * Classe responsável por adicionar Techreport
 * @author Renan Rodolfo da silva
 */
public class Techreport extends Masterthesis  {
    /**
     *
     * @param id identifiação
     * @param author Nome do author           - obrigatório
     * @param institution Instituição         - obrigatório
     * @param year Ano do Techreport          - obrigatório
     * @param month Mês do Techreport         - opcional
     * @param address Endereço do Techreport  - opcional
     * @param title Título do Techreport      - obrigatório

     */
    private String institution;


    /**,
     *
     * @param id identifiação
     * @param author Nome do author
     * @param institution Instituição
     * @param year Ano do Techreport
     * @param title Título do Techreport
     */
    public Techreport(String id, String author, String title, int year, String institution) {
        super(id, author, title, year);
        this.institution = institution;

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("institution",this.institution);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("Tipo","techreport");

        baseBibliografica.put(id, publicacao);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param institution Instituição
     * @param year Ano do Techreport
     * @param address Endereço do Techreport
     * @param title Título do Techreport
     */
    public Techreport(String id, String author, String title, int year, String institution, String address) {
        super(id, author, title, year,address);
        this.institution = institution;

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("address",address);
        publicacao.put("institution",this.institution);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("Tipo","techreport");

        baseBibliografica.put(id, publicacao);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param institution Instituição
     * @param year Ano do Techreport
     * @param month Mês do Techreport
     * @param title Título do Techreport
     */
    public Techreport(String id, String author, String title, int year, String institution, int month) {
        super(id, author, title, year,month);
        this.institution = institution;

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("month",Integer.toString(month));
        publicacao.put("institution",this.institution);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("Tipo","techreport");

        baseBibliografica.put(id, publicacao);
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param institution Instituição
     * @param year Ano do Techreport
     * @param month Mês do Techreport
     * @param address Endereço do Techreport
     * @param title Título do Techreport
     */
    public Techreport(String id, String author, String title, int year, String institution, int month, String address) {
        super(id, author, title, year,month,address);
        this.institution = institution;

        publicacao.put("author",author);
        publicacao.put("title",title);
        publicacao.put("month",Integer.toString(month));
        publicacao.put("address",address);
        publicacao.put("institution",this.institution);
        publicacao.put("year",Integer.toString(year));
        publicacao.put("Tipo","techreport");

        baseBibliografica.put(id, publicacao);
    }

    /**
     *
     * @return entrada Techreport
     */
    public HashMap<String,String> getTech(){
        return publicacao;
    }



}
