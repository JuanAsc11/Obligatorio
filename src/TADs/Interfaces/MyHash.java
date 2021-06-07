package TADs.Interfaces;

import TADs.Excepciones.KeyNotFound;

public interface MyHash<K, V> {

    void put(K key, V value);

    V get(K key) throws KeyNotFound;

    void delete(K key) throws KeyNotFound;

    int size();

    boolean contains(K key);
}