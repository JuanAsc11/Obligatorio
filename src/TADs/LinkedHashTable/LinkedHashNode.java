package TADs.LinkedHashTable;

public class LinkedHashNode<K,V> {

    private K key;

    private V data;

    private LinkedHashNode<K,V> nextNode;

    public K getKey() {
        return key;
    }

    public V getData() {
        return data;
    }

    public LinkedHashNode<K, V> getNextNode() {
        return nextNode;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setData(V data) {
        this.data = data;
    }

    public void setNextNode(LinkedHashNode<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public LinkedHashNode(K key, V data){
        this.key = key;
        this.data = data;
        this.nextNode = null;
    }
}
