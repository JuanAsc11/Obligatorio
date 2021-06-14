package Conversores;

import TADs.Implementaciones.ListaEnlazada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversores {

    //CONVERSORES

    public static ListaEnlazada<String> convertToVarios(String elementos) {
        ListaEnlazada<String> List = new ListaEnlazada<>();
        //Dividir elementos por "," y add a List
        String[] varios = elementos.split(",");
        for(String elemento: varios){
            List.add(elemento);
        }
        return List;
    }

    public static Date convertToDate(String dates){
        Date date = null;
        if(dates == null) {
            return null;
        }
        while (true){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                format.setLenient(false);
                date = format.parse(dates);
            } catch (ParseException e) {
                // try other formats
            }
            if (date != null) {
                break;
            }
            format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                format.setLenient(false);
                date = format.parse(dates);
            } catch (ParseException e) {
                // try other formats
            }
            if (date != null) {
                break;
            }
            format = new SimpleDateFormat("yyyy");
            try {
                format.setLenient(false);
                date = format.parse(dates);
            } catch (ParseException e) {
                // try other formats
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }

    public static String convertCountry(String places){
        String pais;
        String[] lugares = places.split(",");
        pais = lugares[lugares.length-1];
        return pais;
    }

    public static String convertState(String places){
        String state = null;
        String[] lugares = places.split(",");
        if(lugares.length==3){
            state = lugares[1];
        }
        else if(lugares.length==4){
            state = lugares[2];                                 //Problema en algunos casos
        }
        return state;
    }

    public static String convertCity(String places){
        String city = null;
        String[] lugares = places.split(",");
        if (lugares.length == 2){
            city = lugares[0];
        }
        else if(lugares.length == 3){
            city = lugares[0];
        }
        else if(lugares.length == 4){
            city = lugares[1];
        }
        return city;
    }
}
