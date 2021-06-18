import Clases.CastMember;
import Clases.Movie;
import Clases.MovieCastMember;
import Clases.MovieRating;
import TADs.Excepciones.EmptyHeapException;
import TADs.Implementaciones.ListaEnlazada;
import TADs.Implementaciones.MyHeapImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu{

    public ListaEnlazada<Movie> pelis;

    public MyHeapImpl<MovieCastMember> query1;

    public ListaEnlazada<CastMember> personas;

    public ListaEnlazada<MovieRating> ratings;

    public Menu(){
        this.pelis = new ListaEnlazada<>();
        this.query1 = new MyHeapImpl<>(835493,1);
        this.personas = new ListaEnlazada<>();
        this.ratings = new ListaEnlazada<>();
    }

    public void cargarDatos(){
        String filename3 = "src/IMDb ratings.csv";
        Path pathToFile3 = Paths.get(filename3);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile3, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){

                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                MovieRating nuevoMovieRating = new MovieRating(atributos);

                ratings.add(nuevoMovieRating);

                line = reader.readLine();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        /*String filename2 = "src/IMDb names.csv";
        Path pathToFile2 = Paths.get(filename2);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile2, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){

                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                CastMember nuevoCastMember = new CastMember(atributos);

                personas.add(nuevoCastMember);

                line = reader.readLine();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        /*String filename1 = "src/IMDb title_principals.csv";
        Path pathToFile1 = Paths.get(filename1);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile1, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){

                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                MovieCastMember nuevoMovieCastMember = new MovieCastMember(atributos);

                query1.insert(nuevoMovieCastMember);

                line = reader.readLine();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        //CARGAR PELICULAS PRUEBA
        String fileName = "src/IMDb movies.csv";
        Path pathToFile = Paths.get(fileName);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){
                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                Movie peliculaNueva = new Movie(atributos);

                if(peliculaNueva.getYear() >= 1930 && peliculaNueva.getYear() <= 1950){
                    pelis.add(peliculaNueva);
                }

                line = reader.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws EmptyHeapException {
        Menu menuPrincipal = new Menu();
        boolean control = true;
        Scanner scanner = new Scanner(System.in);
        while(control){  // Menu 1
            System.out.println("1. Carga de Datos" + "\r\n" + "2. Ejecutar consultas" + "\r\n" + "3. Salir");
            int entrada = scanner.nextInt();
            if(entrada == 1){ //Opcion carga
                menuPrincipal.cargarDatos();
                //MovieCastMember top1 = menuPrincipal.query1.get();
                //System.out.println("Nombre actor " + top1.getImdb_name_id() + "\r\n"+"Cantidad de Apariciones: " +  top1.getCharacters().getSize());
                System.out.println("Proceso funciona");
            }
            else if(entrada == 2){  // Menu 2
                boolean control2 = true;
                while(control2){
                    System.out.println("1. Indicar el Top 5 de actores/actrices que más apariciones han tenido a lo largo de los años."
                            + "\r\n" + "2. Indicar el Top 5 de las causas de muerte más frecuentes en directores y productores nacidos en Italia, Estados Unidos, Francia y UK."
                            + "\r\n" + "3. Mostrar de las 14 películas con más weightedAverage, el promedio de altura de sus actores/actrices si su valor es distinto de nulo."
                            + "\r\n" + "4. Indicar el año más habitual en el que nacen los actores y las actrices."
                            + "\r\n" + "5. Indicar el Top 10 de géneros de películas más populares, en las cuales al menos un actor/actriz tiene 2 o más hijos."
                            + "\r\n" + "6. Salir");
                    int entrada2 = scanner.nextInt();
                    if(entrada2 == 1){
                        // QUERY 1
                    }
                    else if(entrada2 == 2){
                        //QUERY 2
                    }
                    else if(entrada2 == 3){
                        //QUERY 3
                    }
                    else if(entrada2 == 4){
                        //QUERY 4
                    }
                    else if(entrada2 == 5){
                        //QUERY 5
                    }
                    else if(entrada2 == 6){ //VOLVER MENU PRINCIPAL
                        control2 = false;
                    }
                    else{
                        System.out.println("\r\n" + "Opción incorrecta, porfavor vuelva a intentarlo." + "\r\n");
                    }
                }
            }
            else if(entrada == 3){
                System.out.println("Aplicación finalizada.");
                control = false;
            }
            else {
                System.out.println("\r\n" + "Opción incorrecta, porfavor vuelva a intentarlo." + "\r\n");
            }
        }
    }
}
