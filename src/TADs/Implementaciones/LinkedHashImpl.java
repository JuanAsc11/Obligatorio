package TADs.Implementaciones;

import TADs.Excepciones.KeyNotFound;
import TADs.Interfaces.HashTable;
import TADs.Implementaciones.LinkedHashNode;
import TADs.Interfaces.Lista;

public class LinkedHashImpl<K extends Comparable<K>,V> implements HashTable<K,V> {

    private ListaEnlazada<EntradaHash<K,V>>[] array;  //Hash Table

    private int capacity;  //cantidad maxima

    //GETTERS
    public int getCapacity() {
        return capacity;
    }

    //SETTERS

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //CONTRUCTOR

    public LinkedHashImpl(int capacity) {
        this.capacity = capacity;
        this.array = new ListaEnlazada[capacity];
    }

    //IMPL

    private int getHashIndex(K key){  //Genera un index a partir del hash code para insertar

        int codigoHash = key.hashCode();

        int index = codigoHash % array.length;

        /*if(index < 0){
             return index * (-1);
        }
        else{
            return index;
        }*/

        return index;
    }

    @Override
    public void put(K key, V value) {
        int index = getHashIndex(key);

        ListaEnlazada<EntradaHash<K,V>> posicionLista = array[index];
        //si no existe una lista en posicion
        if(posicionLista == null){
            ListaEnlazada<EntradaHash<K,V>> nuevaLista = new ListaEnlazada<>();
            nuevaLista.add(new EntradaHash<>(key,value));
            array[index] = nuevaLista;
        }
        else {
            posicionLista.add(new EntradaHash<>(key, value));  //No tiene en cuenta objetos identicos
        }
    }

    @Override
    public boolean contains(K key) {
        int postion = getHashIndex(key);
        boolean encontre = false;

        ListaEnlazada<EntradaHash<K,V>> listaActual = array[postion];

        if(listaActual != null){  //buscamos si existe la key
            for(int i = 0; i < listaActual.getSize(); i++){
                if(listaActual.get(i).getValue().equals(key)){
                    encontre = true;
                    break;
                }
            }
        }
        return encontre;
    }


    public V get(K key){
        int postion = getHashIndex(key);
        V returnData = null;

        ListaEnlazada<EntradaHash<K,V>> listaActual = array[postion];

        if(listaActual != null){
            for(int i = 0; i < listaActual.getSize(); i++){
                if(listaActual.get(i).getValue().equals(key)){
                        returnData = listaActual.get(i).getValue().getData();
                        break;
                }
            }
        }
        return returnData;
    }

    @Override
    public void remove(K clave) throws KeyNotFound {

        int index = getHashIndex(clave);

        ListaEnlazada<EntradaHash<K,V>> listaActual = array[index];

        int lugar = 0;
        boolean encontre =false;

        if(listaActual != null){
            for(int i = 0; i < listaActual.getSize(); i++){
                lugar++;
                if(listaActual.get(i).getValue().equals(clave)){
                    encontre = true;
                    break;
                }
            }
        }

        if (!encontre){
            throw new KeyNotFound();
        }
        else {
            listaActual.remove(lugar);
        }
    }
}
