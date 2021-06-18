package Clases;

import static Conversores.Conversores.*;

public class Rating {

    //ATRIBUTOS

    private float numberVotes;
    private float averageRating;

    //CONSTRUCTOR

    public Rating(String numberVotes, String averageRating) {
        this.numberVotes = controlFloat(numberVotes);
        this.averageRating = controlFloat(averageRating);
    }

    //GETTERS

    public float getNumberVotes() {
        return numberVotes;
    }

    public float getAverageRating() {
        return averageRating;
    }
}
