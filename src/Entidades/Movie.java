package Entidades;

import TADs.Implementaciones.ListaEnlazada;

import java.util.Date;

import static Utilidades.Conversores.convertToDate;
import static Utilidades.Conversores.convertToVarios;

public class Movie {

    //ATRIBUTOS

    private String imdbTitled;

    private String title;

    private String originalTitle;

    private int year;

    private Date datePublished;

    private ListaEnlazada<String> country;

    private String language;

    private ListaEnlazada<String> director;

    private ListaEnlazada<String> writer;

    private String productionCompany;

    private ListaEnlazada<String> actors;

    private String description;

    private float avgVote;

    private int votes;

    private String budget;

    private String usaGrossIncome;

    private String worldwideGrossIncome;

    private float metaScore;

    private float reviewsFromUsers;

    private float reviewsFromCritics;

    private int duration;

    private ListaEnlazada<String> genre;

    //CONSTRUCTOR

    public Movie(String[] atributos){
        this.imdbTitled = atributos[0];
        this.title = atributos[1];
        this.originalTitle = atributos[2];
        this.year = Integer.parseInt(atributos[3]);
        this.datePublished = convertToDate(atributos[4]);
        this.genre = convertToVarios(atributos[5]);             //Estos atributos no estaban en el diagrama
        this.duration = Integer.parseInt(atributos[6]);
        this.country = convertToVarios(atributos[7]);
        this.language = atributos[8];          //Hay Movies con varios idiomas pero el type es String
        this.director = convertToVarios(atributos[9]);
        this.writer = convertToVarios(atributos[10]);
        this.productionCompany = atributos[11];
        this.actors = convertToVarios(atributos[12]);
        this.description = atributos[13];
        this.avgVote = Float.parseFloat(atributos[14]);
        this.votes = Integer.parseInt(atributos[15]);
        this.budget = atributos[16];
        this.usaGrossIncome = atributos[17];
        this.worldwideGrossIncome = atributos[18];

        if (atributos[19].equals("")){
            this.metaScore = 0;
        }
        else{
            this.metaScore = Float.parseFloat(atributos[19]);
        }

        if(atributos[20].equals("")){
            this.reviewsFromUsers = 0;
        }
        else{
            this.reviewsFromUsers = Float.parseFloat(atributos[20]);
        }

        if(atributos[21].equals("")){
            this.reviewsFromCritics = 0;
        }
        else{
            this.reviewsFromCritics = Float.parseFloat(atributos[21]);
        }
    }

    //GETTERS

    public String getImdbTitled() {
        return imdbTitled;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int getYear() {
        return year;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public ListaEnlazada<String> getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public ListaEnlazada<String> getDirector() {
        return director;
    }

    public ListaEnlazada<String> getWriter() {
        return writer;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public ListaEnlazada<String> getActors() {
        return actors;
    }

    public String getDescription() {
        return description;
    }

    public float getAvgVote() {
        return avgVote;
    }

    public int getVotes() {
        return votes;
    }

    public String getBudget() {
        return budget;
    }

    public String getUsaGrossIncome() {
        return usaGrossIncome;
    }

    public String getWorldwideGrossIncome() {
        return worldwideGrossIncome;
    }

    public float getMetaScore() {
        return metaScore;
    }

    public float getReviewsFromUsers() {
        return reviewsFromUsers;
    }

    public float getReviewsFromCritics() {
        return reviewsFromCritics;
    }

    public int getDuration() { return duration; }

    public ListaEnlazada<String> getGenre() { return genre; }
}
