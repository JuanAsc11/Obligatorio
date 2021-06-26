package Entidades;

public class Genre {

    private String nombre;

    private int cantidad = 1;

    public Genre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void addCantidad() {
        this.cantidad++;
    }
}
