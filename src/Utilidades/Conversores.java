package Utilidades;

import TADs.Implementaciones.ListaEnlazada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversores {

    //CONVERSORES

    public static ListaEnlazada<String> convertToVarios(String elementos) {
        ListaEnlazada<String> List = new ListaEnlazada<>();
        //Dividir elementos por "," y add a List
        if(!hayComa(elementos)){
            List.add(elementos);
        }
        else{
            if(elementos.length() > 0) {
                elementos = elementos.substring(1, elementos.length() - 1);
            }
            String[] varios = elementos.split(",");
            for(String elemento: varios){
                List.add(elemento);
            }}
        return List;
    }

    public static boolean hayComa(String elementos){
        if(elementos != null){
            for(int i = 0; i<elementos.length(); i++){
                if(elementos.charAt(i) == ','){
                    return true;
                }
            }
        }
        return false;
    }

    public static ListaEnlazada<String> convertToVariosMCM(String elementos) {
        ListaEnlazada<String> List = new ListaEnlazada<>();
        //Dividir elementos por "," y add a List
        if(elementos.length() > 1) {
            elementos = elementos.substring(2, elementos.length() - 2);
        }
        String[] varios = elementos.split(",");
        for(String elemento: varios){
            if(elemento.length() > 4) {
                elemento = elemento.substring(2, elemento.length() - 2);
            }
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

    public static int convertToBirthYear(String dates){
        Date date = convertToDate(dates);
        int year = date.getYear() + 1900;
        return year;
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

    public static int controlParse(String string){
        try{
            int num = Integer.parseInt(string);
            return num;
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    public static float controlFloat(String string){
        try{
            float num = Float.parseFloat(string);
            return num;
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

}
