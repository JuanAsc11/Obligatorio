package Utilidades;

import Entidades.CastMember;
import Entidades.MovieCastMember;
import TADs.Excepciones.KeyNotFound;
import TADs.HeapImpl;
import TADs.Implementaciones.*;

import static Utilidades.CargaDatos.castMemberClosedHash;
import static Utilidades.CargaDatos.movieCastMemberLinkedHash;

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

        System.out.println("pr1");

        HeapImpl<Integer, CastMember> heapParticipaciones = new HeapImpl<>(297705);

        for(int i = 0; i < 600000; i++) {
            if (castMemberClosedHash.getPosition(i) != null) {
                heapParticipaciones.insertMaxHeap(castMemberClosedHash.getPosition(i).getParticipaciones(), castMemberClosedHash.getPosition(i));
            }
        }
        System.out.println("pr2");
        for (int i =0; i < 5;i++) {
            if (heapParticipaciones.getMax() != null) {
                System.out.println("Nombre actor/actriz: " + heapParticipaciones.getMax().getData().getName() + "\n"
                        + "Cantidad de apariciones: " + heapParticipaciones.getMax().getData().getParticipaciones() + "\r\n");
                heapParticipaciones.borrarMax();
            }
        }
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de la consulta: " + (stop - start));
    }

    public static void Consulta2(){}

    public static void Consulta3(){}

    public static void Consulta4(){}

    public static void Consulta5(){}

}
