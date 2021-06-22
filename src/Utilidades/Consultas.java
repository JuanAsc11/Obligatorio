package Utilidades;

import Entidades.CastMember;
import Entidades.MovieCastMember;
import TADs.Excepciones.KeyNotFound;
import TADs.Implementaciones.*;

import static Utilidades.CargaDatos.castMemberClosedHash;
import static Utilidades.CargaDatos.movieCastMemberLinkedHash;

public class Consultas {
    private static long start = 0, stop = 0;

    public static void Consulta1() throws KeyNotFound {
        start = System.currentTimeMillis();
        ListaEnlazada<NodoHash<String,MovieCastMember>> temp = null;
        for (int i = 0; i < 1090000; i++){
            temp = movieCastMemberLinkedHash.getList(i);
            if(temp != null){
                if(temp.getPrimerNodo().getValue().getData().getJob().equals("actor") ||
                        temp.getPrimerNodo().getValue().getData().getJob().equals("actress")) {

                    CastMember actor = castMemberClosedHash.get(temp.getPrimerNodo().getValue().getKey());
                    actor.addParticipacion();
                }
            }
        }
    }

    public static void Consulta2(){}

    public static void Consulta3(){}

    public static void Consulta4(){}

    public static void Consulta5(){}

}
