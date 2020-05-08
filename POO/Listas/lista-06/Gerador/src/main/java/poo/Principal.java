package poo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe usada para instanciar as classses implementadas para testar.
 */
public class Principal {



    public static void main(String[] args) {

        BibTex b = new BibTex();

        b.addMasterthesis("Teste1","renan Rodolfo","Apenas um teste",2020);
        b.addMisc("Gomugomu","NovoMisc");
        b.addTechreport("Ximblau","Renan rodolfo","Report to you",2020,"IFSC");
        b.addBook("lamport1994latex","Lamport, Leslie","Addison-wesley","LATEX: a document preparation system: user's guide and reference manual",1994);

        System.out.println("Listando base completa");
        b.listarBase();
        b.removeEntrada("Teste1");

        System.out.println("Listando base após remover entrada Teste1");
        b.listarBase();
        System.out.println("Listando uma entrada de uma base \n");
        b.listarEntrada("Ximblau");

        System.out.println("###########################");

        System.out.println("Criando outra base \n");
        BibTex bb = new BibTex();

        bb.addMasterthesis("Teste5","renan Rodolfo","Apenas um teste",2020);
        bb.addArticle("Amanha","Rodolfo","Futuro sem passado",1992,"Jornal passado");
        bb.addBook("Livro","Renan Silva","Nokasagi","Anime",2020);

        bb.listarBase();
        bb.removerBase();
        System.out.println("Base após ser removida");
        bb.listarBase();

    }
}
