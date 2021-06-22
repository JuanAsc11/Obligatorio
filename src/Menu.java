import Entidades.MovieCastMember;
import TADs.Excepciones.EmptyHeapException;
import TADs.Excepciones.FullHeap;
import TADs.Excepciones.KeyNotFound;
import TADs.Excepciones.UnavailableIndex;
import TADs.Implementaciones.NodoHash;
import TADs.Implementaciones.ListaEnlazada;

import java.util.Scanner;

import static Utilidades.CargaDatos.*;
import static Utilidades.Consultas.*;

public class Menu{
        public static long start = 0, stop = 0;
        public static ListaEnlazada<NodoHash<String, MovieCastMember>> tempres = null;

    public static void main(String[] args) throws EmptyHeapException, UnavailableIndex, KeyNotFound, FullHeap {
        Menu menuPrincipal = new Menu();

        boolean control = true;

        Scanner scanner = new Scanner(System.in);

        while(control){  // Menu 1

            System.out.println("1. Carga de Datos" + "\r\n" + "2. Ejecutar consultas" + "\r\n" + "3. Salir");

            int entrada = scanner.nextInt();

            switch (entrada){

                case 1:
                    start = System.currentTimeMillis();

                    CargaMovieCastMembers();

                    CargaCastMember();

                    CargaMovies();

                    CargaRatings();

                    stop = System.currentTimeMillis();

                    System.out.println("Carga de datos exitosa, tiempo de ejecución de la carga: " + (stop - start) + "ms." + "\r\n");
                    break;
                case 2:
                    menuConsultas();
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("\r\n" + "Opción inválida" + "\r\n");

            }


        }
    }

    public static void menuConsultas() throws KeyNotFound, FullHeap, EmptyHeapException {
        Scanner reader = new Scanner(System.in);
        boolean control2 = true;
        while(control2) {
            System.out.println("1. Indicar el Top 5 de actores/actrices que más apariciones han tenido a lo largo de los años."
                    + "\r\n" + "2. Indicar el Top 5 de las causas de muerte más frecuentes en directores y productores nacidos en Italia, Estados Unidos, Francia y UK."
                    + "\r\n" + "3. Mostrar de las 14 películas con más weightedAverage, el promedio de altura de sus actores/actrices si su valor es distinto de nulo."
                    + "\r\n" + "4. Indicar el año más habitual en el que nacen los actores y las actrices."
                    + "\r\n" + "5. Indicar el Top 10 de géneros de películas más populares, en las cuales al menos un actor/actriz tiene 2 o más hijos."
                    + "\r\n" + "6. Salir");

            int entrada = reader.nextInt();

            switch (entrada) {
                case 1:
                    Consulta1();
                    break;
                case 2:
                    Consulta2();
                    break;
                case 3:
                    Consulta3();
                    break;
                case 4:
                    Consulta4();
                    break;
                case 5:
                    Consulta5();
                    break;
                case 6:
                    control2 = false;
                    break;
                default:
                    System.out.println("\r\n" + "Opción inváida" + "\r\n");
            }
        }
    }
}
