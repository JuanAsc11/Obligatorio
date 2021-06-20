package Utilidades;

import CsvReader.CsvReaderIterator;
import Entidades.MovieCastMember;
import TADs.Implementaciones.LinkedHashImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CargaDatos {

    public static LinkedHashImpl<String,MovieCastMember> movieCastMemberLinkedHash = new LinkedHashImpl<>(1090000);

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

    public static void CargaCastMember(){
        String fileName2 = "src/IMDb names.csv";
        Path pathToFile2 = Paths.get(fileName2);
        File archivo = new File(String.valueOf(pathToFile2));
        CsvReaderIterator reader = new CsvReaderIterator(archivo);
        boolean tengo = reader.hasNext();
        if(tengo){
            reader.next();
        }
    }
}
