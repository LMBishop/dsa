package com.leonardobishop.dsa.datatype.stack;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.linkedlist.DoublyLinkedList;
import com.leonardobishop.dsa.datatype.linkedlist.LinkedList;

/**
 * A linked list backed stack.
 * @param <E> type
 */
public final class LinkedStack<E> implements Stack<E> {

    private final LinkedList<E> list = new DoublyLinkedList<>();

    @Override
    public void push(E element) {
        list.insertFirst(element);
    }

    @Override
    public E pop() {
        if (list.size() == 0) {
            throw new EmptyException("stack is empty");
        }

        E element = list.getFirst();
        list.removeFirst();
        return element;
    }

    @Override
    public int size() {
        return list.size();
    }

}
