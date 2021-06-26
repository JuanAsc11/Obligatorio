package Entidades;

public class CauseOfDeath {

    //ATRIBUTOS

    private String name;

    private int cantidad = 1;

    //CONSTRUCTOR

    public CauseOfDeath(String name) {
        this.name = name;
    }

    //GETTERS

    public String getName() {
        return name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void addCantidad() {
        this.cantidad++;
    }
}
