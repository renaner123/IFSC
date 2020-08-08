package poo;

import org.junit.Test;

import static org.junit.Assert.*;

public class PantherTest {
//
    @Test
    public void abrirCapota() {
        Panther ph1 = new Panther("Tubarao");
        if(ph1.getVelocidade()==0){
            assertTrue("failure - should be true", ph1.abrirCapota());
        }else{
            assertFalse("failure - should be false", ph1.abrirCapota());
        }
    }

    @Test
    public void fecharCapota() {
        Panther ph1 = new Panther("Tubarao");
        if(ph1.getVelocidade()==0){
            assertTrue("failure - should be true", ph1.fecharCapota());
        }else{
            assertFalse("failure - should be false", ph1.fecharCapota());
        }
    }

    @Test
    public void ativarDesativarTracao() {
        Panther ph1 = new Panther("Tubarao");
        if(ph1.isRodas()==true){
            assertTrue("failure - should be true", ph1.ativarDesativarTracao());
        }else{
            assertFalse("failure - should be false", ph1.ativarDesativarTracao());
        }

    }

    @Test
    public void recolherRodas() {
        Panther ph1 = new Panther("Tubarao");
        assertFalse("failure - should be false", ph1.recolherRodas());
        ph1.recolherRodas();
        assertTrue("failure - should be true", ph1.recolherRodas());

    }

    @Test
    public void abrirRodas() {
        Panther ph1 = new Panther("Tubarao");
        assertTrue("failure - should be true", ph1.abrirRodas());
    }



}