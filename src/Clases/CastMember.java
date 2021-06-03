package Clases;

import java.util.Date;

public class CastMember {

    //ATRIBUTOS

    private String imdbNameId;

    private String Name;

    private String birthName;

    private int height;

    private String bio;

    private Date birthDate;

    private String birthState;

    private String birthCountry;

    private String birthCity;

    private Date deathDate;

    private String deathState;

    private String deathCountry;

    private String deathCity;

    private String spousesString;

    private int spouses;

    private int divorces;

    private int spousesWithChildren;

    private int children;

    //CONSTRUCTOR

    public CastMember(String imdbNameId, String name, String birthName, int height, String bio,
                      Date birthDate, String birthState, String birthCountry, String birthCity, Date deathDate,
                      String deathState, String deathCountry, String deathCity, String spousesString, int spouses,
                      int divorces, int spousesWithChildren, int children) {

        this.imdbNameId = imdbNameId;
        Name = name;
        this.birthName = birthName;
        this.height = height;
        this.bio = bio;
        this.birthDate = birthDate;
        this.birthState = birthState;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.deathDate = deathDate;
        this.deathState = deathState;
        this.deathCountry = deathCountry;
        this.deathCity = deathCity;
        this.spousesString = spousesString;
        this.spouses = spouses;
        this.divorces = divorces;
        this.spousesWithChildren = spousesWithChildren;
        this.children = children;
    }

    //GETTERS

    public String getImdbNameId() {
        return imdbNameId;
    }

    public String getName() {
        return Name;
    }

    public String getBirthName() {
        return birthName;
    }

    public int getHeight() {
        return height;
    }

    public String getBio() {
        return bio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthState() {
        return birthState;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public String getDeathState() {
        return deathState;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public String getSpousesString() {
        return spousesString;
    }

    public int getSpouses() {
        return spouses;
    }

    public int getDivorces() {
        return divorces;
    }

    public int getSpousesWithChildren() {
        return spousesWithChildren;
    }

    public int getChildren() {
        return children;
    }
}
