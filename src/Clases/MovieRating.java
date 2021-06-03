package Clases;

import TADs.Lista;
import TADs.ListaEnlazada;

public class MovieRating {

    //ATRIBUTOS

    private float weightedAverage;

    private int totalVotes;

    private float meanVote;

    private float medianVote;

    private ListaEnlazada<int> votesRating;

    //CONSTRUCTOR

    public MovieRating(float weightedAverage, int totalVotes, float meanVote, float medianVote, ListaEnlazada<int> votesRating) {
        this.weightedAverage = weightedAverage;
        this.totalVotes = totalVotes;
        this.meanVote = meanVote;
        this.medianVote = medianVote;
        this.votesRating = votesRating;
    }

    //GETTERS

    public float getWeightedAverage() { return weightedAverage; }

    public int getTotalVotes() { return totalVotes; }

    public float getMeanVote() { return meanVote; }

    public float getMedianVote() { return medianVote; }

    public ListaEnlazada<int> getVotesRating() { return votesRating; }
}
