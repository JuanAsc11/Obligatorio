package Entidades;

import TADs.Implementaciones.ListaEnlazada;
import static Utilidades.Conversores.*;

public class MovieRating {

    //ATRIBUTOS

    private float weightedAverage;

    private int totalVotes;

    private float meanVote;

    private float medianVote;

    private ListaEnlazada<Integer> votesRating;

    private String imbd_title_id;

    private ListaEnlazada<Rating> allGenders;

    private ListaEnlazada<Rating> males;

    private ListaEnlazada<Rating> females;

    private Rating top1000;

    private Rating us;

    private Rating nonUs;



    //CONSTRUCTOR
    public MovieRating(String[] atributos){
        this.imbd_title_id = atributos[0].substring(atributos[0].lastIndexOf("tt"));
        this.weightedAverage = Float.parseFloat(atributos[1]);
        this.totalVotes = Integer.parseInt(atributos[2]);
        this.meanVote = Float.parseFloat(atributos[3]);
        this.medianVote = Float.parseFloat(atributos[4]);

        this.votesRating = new ListaEnlazada<>();
        for(int i = 5; i <= 14;i++){
            this.votesRating.add(controlParse(atributos[i]));
        }

        this.allGenders = new ListaEnlazada<>();
        for(int i = 15; i <= 21; i = i+2){
            this.allGenders.add(new Rating(atributos[i],atributos[i+1]));
        }

        this.males = new ListaEnlazada<>();
        for(int i = 22; i <= 31; i = i+2){
            this.males.add(new Rating(atributos[i],atributos[i+1]));
        }

        this.females = new ListaEnlazada<>();
        for(int i = 33; i<=41; i = i+2 ){
            this.females.add(new Rating(atributos[i],atributos[i+1]));
        }

        this.top1000 = new Rating(atributos[43],atributos[44]);

        this.us = new Rating(atributos[45],atributos[46]);

        this.nonUs = new Rating(atributos[47],atributos[48]);

    }


    //GETTERS

    public float getWeightedAverage() { return weightedAverage; }

    public int getTotalVotes() { return totalVotes; }

    public float getMeanVote() { return meanVote; }

    public float getMedianVote() { return medianVote; }

    public ListaEnlazada<Integer> getVotesRating() { return votesRating; }

    public String getImbd_title_id() {
        return imbd_title_id;
    }

    public ListaEnlazada<Rating> getAllGenders() {
        return allGenders;
    }

    public ListaEnlazada<Rating> getMales() {
        return males;
    }

    public ListaEnlazada<Rating> getFemales() {
        return females;
    }

    public Rating getTop1000() {
        return top1000;
    }

    public Rating getUs() {
        return us;
    }

    public Rating getNonUs() {
        return nonUs;
    }
}
