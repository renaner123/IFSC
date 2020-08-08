package test;

import org.junit.Test;
import poo.Pessoa;
import test.EmailTest;
import test.TelefoneTest;

import static org.junit.Assert.*;

public class PessoaTest {
    Pessoa e = new Pessoa();

    @Test
    public void addTelefone() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial e 48996478132 deve ser true",true,e.addTelefone("Comercial","48996478132"));

    }

    @Test
    public void addEmail() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial e renanrodolfo@yahoo.com.br deve ser true",true,e.addEmail("Comercial","renanrodolfo@yahoo.com.br"));
        assertEquals("Comercial e renanrodolfoyahoo.com.br deve ser false",false,e.addEmail("Comercial","renanrodolfoyahoo.com.br"));
        assertEquals("Comercial e renanrodolfo@yahoo deve ser false",false,e.addEmail("Comercial","renanrodolfo@yahoo"));
        assertEquals("Comercial e renanrodolfo@yahoo.com deve ser true",true,e.addEmail("Comercial","renanrodolfo@yahoo.com"));
    }

    @Test
    public void removeTelefone() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial deve ser true",true,e.removeTelefone("Comercial"));
    }

    @Test
    public void removeEmail() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial deve ser true",true,e.removeEmail("Comercial"));
    }

    @Test
    public void updateTelefone() {
        this.addTelefone();
    }

    @Test
    public void updateEmail() {
        this.addEmail();
    }
}