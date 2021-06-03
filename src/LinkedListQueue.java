import Exceptions.EmptyQueueException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.LinkedList;

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

    public void addClient (Cliente client){
        tiempoDemora += client.getSegundosAdemorar();
        enqueue((T) client);
    }

    public int getTiempoDemora() {
        return tiempoDemora;
    }

    public static void main(String[] args) {
        ArrayList <Cliente>  Clientes = new ArrayList();
        ArrayList <LinkedListQueue> Colas = new ArrayList();
        LinkedListQueue cola1 = new LinkedListQueue();
        Colas.add(cola1);
        LinkedListQueue cola2 = new LinkedListQueue();
        Colas.add(cola2);
        LinkedListQueue cola3 = new LinkedListQueue();
        Colas.add(cola3);
        Cliente cliente1 = new Cliente(5);
        Clientes.add(cliente1);
        Cliente cliente2 = new Cliente(35);
        Clientes.add(cliente2);
        Cliente cliente3 = new Cliente(45);
        Clientes.add(cliente3);
        Cliente cliente4 = new Cliente(21);
        Clientes.add(cliente4);
        Cliente cliente5 = new Cliente(14);
        Clientes.add(cliente5);
        LinkedListQueue colaBuena;
        for (int i = 0; i < Clientes.size(); i++){
            colaBuena = cola1;
            for (int j = 1; j < Colas.size(); j++){
                if (Colas.get(j).getTiempoDemora() < colaBuena.getTiempoDemora()){
                    colaBuena = Colas.get(j);
                }
            colaBuena.addClient(Clientes.get(j));
            }
        }

    }
}
