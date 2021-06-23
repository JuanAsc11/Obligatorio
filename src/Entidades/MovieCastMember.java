package Entidades;

import TADs.Implementaciones.ListaEnlazada;
import static Utilidades.Conversores.convertToVarios;
import static Utilidades.Conversores.convertToVariosMCM;

public class MovieCastMember implements Comparable<MovieCastMember> {

    //ATRIBUTOS

    private int ordering;

    private String category;

    private String job;

    private ListaEnlazada<String> characters;

    private String imdb_title_id;

    private String imdb_name_id;

    //CONSTRUCTOR

    public MovieCastMember(String[] atributos){
        this.imdb_title_id = atributos[0].substring(atributos[0].lastIndexOf("tt"));
        this.ordering = Integer.parseInt(atributos[1]);
        this.imdb_name_id = atributos[2];
        this.category = atributos[3];
        this.job = atributos[4];
        this.characters = convertToVariosMCM(atributos[5]);
    }

    //GETTERS

    public int getOrdering() {
        return ordering;
    }

    public String getCategory() {
        return category;
    }

    public String getJob() {
        return job;
    }

    public ListaEnlazada<String> getCharacters() {
        return characters;
    }

    public String getImdb_title_id() {
        return imdb_title_id;
    }

    public String getImdb_name_id() {
        return imdb_name_id;
    }

    @Override
    public int compareTo(MovieCastMember o) {

        if(this.characters.getSize() > o.getCharacters().getSize()){
            return 1;
        }

        else if(this.characters.getSize() < o.getCharacters().getSize()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
