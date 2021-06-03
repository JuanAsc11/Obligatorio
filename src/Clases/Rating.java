package Clases;

public class Rating {

    //ATRIBUTOS

    private float NumberVotes;
    private float AverageRating;

    //CONSTRUCTOR

    public Rating(float numberVotes, float averageRating) {
        NumberVotes = numberVotes;
        AverageRating = averageRating;
    }

    //GETTERS

    public float getNumberVotes() {
        return NumberVotes;
    }

    public float getAverageRating() {
        return AverageRating;
    }
}
