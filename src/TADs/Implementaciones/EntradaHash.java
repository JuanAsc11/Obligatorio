package TADs.Implementaciones;

public class EntradaHash<K,V>{

    private K key;
    private V data;
    private boolean borrado;

    public EntradaHash(K key, V data) {
        this.key = key;
        this.data = data;
        this.borrado = false;
    }

    public K getKey() {
        return key;
    }

    public V getData() {
        return data;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setData(V data) {
        this.data = data;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public boolean equals(Object obj) {
        boolean equalsToReturn = false;

        // no es posible hacer un instanceof con generics, esta es otra manera

        equalsToReturn = ((K) obj).equals(this.key);

        return equalsToReturn;
    }

}
