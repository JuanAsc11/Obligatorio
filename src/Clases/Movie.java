package Clases;

import TADs.Implementaciones.ListaEnlazada;

import java.util.Date;

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

    //CONSTRUCTOR

    public Movie(String imdbTitled, String title, String originalTitle, int year, Date datePublished, ListaEnlazada<String> country, String language, ListaEnlazada<String> director, ListaEnlazada<String> writer, String productionCompany, ListaEnlazada<String> actors, String description, float avgVote, int votes, String budget, String usaGrossIncome, String worldwideGrossIncome, float metaScore, float reviewsFromUsers, float reviewsFromCritics) {
        this.imdbTitled = imdbTitled;
        this.title = title;
        this.originalTitle = originalTitle;
        this.year = year;
        this.datePublished = datePublished;
        this.country = country;
        this.language = language;
        this.director = director;
        this.writer = writer;
        this.productionCompany = productionCompany;
        this.actors = actors;
        this.description = description;
        this.avgVote = avgVote;
        this.votes = votes;
        this.budget = budget;
        this.usaGrossIncome = usaGrossIncome;
        this.worldwideGrossIncome = worldwideGrossIncome;
        this.metaScore = metaScore;
        this.reviewsFromUsers = reviewsFromUsers;
        this.reviewsFromCritics = reviewsFromCritics;
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
}
