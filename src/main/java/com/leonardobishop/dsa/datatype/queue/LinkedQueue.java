package com.leonardobishop.dsa.datatype.queue;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.linkedlist.DoublyLinkedList;
import com.leonardobishop.dsa.datatype.linkedlist.LinkedList;

/**
 * A linked list backed queue.
 * @param <E> type
 */
public final class LinkedQueue<E> implements Queue<E> {

    private final LinkedList<E> list = new DoublyLinkedList<>();

    @Override
    public void queue(E element) {
        list.insertLast(element);
    }

    @Override
    public E dequeue() {
        E first = list.getFirst();
        list.removeFirst();
        return first;
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    /**
     * Throws an exception if the size of this linked list is zero.
     */
    private void disallowEmpty() {
        if (list.size() == 0) {
            throw new EmptyException("linked list has no elements");
        }
    }

}
