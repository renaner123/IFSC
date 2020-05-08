package poo;

import java.util.HashMap;

/**
 * Classe responsável por gerenciar entradas e bases bibliográficas
 * @author Renan Rodolfo da silva
 */
public class BibTex {

    private Entrada entrada = new Entrada();
    private Article article;
    private Book book;
    private Masterthesis masterthesis;
    private Misc misc;
    private Techreport techreport;
    private String nomeBase;
    private HashMap<String,HashMap<String,String>> bibTex = new HashMap<String,HashMap<String,String>>();



    public BibTex(){
        this.entrada.getBaseBibliografica().clear();
    }

    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     */
    public void addMasterthesis(String id, String author, String title, int year) {  //construtor padrão obrigatório
        masterthesis = new Masterthesis(id,author,title,year);
        bibTex.put(id,masterthesis.getMaster());
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     * @param month Mês do masterthesis
     */
    public void addMasterthesis(String id, String author, String title, int year,int month) {
        masterthesis = new Masterthesis(id,author,title,year,month);
        bibTex.put(id,masterthesis.getMaster());
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do masterthesis
     * @param year Ano do masterthesis
     * @param address Endereço do masterthesis
     */
    public void addMasterthesis(String id, String author, String title, int year,String address) {
        masterthesis = new Masterthesis(id,author,title,year,address);
        bibTex.put(id,masterthesis.getMaster());
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
    public void addMasterthesis(String id, String author, String title, int year, int month, String address) {
        masterthesis = new Masterthesis(id,author,title,year,month,address);
        bibTex.put(id,masterthesis.getMaster());
    }


    /**
     *
     * @param id identifiação
     * @param title Título do misc
     */
    public void addMisc(String id, String title) {
        misc = new Misc(id,title);
        bibTex.put(id,misc.getMisc());
    }
    /**
     *
     * @param id identifiação
     * @param title Título do misc
     * @param address Endereço do misc
     */
    public void addMisc(String id, String title, String address) {
        misc = new Misc(id,title,address);
        bibTex.put(id,misc.getMisc());
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do misc
     * @param address Endereço do misc
     */
    public void addMisc(String id, String title, String address, String author) {
        misc = new Misc(id,title,address,author);
        bibTex.put(id,misc.getMisc());
    }
    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param title Título do misc
     * @param month Mês do misc
     * @param address Endereço do misc
     */
    public void addMisc(String id, String title, String address, String author,int month) {
        misc = new Misc(id,title,address,author,month);
        bibTex.put(id,misc.getMisc());
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
    public void addMisc(String id, String title, String address, String author,int month,int year) {
        misc = new Misc(id,title,address,author,month,year);
        bibTex.put(id,misc.getMisc());
    }
    /**
     *
     * @param id identifiação
     * @param title Título do misc
     * @param year Ano do misc
     */
    public void addMisc(String id, String title, int year) {
        misc = new Misc(id,title,year);
        bibTex.put(id,misc.getMisc());
    }


    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param institution Instituição
     * @param year Ano do Techreport
     * @param title Título do Techreport
     */
    public void addTechreport(String id, String author, String title, int year, String institution) {
        techreport = new Techreport(id,author,title,year,institution);
        bibTex.put(id,techreport.getTech());
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
    public void addTechreport(String id, String author, String title, int year, String institution, String address) {
        techreport = new Techreport(id,author,title,year,institution,address);
        bibTex.put(id,techreport.getTech());
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
    public void addTechreport(String id, String author, String title, int year, String institution, int month) {
        techreport = new Techreport(id,author,title,year,institution,month);
        bibTex.put(id,techreport.getTech());
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
    public void addTechreport(String id, String author, String title, int year, String institution, int month, String address) {
        techreport = new Techreport(id,author,title,year,institution,month,address);
        bibTex.put(id,techreport.getTech());
    }


    /**
     * @param id identificador
     * @param author Nome do autor
     * @param title Título
     * @param year Ano de publicação
     * @param journal Nome do jornal

     */
    public void addArticle( String id, String author,String title, int year, String journal) {
        article = new Article(id,author,title,year,journal);
        bibTex.put(id,article.getArticle());
    }
    /**
     * @param id identificador
     * @param author Nome do autor
     * @param title Título
     * @param year Ano de publicação
     * @param journal Nome do jornal
     * @param month Mes de publicação
     */
    public void addArticle( String id, String author,String title, int year, String journal,int month) {
        article = new Article(id,author,title,year,journal,month);
        bibTex.put(id,article.getArticle());
    }
    /**
     * @param id identificador
     * @param author Nome do autor
     * @param title Título
     * @param year Ano de publicação
     * @param journal Nome do jornal
     * @param month Mes de publicação
     * @param number número da edição
     */
    public void addArticle( String id, String author,String title, int year, String journal,int month,int number) {
        article = new Article(id,author,title,year,journal,month,number);
        bibTex.put(id,article.getArticle());
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
     */
    public void addArticle( String id, String author,String title, int year, String journal,int month,int number, int pages) {
        article = new Article(id,author,title,year,journal,month,number,pages);
        bibTex.put(id,article.getArticle());
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
    public void addArticle( String id, String author,String title, int year, String journal,int month,int number, int pages,int volume) {
        article = new Article(id,author,title,year,journal,month,number,pages,volume);
        bibTex.put(id,article.getArticle());
    }


    /**
     *
     * @param id identifiação
     * @param author Nome do author
     * @param publisher Nome do book
     * @param title Título do book
     * @param year Ano do book
     */

    public void addBook(String id,String author,String publisher,String title,int year){
        book = new Book(id,author,publisher,title,year);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month){
        book = new Book(id,author,publisher,title,year,month);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month,String address){
        book = new Book(id,author,publisher,title,year,month,address);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month,String address,String edition){
        book = new Book(id,author,publisher,title,year,month,address,edition);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor){
        book = new Book(id,author,publisher,title,year,month,address,edition,editor);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor,int number){
        book = new Book(id,author,publisher,title,year,month,address,edition,editor,number);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor,int number, int series){
        book = new Book(id,author,publisher,title,year,month,address,edition,editor,number,series);
        bibTex.put(id,book.getBook());
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
    public void addBook(String id,String author,String publisher,String title,int year, int month,String address,String edition,String editor,int number, int series, int volume){
        book = new Book(id,author,publisher,title,year,month,address,edition,editor,number,series,volume);
        bibTex.put(id,book.getBook());
    }

    /**
     *
     * @return bases bibliográfica
     */
    public HashMap<String, HashMap<String, String>> imprimirBases(){
       return this.bibTex;
    }

    /**
     *
     * @return false caso não existe a entrada ou true se existir
     */
    public boolean removerBase(){
        try {
            this.bibTex.clear();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     *
     * @param id identificação a ser removida
     * @return false caso não existe a entrada ou true se existir
     */
    public boolean removeEntrada(String id){
        if(bibTex.containsKey(id)){
            bibTex.remove(id);
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @return false caso não existe a entrada ou true se existir
     */
    public boolean listarBase(){
        if(bibTex.isEmpty()){
            return false;
        }else {
            bibTex.forEach((chave, valor) -> {
                System.out.println("@" + valor.get("Tipo") + "{" + chave + ",");
                valor.forEach((chave1, valor1) -> {
                    if (chave1 != "Tipo") {
                        System.out.println("    " + chave1 + "={" + valor1 + "},");
                    }
                });
                System.out.println("}");
            });
            return true;
        }
    }

    /**
     *
     * @param id recebe identificação a ser listada
     * @return false caso não existe a entrada ou true se existir
     */
    public boolean listarEntrada(String id){
        if(bibTex.containsKey(id)) {
            bibTex.forEach((chave, valor) -> {
                if (chave.equals(id)) {
                    System.out.println("@" + valor.get("Tipo") + "{" + chave + ",");
                    valor.forEach((chave1, valor1) -> {
                        if (chave1 != "Tipo") {
                            System.out.println("    " + chave1 + "={" + valor1 + "},");
                        }
                    });
                    System.out.println("}");
                }
            });
            return true;
        }else{
            return false;
        }
    }






}
/*
@book{lamport1994latex,
    title={LATEX: a document preparation system: user's guide and reference manual},
    author={Lamport, Leslie},
    year={1994},5publisher={Addison-wesley}
    }



 */