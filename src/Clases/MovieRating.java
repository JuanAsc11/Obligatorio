package Clases;

public class MovieRating {
    private float weightedAverage;
    private int totalVotes;
    private float meanVote;
    private float medianVote;
    private MyLinkedList<int> votesRating;

    public float getWeightedAverage() {
        return weightedAverage;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public float getMeanVote() {
        return meanVote;
    }

    public float getMedianVote() {
        return medianVote;
    }

    public MyLinkedList<int> getVotesRating() {
        return votesRating;
    }
}
