package Clases;

import java.util.Date;

public class Movie {
    private String imdbTitled;
    private String title;
    private String originalTitle;
    private int year;
    private Date datePublished;
    private MyLinkedList<String> country;
    private String language;
    private MyLinkedList<String> director;
    private MyLinkedList<String> writer;
    private String productionCompany;
    private MyLinkedList<String> actors;
    private String description;
    private float avgVote;
    private int votes;
    private String budget;
    private String usaGrossIncome;
    private String worldwideGrossIncome;
    private float metaScore;
    private float reviewsFromUsers;
    private float reviewsFromCritics;

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

    public MyLinkedList<String> getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public MyLinkedList<String> getDirector() {
        return director;
    }

    public MyLinkedList<String> getWriter() {
        return writer;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public MyLinkedList<String> getActors() {
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
