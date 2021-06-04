package TADs.Implementaciones;

import TADs.Excepciones.EmptyQueueException;
import TADs.Interfaces.BST;
import TADs.Interfaces.MyQueue;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

    private TreeNode<T> root;

    @Override
    public void insert(T value) {
        root = insert(value, root);
    }

    private TreeNode<T> insert(T value, TreeNode<T> subTree) {
        TreeNode<T> elementToAdd = new TreeNode<>(value);

        if (subTree == null) {
            return elementToAdd;
        } else {

            if (value.compareTo(subTree.getValue()) > 0) { // eq value > root.getValue()

                TreeNode<T> newRight = insert(value, subTree.getRight());
                subTree.setRight(newRight);

                return subTree;

            } else if (value.compareTo(subTree.getValue()) < 0) {
                TreeNode<T> newLeft = insert(value, subTree.getLeft());
                subTree.setLeft(newLeft);

                return subTree;
            }

        }
        return null;
    }

    @Override
    public void delete(T value) {
        if (root != null) {
            root = delete(value, root);
        }
    }
    private TreeNode<T> delete(T value, TreeNode<T> subTree) {
        TreeNode<T> returnTree = subTree;
        if (subTree.getValue().compareTo(value) == 0) {
            if (subTree.getLeft() == null && subTree.getRight() == null) {
                returnTree = null;
            }
            else if (subTree.getLeft() == null) {
                returnTree = subTree.getRight();
            }
            else if (subTree.getRight() == null) {
                returnTree = subTree.getLeft();
            }
            else {
                TreeNode<T> candidato = subTree.getRight();
                while(candidato.getLeft()!=null){
                    candidato = candidato.getLeft();
                }
                subTree.setValue(candidato.getValue());
                subTree.setRight(delete(candidato.getValue(),subTree.getRight()));
                returnTree = subTree;
            }
        }
        else if (subTree.getValue().compareTo(value) > 0){          //subTree.getValue() > value
            if (subTree.getLeft() != null) {
                subTree.setLeft(delete(value, subTree.getLeft()));
            }
        }
        else if (subTree.getValue().compareTo(value) < 0) {         //subTree.getValue() < value
            if (subTree.getRight() != null) {
                subTree.setRight(delete(value, subTree.getRight()));
            }
        }
        else {
            returnTree = null;
        }
        return returnTree;
    }


    @Override
    public boolean exists(T value) {

        return exists(value, root);
    }

    private boolean exists(T value, TreeNode<T> subTree) {
        boolean exists = false;

        if (subTree != null) {

            if (value.compareTo(subTree.getValue()) == 0) {

                exists = true;

            } else if (value.compareTo(subTree.getValue()) > 0) {

                exists = exists(value, subTree.getRight());

            } else {
                exists = exists(value, subTree.getLeft());
            }

        }

        return exists;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode<T> subTree){
        if (subTree==null){
            return 0;
        }
        else{
            return(size(subTree.getRight())+1+size(subTree.getLeft()));
        }
    }

    @Override
    public int countLeaf() {
        return countLeaf(root);
    }

    private int countLeaf(TreeNode<T> subTree){
        if (subTree == null){
            return 0;
        }
        else if(subTree.getLeft() == null &&  subTree.getRight() == null){
            return 1;
        }
        else{
            return(countLeaf(subTree.getLeft())+countLeaf(subTree.getRight()));
        }
    }

    @Override
    public int countCompleteElements() {
        return countCompleteElements(root);
    }

    private int countCompleteElements(TreeNode<T> subTree){
        if(subTree==null){
            return 0;
        }

        int resultado = 0;

        if(subTree.getLeft() != null &&  subTree.getRight() != null){
            resultado ++;
        }

        resultado += countCompleteElements(subTree.getRight()) + countCompleteElements(subTree.getLeft());

        return resultado;
    }




    public List<T> traversePreOrder() {
        List<T> listToReturn = new ArrayList<>();

        if (root != null) {
            traversePreOrder(this.root, listToReturn);
        }

        return listToReturn;
    }

    private void traversePreOrder(TreeNode<T> root, List<T> result) {
        result.add(root.getValue());

        if (root.getLeft() != null) {
            traversePreOrder(root.getLeft(), result);
        }

        if (root.getRight() != null) {
            traversePreOrder(root.getRight(), result);
        }
    }

    public List<T> postOrder() {
        List<T> listToReturn = new ArrayList<>();

        if (root != null) {
            postOrder(this.root, listToReturn);
        }

        return listToReturn;
    }

    private void postOrder(TreeNode<T> root, List<T> result) {


        if (root.getLeft() != null) {
            postOrder(root.getLeft(), result);
        }


        if (root.getRight() != null) {
            postOrder(root.getRight(), result);
        }

        result.add(root.getValue());

    }

    public List<T> inOrder() {
        List<T> listToReturn = new ArrayList<>();

        if (root != null) {
            inOrder(this.root, listToReturn);
        }

        return listToReturn;
    }

    private void inOrder(TreeNode<T> root, List<T> result) {


        if (root.getLeft() != null) {
            inOrder(root.getLeft(), result);
        }

        result.add(root.getValue());

        if (root.getRight() != null) {
            inOrder(root.getRight(), result);
        }

    }

    public List<T> porNivel() throws EmptyQueueException {
        List<T> listToReturn = new ArrayList<>();
        MyQueue<TreeNode<T>> cola = new LinkedListQueue<>();

        if (root != null) {
            cola.enqueue(this.root);
            while(!cola.isEmpty()){
                TreeNode<T> elemento = cola.dequeue();
                listToReturn.add(elemento.getValue());
                if(elemento.getLeft() != null){
                    cola.enqueue(elemento.getLeft());
                }
                if(elemento.getRight() != null){
                    cola.enqueue(elemento.getRight());
                }
            }
        }

        return listToReturn;
    }


}
