package com.leonardobishop.dsa.datatype.queue;

public interface Queue<E> {

    /**
     * Inserts an element at the end of the queue.
     * @param element element to insert
     */
    void queue(E element);

    /**
     * Returns and removes element from the front of the queue.
     * @return the first element
     */
    E dequeue();

    /**
     * Returns the element at the front of the queue.
     * @return element at front of queue
     */
    E peek();

    /**
     * Returns the size of the queue.
     * @return size of queue
     */
    int size();

}
