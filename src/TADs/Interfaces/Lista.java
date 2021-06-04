package TADs.Interfaces;

import TADs.Implementaciones.Nodo;

public interface Lista<T> {
    void add(T value);

    void remove(int position);

    Nodo<T> get(int position);
}
