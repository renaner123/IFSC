package poo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;




public class Principal {

    public static void main(String[] args) {

        Icalendar i = new Icalendar("//Emerson Mello//Gerador de Plano de Ensino 1.0.0//PT_BR");
        UUID event1 = UUID.randomUUID();
        UUID event2 = UUID.randomUUID();
        UUID event3 = UUID.randomUUID();
        UUID event4 = UUID.randomUUID();

        /*Como pede para alterar e remover detalhes de um evento, a única forma que achei de fazer isso em
        um evento é sabendo sua UUID. Pois se fizer por sumário vai apagar todos os eventos e não só o evento em específico.
        Se buscar por PRODID, vai estar removendo/alterando vCalendar, e não um vEvent.
        */

        ArrayList<String> exdates = new ArrayList();
        exdates.add("2020-04-09T16:23:15.1");
        exdates.add("2020-04-09T16:0:15.3");

        i.addEvent("Apenas teste",event1,LocalDateTime.now().toString(),"2020-04-09T16:0:0.1","2020-05-09T16:00:00.01","Em casa");
        i.addEvent("Apenas outro",event2,LocalDateTime.now().toString(),"2020-08-09T16:0:0.0","2020-9-09T16:0:0.0","No laboratório","FREQ=WEEKLY;UNTIL=20200701T173000;BYDAY=FR",exdates);
        i.addEvent("Acordar",event3,LocalDateTime.now().toString(),"2020-10-09T16:0:0.0","2020-12-09T20:30:0.30","No quarto","FREQ=WEEKLY;UNTIL=20200701T173000;BYDAY=FR");


        i.getCalendar();
        System.out.println("\nApós remover evento\n");
        i.removeEvent(event3);
        i.getCalendar();
        i.addEvent("Não posso faltar",event4,LocalDateTime.now().toString(),"2020-01-01T16:30:0.0","2020-04-09T16:0:0.0","Espaço, galáxia 13");
        i.alterarRrule(event2,"FREQ=WEEKLY;UNTIL=20200701T173000;INTERVAL=5");
        i.alterarSumarry(event2,"Agora não");
        i.alterarDtstamp(event2,"20200902T104600");
        i.alterarDtstart(event2,"20201013T203000");
        i.alterarDtend(event2,"20220213T133000");
        i.alterarLocation(event2,"Em algum lugar");
        System.out.println("\nApós alterar  e adicionar um novo\n");
        i.getCalendar();



    }
}
