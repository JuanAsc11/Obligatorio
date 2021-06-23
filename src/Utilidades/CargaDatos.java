package Utilidades;

import Entidades.*;
import Reader.CsvIterator;
import Reader.Reader;
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
import java.util.Iterator;


public class CargaDatos {

    public static LinkedHashImpl<String,MovieCastMember> movieCastMemberLinkedHash = new LinkedHashImpl<>(1113991);

    public static MyClosedHashImpl<String,CastMember> castMemberClosedHash = new MyClosedHashImpl<>(396947);

    public static MyClosedHashImpl<String, Movie> movieClosedHash = new MyClosedHashImpl<>(114473);

    public static MyClosedHashImpl<String,MovieRating> movieRatings = new MyClosedHashImpl<>(114473);

    public static void CargaMovieCastMembers() {
        String fileName1 = "src/IMDb title_principals.csv";
        File principals = new File(fileName1);
        Reader reader = new Reader(principals);
        Iterator<String[]> readerIterator =reader.iterator();

        String[] atributos = readerIterator.next();
        if(readerIterator.hasNext()){
            atributos = readerIterator.next();
        }
        while (readerIterator.hasNext()){
            atributos = readerIterator.next();
            MovieCastMember nuevoMovieCastMember = new MovieCastMember(atributos);
            movieCastMemberLinkedHash.put(nuevoMovieCastMember.getImdb_name_id(),nuevoMovieCastMember);
        }


        /*String filename1 = "src/IMDb title_principals.csv";
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
        }*/
    }

    public static void CargaCastMember() throws UnavailableIndex {
        String fileName2 = "src/IMDb names.csv";
        File names = new File(fileName2);
        Reader reader = new Reader(names);
        Iterator<String[]> readerIterator =reader.iterator();

        String[] atributos = readerIterator.next();
        if(readerIterator.hasNext()){
            atributos = readerIterator.next();
        }
        while (readerIterator.hasNext()){
            atributos = readerIterator.next();
            CastMember nuevoCastMember = new CastMember(atributos);
            castMemberClosedHash.put(nuevoCastMember.getImdbNameId(),nuevoCastMember);
        }


        /*String fileName2 = "src/IMDb names.csv";
        Path pathToFile2 = Paths.get(fileName2);
        File archivo = new File(String.valueOf(pathToFile2));
        CsvIterator reader = new CsvIterator(archivo);
        boolean tengo = reader.hasNext();
        String[] atributos = reader.next();
        tengo = reader.hasNext();
        while (tengo) {
            atributos = reader.next();
            CastMember nuevoCastMember = new CastMember(atributos);
            CauseOfDeath nuevaCauseOfDeath = new CauseOfDeath(atributos[11]);
            nuevoCastMember.setCauseOfDeath(nuevaCauseOfDeath);
            castMemberClosedHash.put(nuevoCastMember.getImdbNameId(), nuevoCastMember);
            tengo = reader.hasNext();
        }*/
    }

    public static void CargaMovies() throws UnavailableIndex {
        String fileName3 = "src/IMDb movies.csv";
        File movies = new File(fileName3);
        Reader reader = new Reader(movies);
        Iterator<String[]> readerIterator =reader.iterator();

        String[] atributos = readerIterator.next();
        if(readerIterator.hasNext()){
            atributos = readerIterator.next();
        }
        while (readerIterator.hasNext()){
            atributos = readerIterator.next();
            Movie nuevaMovie = new Movie(atributos);
            movieClosedHash.put(nuevaMovie.getImdbTitled(),nuevaMovie);
        }



        /*String fileName = "src/IMDb movies.csv";
        Path pathToFile = Paths.get(fileName);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){
                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Movie nuevaMovie = new Movie(atributos);
                movieClosedHash.put(nuevaMovie.getImdbTitled(),nuevaMovie);
                line = reader.readLine();
            }
        }
        catch (IOException | UnavailableIndex e){
            e.printStackTrace();
        }*/
    }

    public static void CargaRatings() throws UnavailableIndex {
        String fileName4 = "src/IMDb ratings.csv";
        File ratings = new File(fileName4);
        Reader reader = new Reader(ratings);
        Iterator<String[]> readerIterator =reader.iterator();

        String[] atributos = readerIterator.next();
        if(readerIterator.hasNext()){
            atributos = readerIterator.next();
        }
        while (readerIterator.hasNext()){
            atributos = readerIterator.next();
            MovieRating nuevoMovieRating = new MovieRating(atributos);
            movieRatings.put(nuevoMovieRating.getImbd_title_id(),nuevoMovieRating);

        }



        /*String filename3 = "src/IMDb ratings.csv";
        Path pathToFile3 = Paths.get(filename3);
        try(BufferedReader reader = Files.newBufferedReader(pathToFile3, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){
                String[] atributos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                MovieRating nuevoMovieRating = new MovieRating(atributos);
                movieRatings.put(nuevoMovieRating.getImbd_title_id(),nuevoMovieRating);
                line = reader.readLine();
            }
        }
        catch (IOException | UnavailableIndex e) {
            e.printStackTrace();
        }*/
    }
}
