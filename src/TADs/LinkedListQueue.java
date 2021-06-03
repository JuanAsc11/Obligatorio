package TADs;

import java.util.ArrayList;

public class LinkedListQueue<T> extends ListaEnlazada implements MyQueue<T> {

    int tiempoDemora = 0;

    @Override
    public void enqueue(T element) {
        add((Comparable) element);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        T valorSacado = null;
        Nodo newfirst = null;
        newfirst.setValue(first.getNextValue().getValue());
        newfirst.setNextValue(first.getNextValue().getNextValue());
        first.getNextValue().setNextValue(null);
        first.setNextValue(null);
        valorSacado = (T) first.getValue();
        first = newfirst;
        return valorSacado;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        boolean resultado = false;
        if (size() == 0){
            resultado = true;}
        return resultado;
    }
}
