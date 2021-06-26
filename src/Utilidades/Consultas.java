package Utilidades;

import Entidades.*;
import TADs.Excepciones.EmptyHeapException;
import TADs.Excepciones.FullHeap;
import TADs.Excepciones.KeyNotFound;
import TADs.HeapImpl;
import TADs.HeapNode;
import TADs.Implementaciones.*;

import static Utilidades.CargaDatos.*;
import static Utilidades.Conversores.*;

public class Consultas {
    private static long start = 0, stop = 0;

    public static void Consulta1() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String, MovieCastMember>> temp = null;
        for (int i = 0; i < 1113991; i++) {
            temp = movieCastMemberLinkedHash.getList(i); //
            if(temp != null) {
                Nodo<NodoHash<String, MovieCastMember>> actual = temp.getPrimerNodo();
                for (int z = 0; z < temp.getSize(); z++) {
                    if (actual.getValue().getData().getCategory().equals("actor") || actual.getValue().getData().getCategory().equals("actress")) {
                        castMemberClosedHash.get(actual.getValue().getData().getImdb_name_id()).addParticipacion();
                    }
                    actual = actual.getNextValue();
                }
            }
        }

        HeapImpl<Integer, CastMember> heapParticipaciones = new HeapImpl<>(600000);

        for (int i = 0; i < 396947; i++) {
            if (castMemberClosedHash.getPosition(i) != null) {
                heapParticipaciones.insertMaxHeap(castMemberClosedHash.getPosition(i).getParticipaciones(), castMemberClosedHash.getPosition(i));
            }
        }
        for (int z = 0; z < 5; z++) {
            System.out.println("Nombre actor/actriz: " + heapParticipaciones.getMax().getData().getName() + "\n"
                    + "Cantidad de apariciones: " + heapParticipaciones.delete().getData().getParticipaciones() + "\r\n");
        }

        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de la consulta: " + (stop - start) + "ms");
    }

    public static void Consulta2() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();

        ListaEnlazada<NodoHash<String, MovieCastMember>> temp;
        ListaEnlazada<CauseOfDeath> temp2 = new ListaEnlazada<>();
        LinkedHashImpl<String, CauseOfDeath> causes = new LinkedHashImpl<>(1113991);
        HeapImpl<Integer, String> causesOrd = new HeapImpl<>(1113991);
        for (int i = 0; i < 1113991; i++) {
            temp = movieCastMemberLinkedHash.getList(i);
            if (temp != null) {
                for (int k = 1; k <= temp.getSize(); k++) {
                    if (temp.get(k).getValue().getData().getCategory().equals("producer") || temp.get(k).getValue().getData().getCategory().equals("director")) {
                        CastMember direcprod = castMemberClosedHash.get(temp.get(k).getValue().getKey());
                        if(!direcprod.isMuerteEnCuenta() && direcprod.getBirthCountry() != null && !direcprod.getBirthCountry().equals("")) {
                            direcprod.setMuerteEnCuenta(true);
                            if (direcprod.getBirthCountry().contains("USA")
                                    || direcprod.getBirthCountry().contains("UK")
                                    || direcprod.getBirthCountry().contains("France")
                                    || direcprod.getBirthCountry().contains("Italy")) {
                                if (!(direcprod.getCauseOfDeath().getName().equals(""))) {
                                    //causes.put(direcprod.getCauseOfDeath().getName(), direcprod.getCauseOfDeath());
                                    //break;
                                    if (containsMuerte(temp2, direcprod.getCauseOfDeath())){
                                        getMuerte(temp2, direcprod.getCauseOfDeath()).addCantidad();
                                    }
                                    else {
                                        temp2.add(direcprod.getCauseOfDeath());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Nodo<CauseOfDeath> actual = temp2.getPrimerNodo();
        for (int z = 0; z < temp2.getSize(); z++) {
            causesOrd.insertMaxHeap(actual.getValue().getCantidad(), actual.getValue().getName());
            actual = actual.getNextValue();
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
        HeapImpl<Float,Movie> peliculas = new HeapImpl<>(114473);
        for(int i = 0;i<114473;i++){
            temp = movieClosedHash.getPosition(i);
            if(temp != null) {
                if (temp.getYear() >= 1950 && temp.getYear() <= 1960) {
                    float wA = movieRatings.get(temp.getImdbTitled()).getWeightedAverage();
                    peliculas.insertMaxHeap(wA, temp);
                }
            }
        }
        for(int i=0; i<14; i++){
            Movie pelicula = peliculas.delete().getData();
            float promedio = promedioAltura2(pelicula.getImdbTitled());
            if(promedio != 0) {
                System.out.println("Id película: " + pelicula.getImdbTitled() + "\r\n"
                        + "Nombre: " + pelicula.getTitle() + "\r\n"
                        + "Altura promedio de actores:" + promedio + "\r\n");
            }
        }
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");
    }

    public static void Consulta4() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        ListaEnlazada<Year> yearHombre = new ListaEnlazada<>();
        ListaEnlazada<Year> yearMujer = new ListaEnlazada<>();

        ListaEnlazada<NodoHash<String, MovieCastMember>> temp = null;
        for (int i = 0; i < 1113991; i++) {
            temp = movieCastMemberLinkedHash.getList(i);
            if (temp != null) {
                Nodo<NodoHash<String, MovieCastMember>> actual = temp.getPrimerNodo();
                for (int z = 0; z < temp.getSize(); z++) {
                    if (actual.getValue().getData().getCategory().equals("actor")){
                       CastMember actor =  castMemberClosedHash.get(actual.getValue().getData().getImdb_name_id());
                       if (!actor.isEnCuenta() && actor.getBirthYear() != 0){
                           actor.setEnCuenta(true);
                           Year nuevoYear = new Year(actor.getBirthYear());
                           if (containsAno(yearHombre,nuevoYear)){
                               getAno(yearHombre,nuevoYear).addCantidad();
                           }
                           else {
                               yearHombre.add(nuevoYear);
                           }
                       }
                    }

                    if (actual.getValue().getData().getCategory().equals("actress")){
                        CastMember actor =  castMemberClosedHash.get(actual.getValue().getData().getImdb_name_id());
                        if (!actor.isEnCuenta() && actor.getBirthYear() != 0){
                            actor.setEnCuenta(true);
                            Year nuevoYear = new Year(actor.getBirthYear());
                            if (containsAno(yearMujer,nuevoYear)){
                                getAno(yearMujer,nuevoYear).addCantidad();
                            }
                            else {
                                yearMujer.add(nuevoYear);
                            }
                        }
                    }
                    actual = actual.getNextValue();
                }
            }
        }
        HeapImpl<Integer,Integer> HeapActores = new HeapImpl<>(396947);
        HeapImpl<Integer,Integer> HeapActrices = new HeapImpl<>(396947);
        Nodo<Year> actual = yearHombre.getPrimerNodo();
        Nodo<Year> actual2 = yearMujer.getPrimerNodo();
        for (int z = 0; z < yearHombre.getSize(); z++) {
            HeapActores.insertMaxHeap(actual.getValue().getCantidad(),actual.getValue().getYear());
            actual = actual.getNextValue();
        }
        for (int z = 0; z < yearMujer.getSize(); z++) {
            HeapActrices.insertMaxHeap(actual2.getValue().getCantidad(),actual2.getValue().getYear());
            actual2 = actual2.getNextValue();
        }

        System.out.println("Actores:" + "\r\n" + "Año: " + HeapActores.getMax().getData() + "\r\n" + "Cantidad: " + HeapActores.getMax().getKey() + "\r\n");
        System.out.println("Actrices:" + "\r\n" + "Año: " + HeapActrices.getMax().getData() + "\r\n" + "Cantidad: " + HeapActrices.getMax().getKey() + "\r\n");
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion de la consulta:" + (stop - start) + "ms." + "\r\n");

    }

    public static void Consulta5() throws KeyNotFound, FullHeap, EmptyHeapException {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String, MovieCastMember>> temp;
        ListaEnlazada<NodoHash<String, Movie>> temp2;
        ListaEnlazada<Genre> generosLista = new ListaEnlazada<>();
        HeapImpl<Integer, Genre> HeapGeneros = new HeapImpl<>(114473);
        for (int i = 0; i < 1113991; i++) {
            temp = movieCastMemberLinkedHash.getList(i);
            if (temp != null) {
                for(int k = 1; k <= temp.getSize();k++){
                    if (temp.get(k).getValue().getData().getCategory().equals("actor") || temp.get(k).getValue().getData().getCategory().equals("actress")) {
                        CastMember actor = castMemberClosedHash.get(temp.get(k).getValue().getKey());
                        if (actor.getChildren() >= 2) {
                            String idPelicula = temp.get(k).getValue().getData().getImdb_title_id();
                            Movie pelicula = movieClosedHash.get(idPelicula);
                            if (!pelicula.isEnCuenta5() && pelicula.getGenre().getSize() > 0){
                                pelicula.setEnCuenta5(true);
                                ListaEnlazada<Genre> genPeli = pelicula.getGenre(); //Esperar Jimena
                                for(int z = 1; z<= genPeli.getSize();z++){
                                    Genre gen = genPeli.get(z).getValue();
                                    if(!containsGenre(generosLista,gen) && !gen.getNombre().equals("")){
                                        generosLista.add(gen);
                                    }
                                    else {
                                        getGenero(generosLista,gen).addCantidad();
                                    }

                                }

                            }
                        }
                    }
                }
            }
        }

        Nodo<Genre> actual = generosLista.getPrimerNodo();
        for (int z = 0; z < generosLista.getSize(); z++) {
            HeapGeneros.insertMaxHeap(actual.getValue().getCantidad(),actual.getValue());
            actual = actual.getNextValue();
        }

        for (int i =0; i < 10;i++) {
            System.out.println("Genero pelicula: " + HeapGeneros.getMax().getData().getNombre() + "\r\n" + "Cantidad: " + HeapGeneros.delete().getKey() + "\r\n");
        }
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion de la consulta: " + (stop - start) + "ms." + "\r\n");
    }
}