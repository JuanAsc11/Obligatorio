package TADs.Interfaces;

import TADs.Excepciones.KeyNotFound;
import TADs.Excepciones.UnavailableIndex;

public interface MyHash<K, V> {

    void put(K key, V value) throws UnavailableIndex;

    V get(K key) throws KeyNotFound;

    void delete(K key) throws KeyNotFound;

    int size();

    boolean contains(K key);
}