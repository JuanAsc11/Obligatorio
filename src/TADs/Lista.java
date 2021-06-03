package TADs;

public interface Lista<T> {

    void add(T value);


    public void remove(int position);


    public Nodo<T> get(int position);
}
