package TADs.Implementaciones;

import TADs.Interfaces.Lista;

public class ListaEnlazada<T> implements Lista<T> {

    public Nodo<T> primerNodo;
    public Nodo<T> finalNodo;
    private int size;

    public ListaEnlazada(){
        this.primerNodo = null;
        this.finalNodo = null;
        this.size = 0;
    }

    @Override
    public void add(T value){
        Nodo<T> nuevoNodo = new Nodo<T>(value);

        if(primerNodo == null){
            primerNodo = nuevoNodo;
        }
        else{
            finalNodo.setNextValue(nuevoNodo);
        }
        finalNodo = nuevoNodo;
        size++;
    }

    @Override
    public void remove(int position){
        Nodo<T> nodoAnterior = primerNodo;
        Nodo<T> nodoSiguiente = primerNodo;
        for(int i =1; i<=position-2;i++){
            nodoAnterior = nodoAnterior.getNextValue();
        }
        for(int i =1; i<=position;i++){
            nodoSiguiente = nodoSiguiente.getNextValue();
        }
        if(nodoSiguiente == null){
            nodoAnterior.setNextValue(null);
        }
        else{
            nodoAnterior.setNextValue(nodoSiguiente);
        }
        size--;
    }

    @Override
    public Nodo<T> get(int position) {
        Nodo<T> nodoPresente = primerNodo;
        for(int i =1; i<=position-1;i++){
            nodoPresente = nodoPresente.getNextValue();
        }
        if(nodoPresente == null){
            nodoPresente = primerNodo;
            for(int i =1; i<=position-2;i++){
                nodoPresente = nodoPresente.getNextValue();
            }
        }
        return nodoPresente;
    }

    public void addFirst(T value){
        if(primerNodo == null){
            primerNodo = new Nodo<T>(value);
        }
        else{
            Nodo<T> nuevoNodo = new Nodo<T>(value);
            nuevoNodo.setNextValue(primerNodo);
            primerNodo = nuevoNodo;
        }
        size++;
    }

    public void addLast(T value){
        add(value);
    }

    public int getSize() {
        return size;
    }

    public Nodo<T> getPrimerNodo() {
        return primerNodo;
    }

    public boolean contains(T value){
        boolean encontre = false;
        Nodo<T> nodoBuscado = primerNodo;

        while(nodoBuscado != null){
            if(nodoBuscado.getValue().equals(value)){
                encontre = true;
                break;
            }
            nodoBuscado = nodoBuscado.getNextValue();
        }
        return encontre;
    }
}


