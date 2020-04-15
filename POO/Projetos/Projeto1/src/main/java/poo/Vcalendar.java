package poo;

import java.util.*;
import java.time.LocalDate;


public class Vcalendar {

    public final  double VERSION = 2.0;
    private String proID = "PRODID";
    public final static String PRODIDFPADRAO = "Renan Rodolfo//Gerador de calendários iCalendar//PT_BR";
    private HashMap<String, ArrayList<String>> vCalendar = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> eventos = new ArrayList();


    public Vcalendar(String proID) {
        this.proID = proID;
        vCalendar.put(this.proID,eventos);
    }
    public Vcalendar(){
        this.proID = PRODIDFPADRAO;
        vCalendar.put(this.proID,eventos);
    }

    public String getProID(){
        return this.proID;
    }
    public HashMap<String, ArrayList<String>> getvCalendar() {
        return vCalendar;
    }

    public double getVersion() {
        return VERSION;
    }
}
