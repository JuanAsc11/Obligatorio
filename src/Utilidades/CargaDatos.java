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
        String filename1 = "IMDb title_principals.csv";
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
        String fileName2 = "IMDb names.csv";
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
            CauseOfDeath nuevaCauseOfDeath = new CauseOfDeath(atributos[11]);
            nuevoCastMember.setCauseOfDeath(nuevaCauseOfDeath);
            castMemberClosedHash.put(nuevoCastMember.getImdbNameId(),nuevoCastMember);
        }
    }

    public static void CargaMovies() throws UnavailableIndex {
        String fileName3 = "IMDb movies.csv";
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

    }

    public static void CargaRatings() throws UnavailableIndex {
        String fileName4 = "IMDb ratings.csv";
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

    }
}
