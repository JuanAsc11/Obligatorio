package Entidades;

public class Year{

    private int year;

    private int cantidad;

    public Year(int year){
        this.year = year;
        this.cantidad = 1;
    }

    public int getYear() {
        return year;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addCantidad() {
        this.cantidad++;
    }

    public boolean equals(Year obj) {
        boolean equalsToReturn = false;

        // no es posible hacer un instanceof con generics, esta es otra manera

        equalsToReturn = (obj.year) ==(this.year);

        return equalsToReturn;
    }
}
