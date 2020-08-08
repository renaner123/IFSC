package test;

import org.junit.Test;
import poo.Email;

import static org.junit.Assert.*;

public class EmailTest {

    Email e = new Email();

    @Test
    public void add() {
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("should not be null", new Object());
        assertEquals("Comercial e renanrodolfo@yahoo.com.br deve ser true",true,e.add("Comercial","renanrodolfo@yahoo.com.br"));
        assertEquals("Comercial e renanrodolfoyahoo.com.br deve ser false",false,e.add("Comercial","renanrodolfoyahoo.com.br"));
        assertEquals("Comercial e renanrodolfo@yahoo deve ser false",false,e.add("Comercial","renanrodolfo@yahoo"));
        assertEquals("Comercial e renanrodolfo@yahoo.com deve ser true",true,e.add("Comercial","renanrodolfo@yahoo.com"));
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