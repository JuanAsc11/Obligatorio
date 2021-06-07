package TADs.Implementaciones;

import TADs.Interfaces.MyHash;
import TADs.Excepciones.KeyNotFound;
import TADs.Implementaciones.ClosedHashNode;

public class MyClosedHashImpl<K extends Comparable<K>, V> implements MyHash<K, V> {

    private static final int DEFAULT_INITIAL_TABLE_HASH_SIZE = 10;

    private ClosedHashNode<K,V>[] tableHash;

    private int size;

    public MyClosedHashImpl() {
        tableHash = new ClosedHashNode[DEFAULT_INITIAL_TABLE_HASH_SIZE];
    }

    public MyClosedHashImpl(int tableHashSize, float loadFactor) {
        tableHash = new ClosedHashNode[tableHashSize];
    }


    //IMPL

    private int getHashIndex(K key){  //Genera un index a partir del hash code para insertar

        int codigoHash = key.hashCode();

        int index = codigoHash % tableHash.length;

        if(index < 0){
            return index * (-1);
        }
        else{
            return index;
        }
    }

    private int getNewHashIndex(int index){     //  A COMPLETAR: Nuevo Indice cuando hay colision
        return 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getHashIndex(key);

        ClosedHashNode<K,V> actualNode = tableHash[index];

        while (actualNode != null) {
            index = getNewHashIndex(index);
            actualNode = tableHash[index];
        }

        ClosedHashNode<K,V> newNode = new ClosedHashNode<>(key, value);
        tableHash[index] = newNode;
        size ++;
    }

    @Override
    public V get(K key) throws KeyNotFound {
        int index = getHashIndex(key);
        ClosedHashNode<K,V> actualNode = tableHash[index];

        if (actualNode==null) {
            throw new KeyNotFound();
        }

        while(true) {
            if (actualNode.getKey().compareTo(key)==0){
                break;
            }
            else {
                index = getNewHashIndex(index);
                actualNode = tableHash[index];
                if (actualNode==null) {
                    throw new KeyNotFound();
                }
            }
        }
        return actualNode.getValue();
    }

    @Override
    public void delete(K key) throws KeyNotFound {
        int index = getHashIndex(key);
        ClosedHashNode<K,V> actualNode = tableHash[index];

        if (actualNode==null) {
            throw new KeyNotFound();
        }

        while(actualNode!=null) {
            if (actualNode.getKey().compareTo(key)==0){
                actualNode = null;
                size --;
            }
            else {
            index = getNewHashIndex(index);
            actualNode = tableHash[index];
            if (actualNode==null) {
                throw new KeyNotFound();
            }
            }
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        int index = getHashIndex(key);
        ClosedHashNode<K,V> actualNode = tableHash[index];

        if (actualNode==null) {
            return false;
        }

        while(true) {
            if (actualNode.getKey().compareTo(key)==0){
                return true;
            }
            else {
                index = getNewHashIndex(index);
                actualNode = tableHash[index];
                if (actualNode==null) {
                    return false;
                }
            }
        }
    }
}