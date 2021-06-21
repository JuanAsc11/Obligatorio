package Entidades;

import java.util.Date;

import static Utilidades.Conversores.*;

public class CastMember {

    //ATRIBUTOS

    private String imdbNameId;

    private String Name;

    private String birthName;

    private int height;

    private String bio;

    private String birthDetails;            //No esta en el diagrama

    private int year;

    private String birthState;

    private String birthCountry;

    private String birthCity;

    private String deathDetails;            //No esta en el diagrama

    private Date deathDate;

    private String deathState;

    private String deathCountry;

    private String deathCity;

    private CauseOfDeath causeOfDeath;

    private String spousesString;

    private int spouses;

    private int divorces;

    private int spousesWithChildren;

    private int children;

    //CONSTRUCTOR

    public CastMember(String[] atributosCastMember) {

        this.imdbNameId = convertIMDB(atributosCastMember[0]);
        this.Name = atributosCastMember[1];
        this.birthName = atributosCastMember[2];
        this.height = Integer.parseInt(atributosCastMember[3]);
        this.bio = atributosCastMember[4];
        this.birthDetails = atributosCastMember[5];                     //NO esta en Diagrama
        this.year = convertToBirthYear(atributosCastMember[6]);
        this.birthState = convertState(atributosCastMember[7]);                       //Segundo elemento es el state
        this.birthCountry = atributosCastMember[7];                     //CAMBIO POR ACLARACIONES MOODLE
        this.birthCity = convertCity(atributosCastMember[7]);                        //Primer elemento es la ciudad
        this.deathDetails = atributosCastMember[8];                    //NO esta en Diagrama
        this.deathDate = convertToDate(atributosCastMember[9]);
        this.deathState = convertState(atributosCastMember[10]);                      //Segundo elemento es el state
        this.deathCountry = convertCountry(atributosCastMember[10]);                    //Ultimo elemento es el pais
        this.deathCity = convertCity(atributosCastMember[10]);                       //Primer elemento es la ciudad
        this.spousesString = atributosCastMember[12];
        this.spouses = Integer.parseInt(atributosCastMember[13]);
        this.divorces = Integer.parseInt(atributosCastMember[14]);
        this.spousesWithChildren = Integer.parseInt(atributosCastMember[15]);  //elemento 16 num children
        this.children = convertChildern(atributosCastMember[16]);
    }

    public void setCauseOfDeath(CauseOfDeath causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
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

    public int getBirthYear() {
        return year;
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
