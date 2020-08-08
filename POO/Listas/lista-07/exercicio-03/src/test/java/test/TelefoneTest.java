package test;

import org.junit.Test;
import poo.Telefone;

import static org.junit.Assert.*;

public class TelefoneTest {

    Telefone e = new Telefone();

    @Test
    public void add() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial e 48996478132 deve ser true",true,e.add("Comercial","48996478132"));

    }

    @Test
    public void remove() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial deve ser true",true,e.remove("Comercial"));
    }

    @Test
    public void update() {
        this.add();
    }
}