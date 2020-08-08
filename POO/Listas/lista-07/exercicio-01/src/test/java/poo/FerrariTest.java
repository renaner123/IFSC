package poo;

import org.junit.Test;

import static org.junit.Assert.*;

public class FerrariTest {
//

    @Test
    public void abrirCapota() {

        Ferrari f1 = new Ferrari("Tunado");
        assertTrue("failure - should be true", f1.abrirCapota());
        f1.acelerar(50);
        assertFalse("failure - should be false", f1.abrirCapota());
    }

    @Test
    public void fecharCapota() {
        Ferrari f1 = new Ferrari("Tunado");
        if(f1.getVelocidade()<=20) {
            if (f1.isCapota() == true) {
                assertTrue("failure - should be true", f1.fecharCapota());
            } else {
                assertFalse("failure - should be false", f1.fecharCapota());
            }
        }
    }

    @Test
    public void ligarFarolNeblina() {
        Ferrari f1 = new Ferrari("Tunado");
        assertTrue("failure - should be true", f1.ligarFarolNeblina());
    }
}