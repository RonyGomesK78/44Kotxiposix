package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{

    private Node head;
    private Node lastRemoved = null;
    private int length;

    public LinkedList (){

        this.head = new Node(null);
        length = 0;
    }

    public int size() {

        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null){

            iterator = iterator.getNext();
        }

        iterator.setNext(node);
        length++;
    }

    /**
     * Add an element array to the end of the list
     * @param data the element to add
     */
    public void add(T[] data){

        Node iterator = head;

        while (iterator.getNext() != null){

            iterator = iterator.getNext();
        }

        int size = data.length;

        for(int i = 0; i < size; i++){

            Node node = new Node(data[i]);
            iterator.setNext(node);

            length++;

            iterator = iterator.getNext();
        }
    }

    /**
     * Add an element to the specific index of the list
     * @param data the element to add
     * @param index where to add
     */
    public void add(T data, int index){

        if (index <= length){

            Node iterator = head;
            Node node = new Node(data);

            while (iterator != null && index >= 0){

                if (index == 0){

                    node.setNext(iterator.getNext());
                    iterator.setNext(node);
                }
                index--;
                iterator = iterator.getNext();
            }
            length++;
        }
    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {


        Node iterator = this.head.getNext();

        while (iterator != null){

            if (index == 0){

                return iterator.getData();
            }

            iterator = iterator.getNext();
            index--;
        }

        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {

        Node iterator = this.head;

        for (int i = 0; i < length; i++) {

            iterator = iterator.getNext();

            if (iterator.getData().equals(data)){

                return  i;
            }
        }

        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {

        Node iterator = this.head.getNext();
        /*if (iterator != null &&  data.equals(iterator.getData())){

            head.setNext(iterator.getNext());
            length--;

            return true;
        }*/
        Node followIterator = head;

        while (iterator != null){

            if (data.equals(iterator.getData())){

                followIterator.setNext(iterator.getNext());
                length--;

                lastRemoved = iterator;

                return true;
            }

            followIterator = iterator;
            iterator = iterator.getNext();
        }

        return false;
    }

    /**
     * Add the last element removed
     * @return
     */
    public boolean undoLastRemoved(){

        Node iterator = head;

        while (iterator != null){

            //System.out.println(iterator.getNext() + " : " + lastRemoved.getNext());
            if (iterator.getNext() == lastRemoved.getNext()){

                iterator.setNext(lastRemoved);
                lastRemoved = null;

                length++;

                return true;
            }

            iterator = iterator.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        Node current = head;

        @Override
        public boolean hasNext() {

            return current.getNext() != null;
        }

        @Override
        public T next() {


            if (!hasNext()){

                throw new NoSuchElementException();
            }

            current = current.getNext();

            return current.getData();
        }

        @Override
        public void remove() {

            LinkedList.this.remove(current.data);
        }


    }

    private class Node{

        private T data;
        private Node next;

        public Node(T data) {

            this.data = data;
            next = null;
        }

        public T getData() {

            return data;
        }

        public void setData(T data) {

            this.data = data;
        }

        public Node getNext() {

            return next;
        }

        public void setNext(Node next) {

            this.next = next;
        }


    }

}
