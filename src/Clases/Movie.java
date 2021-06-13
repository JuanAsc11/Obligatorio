package Clases;

import TADs.Implementaciones.ListaEnlazada;
import TADs.Interfaces.Lista;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public Movie(String[] atributos){
        this.imdbTitled = atributos[0];
        this.title = atributos[1];
        this.originalTitle = atributos[2];
        this.year = Integer.parseInt(atributos[3]);
        this.datePublished = convertToDate(atributos[4]);
        this.genre = convertToVarios(atributos[5]);             //Estos atributos no estaban en el diagrama
        this.duration = Integer.parseInt(atributos[6]);
        this.country = convertToVarios(atributos[7]);
        this.language = convertToVarios(atributos[8]);          //Hay Movies con varios idiomas pero el type es String
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
        this.metaScore = Float.parseFloat(atributos[19]);
        this.reviewsFromUsers = Float.parseFloat(atributos[20]);
        this.reviewsFromCritics = Float.parseFloat(atributos[21]);
    }

    //CONVERSORES

    public static ListaEnlazada<String> convertToVarios(String elementos) {
        ListaEnlazada<String> List = new ListaEnlazada<>();
        //Dividir elementos por "," y add a List
        return List;
    }

    public static Date convertToDate(String dates){
        Date date = null;
        if(dates == null ) {
            return null;
        }
        while (date ==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                format.setLenient(false);
                date = format.parse(dates);
            } catch (ParseException e) {
                // try other formats
            }
            if (date != null) {
                break;
            }
            format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                format.setLenient(false);
                date = format.parse(dates);
            } catch (ParseException e) {
                // try other formats
            }
            if (date != null) {
                break;
            }
            format = new SimpleDateFormat("yyyy");
            try {
                format.setLenient(false);
                date = format.parse(dates);
            } catch (ParseException e) {
                // try other formats
            }
            if (date != null) {
                break;
            }
        }
        return date;
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
