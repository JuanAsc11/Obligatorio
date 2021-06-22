package Utilidades;

import Entidades.CastMember;
import Entidades.CauseOfDeath;
import Entidades.MovieCastMember;
import TADs.Excepciones.KeyNotFound;
import TADs.HeapImpl;
import TADs.HeapNode;
import TADs.Implementaciones.*;

import static Utilidades.CargaDatos.castMemberClosedHash;
import static Utilidades.CargaDatos.movieCastMemberLinkedHash;
import static Utilidades.Conversores.containsPalabra;

public class Consultas {
    private static long start = 0, stop = 0;

    public static void Consulta1() throws KeyNotFound {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String,MovieCastMember>> temp = null;
        for (int i = 0; i < 1090000; i++){
            temp = movieCastMemberLinkedHash.getList(i); //
            if(temp != null){
                if(temp.getPrimerNodo().getValue().getData().getCategory().equals("actor") || temp.getPrimerNodo().getValue().getData().getCategory().equals("actress")) {
                    System.out.println("OH");
                    System.out.println(movieCastMemberLinkedHash.get(temp.getPrimerNodo().getValue().getKey()).getImdb_name_id());
                    CastMember actor = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    actor.addParticipacion();
                }
            }
        }
    }

    public static void Consulta2() throws KeyNotFound {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String,MovieCastMember>> temp = null;
        ListaEnlazada<NodoHash<String, CauseOfDeath>> temp2 = null;
        LinkedHashImpl<String, CauseOfDeath> causes = new LinkedHashImpl<>(1090000);
        HeapImpl<Integer,String> causesOrd = new HeapImpl<>(1090000);
        for (int i = 0; i < 1090000; i++){
            temp = movieCastMemberLinkedHash.getList(i);
            if(temp != null){
                if(temp.getPrimerNodo().getValue().getData().getCategory().equals("producer") ||
                        temp.getPrimerNodo().getValue().getData().getCategory().equals("director")) {
                    CastMember direcprod = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    if(containsPalabra(direcprod.getBirthCountry(),"USA")
                            ||containsPalabra(direcprod.getBirthCountry(),"UK")
                            ||containsPalabra(direcprod.getBirthCountry(),"France")
                            ||containsPalabra(direcprod.getBirthCountry(),"Italy")){
                        causes.put(direcprod.getCauseOfDeath().getName(),direcprod.getCauseOfDeath());
                    }
                }
            }
        }
        for(int i = 0; i < 1090000; i++){
            temp2 = causes.getList(i);
            if(temp2 != null){
                causesOrd.insertMaxHeap(temp2.getSize(),temp2.getPrimerNodo().getValue().getKey());
            }
        }
        HeapNode causa1 = causesOrd.getMax();
        HeapNode causa2 = causesOrd.getMax();
        HeapNode causa3 = causesOrd.getMax();
        HeapNode causa4 = causesOrd.getMax();
        HeapNode causa5 = causesOrd.getMax();

        stop = System.currentTimeMillis();

        System.out.println("Causa de muerte:" + causa1.getData() + "\r\n" + "Cantidad de personas:" + causa1.getKey() + "\r\n");
        System.out.println("Causa de muerte:" + causa2.getData() + "\r\n" + "Cantidad de personas:" + causa2.getKey() + "\r\n");
        System.out.println("Causa de muerte:" + causa3.getData() + "\r\n" + "Cantidad de personas:" + causa3.getKey() + "\r\n");
        System.out.println("Causa de muerte:" + causa4.getData() + "\r\n" + "Cantidad de personas:" + causa4.getKey() + "\r\n");
        System.out.println("Causa de muerte:" + causa5.getData() + "\r\n" + "Cantidad de personas:" + causa5.getKey() + "\r\n");
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");
    }

    public static void Consulta3(){}

    public static void Consulta4(){}

    public static void Consulta5(){}

}
