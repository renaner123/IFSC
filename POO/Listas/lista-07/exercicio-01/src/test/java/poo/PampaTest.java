package poo;

import org.junit.Test;

import static org.junit.Assert.*;

public class PampaTest {
//
    @Test
    public void ativarDesativarTracao() {
        Pampa p1 = new Pampa("Fedida");
        assertTrue("failure - should be true", p1.ativarDesativarTracao());
        p1.acelerar(30);
        assertFalse("failure - should be false", p1.ativarDesativarTracao());
    }

    @Test
    public void abrirCacamba() {
        Pampa p1 = new Pampa("Fedida");
        assertTrue("failure - should be true", p1.abrirCacamba());
        p1.acelerar(30);
        assertFalse("failure - should be false", p1.abrirCacamba());

    }

    @Test
    public void fecharCacamba() {
        Pampa p1 = new Pampa("Fedida");
        assertTrue("failure - should be true", p1.abrirCacamba());
        p1.acelerar(30);
        assertFalse("failure - should be false", p1.abrirCacamba());
    }
}