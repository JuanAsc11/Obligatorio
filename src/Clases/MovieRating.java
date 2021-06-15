package Clases;

import TADs.Implementaciones.ListaEnlazada;

public class MovieRating {

    //ATRIBUTOS

    private float weightedAverage;

    private int totalVotes;

    private float meanVote;

    private float medianVote;

    private ListaEnlazada<Integer> votesRating;

    private String imbd_title_id;

    //CONSTRUCTOR

    public MovieRating(float weightedAverage, int totalVotes, float meanVote, float medianVote, ListaEnlazada<Integer> votesRating) {
        this.weightedAverage = weightedAverage;
        this.totalVotes = totalVotes;
        this.meanVote = meanVote;
        this.medianVote = medianVote;
        this.votesRating = votesRating;
    }

    public MovieRating(String[] atributos){
        this.imbd_title_id = atributos[0];
        this.weightedAverage = Float.parseFloat(atributos[1]);
        this.totalVotes = Integer.parseInt(atributos[2]);
        this.meanVote = Float.parseFloat(atributos[3]);
        this.medianVote = Float.parseFloat(atributos[4]);
        this.votesRating = null;
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
}
