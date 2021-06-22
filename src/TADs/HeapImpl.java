package TADs;

public class HeapImpl<K extends Comparable<K>, T>{

    private HeapNode<K,T>[] Heap;
    private int maxSize;
    private int size;

    public HeapImpl(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new HeapNode[this.maxSize + 1];

    }

    private int padre(int i){ //posicion padre
        return (i-1)/2;
    }
    private int hijoIzq(int i){ // posicion hijo izq
        return (2*i)+1;
    }
    private int hijoDer(int i){  // posicion hijo Der
        return (2*i)+2;
    }

    private boolean esHoja(int i){
        return i <= size && i >= size / 2;
    }

    private void cambio(int posicion1, int posicion2){ // cambiar nodos

        HeapNode variable = Heap[posicion1];
        Heap[posicion1] = Heap[posicion2];
        Heap[posicion2] = variable;
    }

    private void orderMinHeap(int i){ //ordena el subarbol  heap minimo del nodo

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
    }

    private void orderMaxHeap(int index){ // ordenar el  subarbol heap max del nodo

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
        }*/
    }

    public void borrarMax(){
        Heap[0] = Heap[size-1];
        Heap[size -1] = null;
        size -= 1;
        orderMaxHeap(0);
    }

    public void insertMaxHeap(K key, T data){  //insertar en heap max
        if(size >= maxSize){
            return;
        }

        HeapNode newNode = new HeapNode(key,data);

        if (size == 0){
            Heap[0] = newNode;
        }
        else {
            Heap[++size] = newNode;
        }

        int actual = size;

        while(Heap[actual].getKey().compareTo(Heap[padre(actual)].getKey()) > 0){
            cambio(actual, padre(actual));
            actual = padre(actual);
        }
    }

    public void insertMinHeap(int key, String data){  //insertar en heap min
        if (size >= maxSize){
            return;
        }

        HeapNode newNode = new HeapNode(key, data);

        Heap[++size] = newNode;
        int actual = size;

        while(Heap[actual].getKey().compareTo(Heap[padre(actual)].getKey()) < 0){
            cambio(actual, padre(actual));
            actual = padre(actual);
        }
    }

    public HeapNode popMin(){  //extraer minimo del heap
        HeapNode eliminado = Heap[0];
        Heap[0] = Heap[size--];
        orderMinHeap(0);
        return eliminado;
    }

    public HeapNode<K,T> getMax(){  //extraer maximo del heap
        HeapNode eliminado = null;

        if (size != 0){
            eliminado = Heap[0];
        }

        return eliminado;
    }

    public void minHeap(){  //ordena el array entero min heap

        for(int i = (size/2); i >= 1; i--){
            orderMinHeap(i);
        }
    }

    public void maxHeap(){  //ordena el array entero max heap

        for(int i = (size/2); i >= 1; i--){
            orderMaxHeap(i);
        }
    }

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
