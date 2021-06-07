package TADs.Implementaciones;

import TADs.Excepciones.KeyNotFound;
import TADs.Interfaces.HashTable;
import TADs.Implementaciones.LinkedHashNode;

public class LinkedHashImpl<K extends Comparable<K>,V> implements HashTable<K,V> {

    private LinkedHashNode<K,V>[] array;  //Hash Table

    private int capacity;  //cantidad maxima

    private int size;  //cantidad de ocupados

    private float loadFactor; // porcentaje lleno

    //GETTERS

    public LinkedHashNode<K, V>[] getArray() {
        return array;
    }
    public int getCapacity() {
        return capacity;
    }
    public float getLoadFactor() {
        return loadFactor;
    }
    public int getSize() {
        return size;
    }

    //SETTERS

    public void setArray(LinkedHashNode<K,V>[] array) {
        this.array = array;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setLoadFactor(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    //CONTRUCTOR

    public LinkedHashImpl(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.array = new LinkedHashNode[capacity];
        this.size = 0; // cantidad llenos
    }

    //IMPL

    private int getHashIndex(K key){  //Genera un index a partir del hash code para insertar

        int codigoHash = key.hashCode();

        int index = codigoHash % capacity;

        if(index < 0){
             return index * (-1);
        }
        else{
            return index;
        }
    }

    public LinkedHashNode<K,V> findNode(K key){

        int index = getHashIndex(key);

        LinkedHashNode<K,V> actualNode = array[index];

        while(actualNode != null){
            if(actualNode.getKey().compareTo(key) == 0){
                return actualNode;

            }
            actualNode = actualNode.getNextNode();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int index = getHashIndex(key);

        LinkedHashNode<K,V> actualNode = array[index];

        if(actualNode == null){
            LinkedHashNode<K,V> newNode = new LinkedHashNode<>(key, value);
            array[index] = newNode;
            size ++;
        }
        else{
            while(actualNode.getNextNode() != null){
                actualNode = actualNode.getNextNode();
            }
            LinkedHashNode<K,V> newNode = new LinkedHashNode<>(key, value);
            actualNode.setNextNode(newNode);
        }

        if((1.0*size)/capacity >= loadFactor){ //si pasa la carga especificada como porcentaje lleno del array
            LinkedHashNode<K,V>[] var = array;
            array = new LinkedHashNode[2*capacity];
            size = 0;

            for(LinkedHashNode<K,V> node : var){
                while(node != null){
                    put(node.getKey(), node.getData());
                    node = node.getNextNode();
                }
            }
        }

    }

    @Override
    public boolean contains(K key) {
        int index = getHashIndex(key);

        LinkedHashNode<K,V> actualNode = array[index];

        while(actualNode != null){
            if(actualNode.getKey().compareTo(key) == 0){
                return true;

            }
            actualNode = actualNode.getNextNode();
        }
        return false;
    }

    @Override
    public void remove(K clave) throws KeyNotFound {

        int index = getHashIndex(clave);

        LinkedHashNode<K,V> actualNode = array[index];

        LinkedHashNode<K,V> prevNode = null;

        while(actualNode != null){
            if (actualNode.getKey().compareTo(clave) == 0){
                break;
            }
            prevNode = actualNode;
            actualNode = actualNode.getNextNode();
        }

        if (actualNode == null){
            throw new KeyNotFound();
        }

        if(prevNode != null){
            prevNode.setNextNode(actualNode.getNextNode());
            size--;
        }
        else {
            array[index] = actualNode.getNextNode();
            size--;
        }
    }
}
