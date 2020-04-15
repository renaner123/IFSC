package poo;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Vevent {

    private String sumarry;
    private UUID uid;
    private String dtstamp;
    private String dtstart;
    private String dtend;
    private String location;
    //opcionais
    private String rrule;
    private ArrayList<String> exdate = new ArrayList();
    private ArrayList<String> eventos = new ArrayList();
    private static HashMap<String, ArrayList<String>> eventos_uid = new HashMap<String, ArrayList<String>>();



    public Vevent(String sumarry, UUID uid, String dtstamp, String dtstart, String dtend, String location) {
        this.sumarry = sumarry;
        this.uid = uid;
        this.dtstamp = dtstamp;
        this.dtstart = dtstart;
        this.dtend = dtend;
        this.location = location;

        this.eventos.add("BEGIN:VEVENT");
        this.eventos.add("SUMMARY:" + this.sumarry);
        this.eventos.add("UID:" + String.valueOf(this.uid));
        this.eventos.add("DTSTAMP:" + this.dtstamp);
        this.eventos.add("DTSTART:" + this.dtstart);
        this.eventos.add("DTEND:" + this.dtend);
        this.eventos.add("LOCATION:" + this.location);
        this.eventos.add("END:VEVENT");
        eventos_uid.put(String.valueOf(this.uid),eventos);
    }

    public Vevent(String sumarry, UUID uid, String dtstamp, String dtstart, String dtend, String location, String rrule) {
        this.sumarry = sumarry;
        this.uid = uid;
        this.dtstamp = dtstamp;
        this.dtstart = dtstart;
        this.dtend = dtend;
        this.location = location;
        this.rrule = rrule;

        this.eventos.add("BEGIN:VEVENT");
        this.eventos.add("SUMMARY:" + this.sumarry);
        this.eventos.add("UID:" + String.valueOf(this.uid));
        this.eventos.add("DTSTAMP:" + this.dtstamp);
        this.eventos.add("DTSTART:" + this.dtstart);
        this.eventos.add("DTEND:" + this.dtend);
        this.eventos.add("LOCATION:" + this.location);
        this.eventos.add("RRULE:" + rrule);
        this.eventos.add("END:VEVENT");
        eventos_uid.put(String.valueOf(this.uid),eventos);

    }

    public Vevent(String sumarry, UUID uid, String dtstamp, String dtstart, String dtend, String location, String rrule, ArrayList<String> exdate) {
        this.sumarry = sumarry;
        this.uid = uid;
        this.dtstamp = dtstamp;
        this.dtstart = dtstart;
        this.dtend = dtend;
        this.location = location;
        this.rrule = rrule;
        this.exdate = exdate;

        this.eventos.add("BEGIN:VEVENT");
        this.eventos.add("SUMMARY:" + this.sumarry);
        this.eventos.add("UID:" + String.valueOf(this.uid));
        this.eventos.add("DTSTAMP:" + this.dtstamp);
        this.eventos.add("DTSTART:" + this.dtstart);
        this.eventos.add("DTEND:" + this.dtend);
        this.eventos.add("LOCATION:" + this.location);
        this.eventos.add("RRULE:" + rrule);
        for (String a : exdate) {
            eventos.add("EXDATE:" + a);
        }
        eventos.add("END:VEVENT");
        eventos_uid.put(String.valueOf(this.uid),eventos);
    }

    public Vevent() {

    }

    public String getSumarry() {
        return sumarry;
    }


    public boolean alterarSumarry(UUID u, String summary) {
        ArrayList<String> aux = new ArrayList<>();
        int pos=0;
        if(eventos_uid.containsKey(String.valueOf(u))){
            aux = eventos_uid.get(String.valueOf(u));
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).startsWith("SUMMARY")){
                    pos =i;
                }
            }
            aux.set(pos,"SUMMARY:"+summary);
            eventos_uid.put(String.valueOf(u),aux);
            return true;
        }else{
            return false;
        }
    }

    public UUID getUid() {
        return uid;
    }


    public String getDtstamp() {
        return dtstamp;
    }

    public boolean alterarDtstamp(UUID u, String stamp) {
        ArrayList<String> aux = new ArrayList<>();
        int pos=0;
        if(eventos_uid.containsKey(String.valueOf(u))){
            aux = eventos_uid.get(String.valueOf(u));
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).startsWith("DTSTAMP")){
                    pos =i;
                }
            }
            aux.set(pos,"DTSTAMP:"+stamp);
            eventos_uid.put(String.valueOf(u),aux);
            return true;
        }else{
            return false;
        }
    }

    public String getDtstart() {
        return dtstart;
    }

    public boolean alterarDtstart(UUID u, String start) {
        ArrayList<String> aux = new ArrayList<>();
        int pos=0;
        if(eventos_uid.containsKey(String.valueOf(u))){
            aux = eventos_uid.get(String.valueOf(u));
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).startsWith("DTSTART")){
                    pos =i;
                }
            }
            aux.set(pos,"DTSTART:"+start);
            eventos_uid.put(String.valueOf(u),aux);
            return true;
        }else{
            return false;
        }
    }

    public String getDtend() {
        return dtend;
    }

    public boolean alterarDtend(UUID u, String end) {
        ArrayList<String> aux = new ArrayList<>();
        int pos=0;
        if(eventos_uid.containsKey(String.valueOf(u))){
            aux = eventos_uid.get(String.valueOf(u));
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).startsWith("DTEND")){
                    pos =i;
                }
            }
            aux.set(pos,"DTEND:"+end);
            eventos_uid.put(String.valueOf(u),aux);
            return true;
        }else{
            return false;
        }
    }

    public String getLocation() {
        return location;
    }

    public boolean alterarLocation(UUID u, String location) {
        ArrayList<String> aux = new ArrayList<>();
        int pos=0;
        if(eventos_uid.containsKey(String.valueOf(u))){
            aux = eventos_uid.get(String.valueOf(u));
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).startsWith("LOCATION")){
                    pos =i;
                }
            }
            aux.set(pos,"LOCATION:"+location);
            eventos_uid.put(String.valueOf(u),aux);
            return true;
        }else{
            return false;
        }
    }

    public String getRrule() {
        return rrule;
    }

    public boolean alterarRrule(UUID u, String rrule) {
        ArrayList<String> aux = new ArrayList<>();
        int pos=0;
        if(eventos_uid.containsKey(String.valueOf(u))){
            aux = eventos_uid.get(String.valueOf(u));
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).startsWith("RRULE")){
                    pos =i;
                }
            }
            if(pos!=-1) {
                aux.set(pos, "RRULE:" + rrule);
                eventos_uid.put(String.valueOf(u), aux);
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    public ArrayList<String> getExdate() {
        return exdate;
    }

    public ArrayList<String> getEventos() {
        return this.eventos;
    }

    public  HashMap<String, ArrayList<String>> getHashuid(){
        return eventos_uid;
    }

    public boolean removeEvent(UUID uid) {

        try{
            for(Object key:  new HashSet<>(eventos_uid.keySet()) ){
                if(key.equals(String.valueOf(uid))) {
                    Object value = eventos_uid.remove(key);
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}