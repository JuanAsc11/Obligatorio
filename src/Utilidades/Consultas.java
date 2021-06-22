package Utilidades;

import Entidades.CastMember;
import Entidades.CauseOfDeath;
import Entidades.Movie;
import Entidades.MovieCastMember;
import TADs.Excepciones.EmptyHeapException;
import TADs.Excepciones.FullHeap;
import TADs.Excepciones.KeyNotFound;
import TADs.HeapImpl;
import TADs.HeapNode;
import TADs.Implementaciones.*;

import static Utilidades.CargaDatos.*;
import static Utilidades.Conversores.containsPalabra;
import static Utilidades.Conversores.promedioAltura;

public class Consultas {
    private static long start = 0, stop = 0;

    public static void Consulta1() throws KeyNotFound, FullHeap, EmptyHeapException {
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

        System.out.println("pr1");

        HeapImpl<Integer, CastMember> heapParticipaciones = new HeapImpl<>(297707);

        for(int i = 0; i < 600000; i++) {
            if (castMemberClosedHash.getPosition(i) != null) {
                heapParticipaciones.insertMaxHeap(castMemberClosedHash.getPosition(i).getParticipaciones(), castMemberClosedHash.getPosition(i));
            }
        }
        heapParticipaciones.vizualizar();
        System.out.println("pr2");
        for (int i =0; i < 5;i++) {
            if (heapParticipaciones.delete().getData() != null) {
                System.out.println("Nombre actor/actriz: " + heapParticipaciones.getMax().getData().getName() + "\n"
                        + "Cantidad de apariciones: " + heapParticipaciones.getMax().getData().getParticipaciones() + "\r\n");
            }
        }
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de la consulta: " + (stop - start));
    }

    public static void Consulta2() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String,MovieCastMember>> temp;
        ListaEnlazada<NodoHash<String, CauseOfDeath>> temp2;
        LinkedHashImpl<String, CauseOfDeath> causes = new LinkedHashImpl<>(1090000);
        HeapImpl<Integer,String> causesOrd = new HeapImpl<>(1090000);
        for (int i = 0; i < 1090000; i++){
            temp = movieCastMemberLinkedHash.getList(i);
            if(temp != null){
                if(temp.getPrimerNodo().getValue().getData().getCategory().equals("producer") ||
                        temp.getPrimerNodo().getValue().getData().getCategory().equals("director")) {
                    CastMember direcprod = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    if (containsPalabra(direcprod.getBirthCountry(),"USA")
                            ||containsPalabra(direcprod.getBirthCountry(),"UK")
                            ||containsPalabra(direcprod.getBirthCountry(),"France")
                            ||containsPalabra(direcprod.getBirthCountry(),"Italy")){
                        if(!(direcprod.getCauseOfDeath().equals(""))) {
                            causes.put(direcprod.getCauseOfDeath().getName(), direcprod.getCauseOfDeath());
                        }
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
        HeapNode<Integer,String> causa1 = causesOrd.delete();
        HeapNode<Integer,String> causa2 = causesOrd.delete();
        HeapNode<Integer,String> causa3 = causesOrd.delete();
        HeapNode<Integer,String> causa4 = causesOrd.delete();
        HeapNode<Integer,String> causa5 = causesOrd.delete();

        stop = System.currentTimeMillis();

        System.out.println("Causa de muerte: " + causa1.getData() + "\r\n" + "Cantidad de personas: " + causa1.getKey() + "\r\n");
        System.out.println("Causa de muerte: " + causa2.getData() + "\r\n" + "Cantidad de personas: " + causa2.getKey() + "\r\n");
        System.out.println("Causa de muerte: " + causa3.getData() + "\r\n" + "Cantidad de personas: " + causa3.getKey() + "\r\n");
        System.out.println("Causa de muerte: " + causa4.getData() + "\r\n" + "Cantidad de personas: " + causa4.getKey() + "\r\n");
        System.out.println("Causa de muerte: " + causa5.getData() + "\r\n" + "Cantidad de personas: " + causa5.getKey() + "\r\n");
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");
    }

    public static void Consulta3() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        Movie temp;
        HeapImpl<Float,Movie> peliculas = new HeapImpl<>(85855);
        for(int i = 0;i<85855;i++){
            temp = movieClosedHash.getPosition(i);
            if(temp.getYear() >= 1950 && temp.getYear() <= 1960){
                float wA = movieRatings.get(temp.getImdbTitled()).getWeightedAverage();
                peliculas.insertMaxHeap(wA,temp);
            }
        }
        for(int i = 0;i<14;i++){
            Movie pelicula = peliculas.delete().getData();
            int promedio = promedioAltura(pelicula.getActors());
            System.out.print("Id película: " + pelicula.getImdbTitled() + "\r\n"
                    + "Nombre: " + pelicula.getTitle() + "\r\n"
                    + "Altura promedio de actores:" + promedio + "\r\n");
        }
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");
    }

    public static void Consulta4() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String,MovieCastMember>> temp;
        ListaEnlazada<NodoHash<Integer,CastMember>> temp2;
        LinkedHashImpl<Integer,CastMember> newHashActores = new LinkedHashImpl<>(600000);
        LinkedHashImpl<Integer,CastMember> newHashActrices = new LinkedHashImpl<>(600000);
        HeapImpl<Integer,Integer> HeapActores = new HeapImpl<>(600000);
        HeapImpl<Integer,Integer> HeapActrices = new HeapImpl<>(600000);
        for (int i = 0; i < 1090000; i++) {
            temp = movieCastMemberLinkedHash.getList(i); //
            if (temp != null) {
                if (temp.getPrimerNodo().getValue().getData().getCategory().equals("actor")) {
                    CastMember actor = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    newHashActores.put(actor.getBirthYear(), actor);
                } else if (temp.getPrimerNodo().getValue().getData().getCategory().equals("actress")) {
                    CastMember actriz = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    newHashActrices.put(actriz.getBirthYear(), actriz);
                }
            }
        }
        for (int i = 0; i < 600000; i++){
                temp2 = newHashActores.getList(i);
                if(temp2 != null){
                    HeapActores.insertMaxHeap(temp2.getSize(),temp2.getPrimerNodo().getValue().getKey());
                }
                temp2 = newHashActrices.getList(i);
                if(temp2 != null){
                    HeapActrices.insertMaxHeap(temp2.getSize(),temp2.getPrimerNodo().getValue().getKey());
                }
        }
        HeapNode<Integer,Integer> yearActores = HeapActores.delete();
        HeapNode<Integer,Integer> yearActrices = HeapActrices.delete();

        stop = System.currentTimeMillis();

        System.out.println("Actores:" + "\r\n" + "Año:" + yearActores.getData() + "Cantidad:" + yearActores.getKey() + "\r\n");
        System.out.println("Actrices:" + "\r\n" + "Año:" + yearActrices.getData() + "Cantidad:" + yearActrices.getKey() + "\r\n");
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");
    }

    public static void Consulta5() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String, MovieCastMember>> temp;
        ListaEnlazada<NodoHash<String, Movie>> temp2;
        LinkedHashImpl<String, Movie> newHashGeneros = new LinkedHashImpl<>(600000);
        HeapImpl<Integer, String> HeapGeneros = new HeapImpl<>(855000);
        for (int i = 0; i < 1090000; i++) {
            temp = movieCastMemberLinkedHash.getList(i); //
            if (temp != null) {
                if (temp.getPrimerNodo().getValue().getData().getCategory().equals("actor")
                        || temp.getPrimerNodo().getValue().getData().getCategory().equals("actress")) {
                    CastMember actor = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    int hijos = actor.getChildren();
                    if (actor.getChildren()<2){
                        System.out.println("Error hijos");
                    }
                    else if (actor.getChildren() > 2) {
                        String nombrePelicula = movieCastMemberLinkedHash.get(actor.getImdbNameId()).getImdb_title_id();
                        Movie pelicula = movieClosedHash.get(nombrePelicula);
                        ListaEnlazada<String> generos = pelicula.getGenre();
                        for (int j = 0; j < generos.getSize(); j++) {
                            newHashGeneros.put(generos.get(i).getValue(), pelicula);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 600000; i++) {
            temp2 = newHashGeneros.getList(i);
            if (temp2 != null) {
                HeapGeneros.insertMaxHeap(temp2.getSize(), temp2.getPrimerNodo().getValue().getKey());
            }
        }

        stop = System.currentTimeMillis();

        for (int i =0; i < 10;i++) {
            if (HeapGeneros.getMax() != null) {
                System.out.println("Genero pelicula: " + HeapGeneros.delete().getData() + "\n"
                        + "Cantidad: " + HeapGeneros.getMax().getKey() + "\r\n");
            }
        }
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");
    }
}
