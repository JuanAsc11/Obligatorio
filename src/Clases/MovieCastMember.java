package Clases;

import TADs.ListaEnlazada;

public class MovieCastMember {

    //ATRIBUTOS

    private int ordering;

    private String Category;

    private String job;

    private ListaEnlazada<String> characters;

    //CONSTRUCTOR

    public MovieCastMember(int ordering, String category, String job, ListaEnlazada<String> characters) {
        this.ordering = ordering;
        Category = category;
        this.job = job;
        this.characters = characters;
    }

    //GETTERS

    public int getOrdering() {
        return ordering;
    }

    public String getCategory() {
        return Category;
    }

    public String getJob() {
        return job;
    }

    public ListaEnlazada<String> getCharacters() {
        return characters;
    }
}
