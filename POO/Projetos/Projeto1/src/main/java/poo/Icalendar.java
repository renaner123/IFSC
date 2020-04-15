package poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Icalendar {

    private Vcalendar vcalendar;
    private Vevent vevent;
    private HashMap<String, ArrayList<String>  > calendar = new HashMap<String, ArrayList<String>>();



    public Icalendar(String proID){
        this.vcalendar = new Vcalendar(proID);
    }
    public Icalendar(){
        this.vcalendar = new Vcalendar();
    }

    public boolean addEvent(String sumarry, UUID uid, String dtstamp, String dtstart, String dtend, String location) {
        calendar = this.vcalendar.getvCalendar();
        if((this.validaData(this.converteData(dtstamp)) && this.validaData(this.converteData(dtstart)) && this.validaData(this.converteData(dtend))) == true) {
            for (Map.Entry<String, ArrayList<String>> elemento : this.calendar.entrySet()) {
                if (elemento.getKey().equals(this.getProid())) {
                    vevent = new Vevent(sumarry, uid, this.converteData(dtstamp), this.converteData(dtstart), this.converteData(dtend), location);
                    elemento.setValue(this.vevent.getEventos());
                }
            }

            return true;
        }else{
            return false;
        }
    }
    public boolean addEvent(String sumarry, UUID uid, String dtstamp, String dtstart, String dtend, String location, String rrule) {
        calendar = this.vcalendar.getvCalendar();

        if((this.validaData(this.converteData(dtstamp)) && this.validaData(this.converteData(dtstart)) && this.validaData(this.converteData(dtend)))&&this.validaRrule(rrule) == true) {
            for (Map.Entry<String, ArrayList<String>> elemento : this.calendar.entrySet()) {
                if (elemento.getKey().equals(this.getProid())) {
                    vevent = new Vevent(sumarry, uid, this.converteData(dtstamp), this.converteData(dtstart), this.converteData(dtend), location, rrule);
                    elemento.setValue(this.vevent.getEventos());
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean addEvent(String sumarry, UUID uid, String dtstamp, String dtstart, String dtend, String location, String rrule, ArrayList<String> exdate) {
        calendar = this.vcalendar.getvCalendar();
        if((this.validaData(this.converteData(dtstamp)) && this.validaData(this.converteData(dtstart)) && this.validaData(this.converteData(dtend)))&&this.validaRrule(rrule) == true) {
            for (Map.Entry<String, ArrayList<String>> elemento : this.calendar.entrySet()) {
                if (elemento.getKey().equals(this.getProid())) {
                    vevent = new Vevent(sumarry, uid, this.converteData(dtstamp), this.converteData(dtstart), this.converteData(dtend), location, rrule, this.converteExdate(exdate));
                    elemento.setValue(this.vevent.getEventos());
                }
            }
        return true;
        }else{
            return false;
        }
    }

    public String getProid(){
        return this.vcalendar.getProID();
    }

    public String getSumarry() {
        return vevent.getSumarry();
    }

    public boolean alterarSumarry(UUID u, String summary) {
        return this.vevent.alterarSumarry(u,summary);
    }

    public UUID getUid() {
        return this.vevent.getUid();
    }

    public String getDtstamp() {
        return this.vevent.getDtstamp();
    }

    public boolean alterarDtstamp(UUID u, String stamp) {
        if(this.validaData(stamp)==true) {
            return this.vevent.alterarDtstamp(u, stamp);
        }else{
            return false;
        }
    }

    public String getDtstart() {
        return this.vevent.getDtstart();
    }

    public boolean alterarDtstart(UUID u, String start) {
        if(this.validaData(start)==true) {
            return this.vevent.alterarDtstart(u, start);
        }else{
            return false;
        }
    }

    public String getDtend() {
        return this.vevent.getDtend();
    }

    public boolean alterarDtend(UUID u, String end) {
        if(this.validaData(end)==true) {
            return this.vevent.alterarDtend(u, end);
        }else{
            return false;
        }
    }

    public String getLocation() {
        return this.vevent.getLocation();
    }

    public boolean alterarLocation(UUID u, String location) {
        return this.vevent.alterarLocation(u,location);
    }

    public String getRrule() {
        return this.vevent.getRrule();
    }

    public boolean alterarRrule(UUID u, String rrule) {
        if(this.validaRrule(rrule)==true) {
            return this.vevent.alterarRrule(u, rrule);
        }else{
            return false;
        }

    }

    public double getVersion(){
        return this.vcalendar.getVersion();
    }

    public void getCalendar(){
        try {
            if (this.vevent.getHashuid().size() >= 1) {
                System.out.println("BEGIN:VCALENDAR");
                System.out.println("VERSION:" + this.getVersion());
                System.out.println("PRODID:" + this.vcalendar.getProID());
                for (Map.Entry<String, ArrayList<String>> elemento : this.vevent.getHashuid().entrySet()) {
                    for (String exit : elemento.getValue()) {
                        System.out.println(exit);
                    }
                }
                System.out.println("END:VCALENDAR");
            } else {
                System.out.println("Calendar vazio");
            }
        }catch(Exception e){
            System.out.println("Ainda não existe Vcalendar");
        }
    }

    public boolean validaData(String date){
        try{
            String year = (date.substring(0,4));
            String month= (date.substring(4,6));
            String dayOfMonth = date.substring(6,8);
            String hour = date.substring(9,11);
            String minute= date.substring(11,13);
            String second = date.substring(13,15);

            LocalDateTime localDateTime = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(dayOfMonth),
                    Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    private String converteData(String date){
        String data = date.substring(0,date.indexOf('T'));
        String hour = date.substring(date.indexOf('T')+1,date.length());
        String datas[] = data.split("-");
        String hours[] = hour.split(":");

        try {
            LocalDateTime localDateTime = LocalDateTime.of(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]), Integer.parseInt(datas[2]),
                    Integer.parseInt(hours[0]), Integer.parseInt(hours[1]), Integer.parseInt(hours[2].substring(0, hours[2].indexOf("."))));
            String dataFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
            return dataFormatada;
        }catch (Exception e){
            return "";
        }
    }

    public boolean validaRrule(String n){
        String splits[] = n.split(";");
        String freq =""; String interval="";String until="";String byDay="";String aux[];
        for(int i=0; i < splits.length;i++){
            aux = splits[i].split("=");
            if(aux[0].equals("FREQ")){
                freq = aux[1];
            }else if(aux[0].equals("INTERVAL")){
                interval = aux[1];
            }else if(aux[0].equals("UNTIL")){
                until = aux[1];
            }else if(aux[0].equals("BYDAY")){
                byDay = aux[1];
            }
        }
        if(freq.equals("DAILY")||freq.equals("WEEKLY")||freq.equals("MONTLHY")||freq.equals("YEARLY")){
            try{
                Integer.parseInt(interval);
                if(validaData(until)==true){
                    return true;
                }else{
                    return false;
                }

            }catch(Exception e){
                if(interval.isEmpty()){
                    return true;
                }else{
                    return false;
                }
            }

        }else{
            return false;
        }


    }

    public boolean removeEvent(UUID sum){
        return this.vevent.removeEvent(sum);
    }

    private ArrayList<String> converteExdate(ArrayList<String> a){
        ArrayList<String> aux = new ArrayList<>();
        for(String b: a){
            if(this.validaData(this.converteData(b))==true) {
                aux.add(this.converteData(b));
            }
        }
        return aux;
    }



}
