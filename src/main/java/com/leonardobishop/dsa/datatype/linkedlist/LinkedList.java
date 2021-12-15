package com.leonardobishop.dsa.datatype.linkedlist;

public interface LinkedList<E> {

    /**
     * Removes the first node in this linked list.
     */
    void removeFirst();

    /**
     * Removes the last element in this linked list.
     */
    void removeLast();

    /**
     * Removes an element at a specified index in this linked list.
     * @param index index of element to remove
     */
    void remove(int index);

    /**
     * Returns the first element in this linked list.
     * @return first element
     */
    E getFirst();

    /**
     * Returns the last element in this linked list.
     * @return last element
     */
    E getLast();

    /**
     * Returns an element at a specified index in this linked list.
     * @param index the element to remove
     * @return the element
     */
    E get(int index);

    /**
     * Returns the size of this linked list.
     * @return size
     */
    int size();

    /**
     * Inserts an element into the front this linked list.
     * @param element element to insert
     */
    void insertFirst(E element);

    /**
     * Inserts an element into the back this linked list.
     * @param element element to insert
     */
    void insertLast(E element);

    /**
     * Inserts an element into this linked list at a specified index.
     * @param element element to insert
     * @param index index of element
     */
    void insert(E element, int index);

    class Node<T> {

        private final T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

    }

}
