package Utilidades;

import Entidades.*;
import Reader.CsvIterator;
import TADs.Excepciones.UnavailableIndex;
import TADs.Implementaciones.LinkedHashImpl;
import TADs.Implementaciones.ListaEnlazada;
import TADs.Implementaciones.MyClosedHashImpl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CargaDatos {

    public static LinkedHashImpl<String,MovieCastMember> movieCastMemberLinkedHash = new LinkedHashImpl<>(1090000);

    public static MyClosedHashImpl<String,CastMember> castMemberClosedHash = new MyClosedHashImpl<>(600000);

    public static MyClosedHashImpl<String, Movie> movieClosedHash = new MyClosedHashImpl<>(85855);

    public static ListaEnlazada<MovieRating> movieRatings = new ListaEnlazada<>();

    public static void CargaMovieCastMembers() {
        String filename1 = "src/IMDb title_principals.csv";
        Path pathToFile1 = Paths.get(filename1);
        try (BufferedReader reader = Files.newBufferedReader(pathToFile1, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                MovieCastMember nuevoMovieCastMember = new MovieCastMember(atributos);

                movieCastMemberLinkedHash.put(nuevoMovieCastMember.getImdb_name_id(),nuevoMovieCastMember);

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CargaCastMember() throws UnavailableIndex {
        String fileName2 = "src/IMDb names.csv";
        Path pathToFile2 = Paths.get(fileName2);
        File archivo = new File(String.valueOf(pathToFile2));
        CsvIterator reader = new CsvIterator(archivo);
        boolean tengo = reader.hasNext();
        while(tengo){
                String[] atributos = reader.next();
                CastMember nuevoCastMember = new CastMember(atributos);
                CauseOfDeath nuevaCauseOfDeath = new CauseOfDeath(atributos[11]);
                nuevoCastMember.setCauseOfDeath(nuevaCauseOfDeath);
                castMemberClosedHash.put(nuevoCastMember.getImdbNameId(),nuevoCastMember);
            }
        }

    public static void CargaMovies() {
        int cantidad = 0;
        String fileName = "src/IMDb movies.csv";
        Path pathToFile = Paths.get(fileName);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
            String line = reader.readLine();
            cantidad++;
            line = reader.readLine();
            cantidad++;
            while(line != null){
                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Movie nuevaMovie = new Movie(atributos);
                movieClosedHash.put(nuevaMovie.getImdbTitled(),nuevaMovie);
                System.out.println(cantidad++);
                line = reader.readLine();
            }
        }
        catch (IOException | UnavailableIndex e){
            e.printStackTrace();
        }
    }

    public static void CargaRatings(){
        String filename3 = "src/IMDb ratings.csv";
        Path pathToFile3 = Paths.get(filename3);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile3, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){

                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                MovieRating nuevoMovieRating = new MovieRating(atributos);

                movieRatings.add(nuevoMovieRating);

                line = reader.readLine();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
