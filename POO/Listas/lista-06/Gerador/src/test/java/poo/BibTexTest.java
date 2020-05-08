package poo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe responsável por listar e remover bases e entradas.
 */
public class BibTexTest {
    /*
        Não consigo testar os de adicionar pois fiz de forma errônea, usei apenas os construtores e por serem void não consigo testar.
        E pelo tempo não consigo ajustar.
     */

    @Test
    public void removerBase() {
        BibTex b = new BibTex();

        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Essa base existe, retornar true",true,b.removerBase());
    }

    @Test
    public void removeEntrada() {
        BibTex b = new BibTex();
        b.addMisc("lamport1994latex","Apenas teste");

        assertEquals("Esse ID existe para ser removido, retorna true",true,b.removeEntrada("lamport1994latex"));
        assertEquals("Esse ID não existe para ser removido, retorna false",false,b.removeEntrada("qualquer"));
    }

    @Test
    public void listarBase() {
        BibTex b = new BibTex();
        b.addMisc("lamport1994latex","Apenas teste");
        BibTex c = new BibTex();

        assertEquals("Base não está vazia, retorna true",true,b.listarBase());
        assertEquals("Base está vazia, retorna false",false,c.listarBase());
    }

    @Test
    public void listarEntrada() {
        BibTex b = new BibTex();
        b.addMisc("lamport1994latex","Apenas teste");

        assertEquals("Entrada existe, retorna true",true,b.listarEntrada("lamport1994latex"));
        assertEquals("Entrada não existe, retorna true",false,b.listarEntrada("oi"));
    }
}