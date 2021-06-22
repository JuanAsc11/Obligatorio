package TADs;

import TADs.Excepciones.EmptyHeapException;
import TADs.Excepciones.FullHeap;

public class HeapImpl<K extends Comparable<K>, T> {

    private HeapNode<K, T>[] Heap;
    private int maxSize;
    private int size;

    public HeapImpl(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new HeapNode[this.maxSize + 1];

    }

    private int padre(int i) { //posicion padre
        return (i - 1) / 2;
    }

    private int hijoIzq(int i) { // posicion hijo izq
        return (2 * i) + 1;
    }

    private int hijoDer(int i) {  // posicion hijo Der
        return (2 * i) + 2;
    }

    private boolean esHoja(int i) {
        return i <= size && i >= size / 2;
    }

    private void cambio(int posicion1, int posicion2) { // cambiar nodos

        HeapNode variable = Heap[posicion1];
        Heap[posicion1] = Heap[posicion2];
        Heap[posicion2] = variable;
    }

    /*private void orderMinHeap(int i){ //ordena el subarbol  heap minimo del nodo

        if(!esHoja(i)){

            if(Heap[i].getKey().compareTo(Heap[hijoIzq(i)].getKey()) > 0|| Heap[i].getKey().compareTo(Heap[hijoDer(i)].getKey()) > 0){

                if(Heap[hijoIzq(i)].getKey().compareTo(Heap[hijoDer(i)].getKey()) < 0){
                    cambio(i,hijoIzq(i));
                    orderMinHeap(hijoIzq(i));
                }

                else{
                    cambio(i, hijoDer(i));
                    orderMinHeap(hijoDer(i));
                }
            }
        }
    }*/

    /*private void orderMaxHeap(int index){ // ordenar el  subarbol heap max del nodo

        int i = index;
        int indexIzq = 2*i +1;
        int indexDer = 2*i +2;
        int mayorIndex = i;

        if(indexDer < size && Heap[indexDer].getKey().compareTo(Heap[size].getKey()) > 0){ // busco derecha
            mayorIndex = indexDer;
        }

        if (indexIzq < size && Heap[indexIzq].getKey().compareTo(Heap[size].getKey()) > 0){  // busco izq
            mayorIndex = indexIzq;
        }

        if(mayorIndex != i){ // encontro uno mayor
            cambio(i,mayorIndex);
            orderMaxHeap(mayorIndex);
        }



        /*if(esHoja(i)){
            return;
        }

        if (Heap[i].getKey().compareTo(Heap[hijoIzq(i)].getKey()) < 0 || Heap[i].getKey().compareTo(Heap[hijoDer(i)].getKey()) < 0){

            if(Heap[hijoIzq(i)].getKey().compareTo(Heap[hijoDer(i)].getKey()) > 0){
                cambio(i, hijoIzq(i));
                orderMaxHeap(hijoIzq(i));
            }

            else {
                cambio(i, hijoDer(i));
                orderMaxHeap(hijoDer(i));
            }
        }
    }*/

    /*public void borrarMax(){
        Heap[0] = Heap[size-1];
        Heap[size -1] = null;
        size -= 1;
        orderMaxHeap(0);
    }*/

    public void insertMaxHeap(K key, T data) throws FullHeap {  //insertar en heap max

        HeapNode<K,T> nuevoNodo = new HeapNode<>(key,data);

        if(size >= maxSize){
            throw new FullHeap();
        }

        int position = size;
        size++;
        Heap[position] = nuevoNodo;

        while(position != 0 && Heap[position].getKey().compareTo(Heap[padre(position)].getKey()) > 0){
            Heap[position] = Heap[padre(position)];
            Heap[padre(position)] = nuevoNodo;

            position = padre(position);
        }
    }

    public int maxPosition(int position1, int position2) {
        int valueToReturn = position1;
        if (Heap[position1] != null && Heap[position2] != null) {
            if (Heap[position2].getKey().compareTo(Heap[position1].getKey()) > 0) {
                valueToReturn = position2;
            }
        }
        if (Heap[position1] == null && Heap[position2] == null) {
            valueToReturn = -1;
        }
        // Controlar posiciones fueras del arbol
        return valueToReturn;
    }

    public int minPosition(int position1, int position2) {
        int valueToReturn = position1;
        if (Heap[position1] != null && Heap[position2] != null) {
            if (Heap[position2].getKey().compareTo(Heap[position1].getKey()) < 0) {
                valueToReturn = position2;
            }
        }
        if (Heap[position1] == null && Heap[position2] == null) {
            valueToReturn = -1;
        }
        return valueToReturn;
    }

    public T delete() throws EmptyHeapException {
        T valueToReturn = null;

        if (size == 0) {
            throw new EmptyHeapException();
        }
        valueToReturn = Heap[0].getData();

        if (size == 1) {
            Heap[0] = null;
        } else {
            int position = 0;
            Heap[position] = Heap[size - 1];

            int childMaxPosition = maxPosition(hijoIzq(position),
                    hijoDer(position));
            while (childMaxPosition == -1 && Heap[childMaxPosition].getKey().compareTo(Heap[position].getKey()) > 0) {
                Heap[position] = Heap[childMaxPosition];
                Heap[childMaxPosition] = Heap[size - 1];
                position = childMaxPosition;
                childMaxPosition = maxPosition(hijoIzq(position), hijoDer(position));
            }
            Heap[size - 1] = null;
        }

        size--;

        return valueToReturn;
    }



    /*public HeapNode popMin(){  //extraer minimo del heap
        HeapNode eliminado = Heap[0];
        Heap[0] = Heap[size--];
        orderMinHeap(0);
        return eliminado;
    }*/

    public HeapNode<K,T> getMax(){  //extraer maximo del heap
        HeapNode eliminado = null;

        if (size != 0){
            eliminado = Heap[0];
        }

        return eliminado;
    }

    /*public void minHeap(){  //ordena el array entero min heap

        for(int i = (size/2); i >= 1; i--){
            orderMinHeap(i);
        }
    }

    public void maxHeap(){  //ordena el array entero max heap

        for(int i = (size/2); i >= 1; i--){
            orderMaxHeap(i);
        }
    }*/

    public void vizualizar(){
        for(int i =1; i <= (size/2); i++){
            System.out.println("Padre :"+Heap[i] + "Hijo Izquierdo :" + Heap[(2*i)+1] + "Hijo Derecho :" + Heap[(2*i) + 2]);
            System.out.println();
        }
    }

    public int getSize(){
        return size;
    }
}
