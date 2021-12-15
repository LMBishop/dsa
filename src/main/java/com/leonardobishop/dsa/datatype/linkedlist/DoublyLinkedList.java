package com.leonardobishop.dsa.datatype.linkedlist;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.exception.OutOfRangeException;

/**
 * A non-circular doubly linked list.
 */
public final class DoublyLinkedList<E> implements LinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public void removeFirst() {
        this.disallowEmpty();

        if (size == 1) {
            first = null;
        } else {
            Node<E> second = first.getNext();
            second.setPrev(null);
            first = second;
        }
        size--;
    }

    @Override
    public void removeLast() {
        this.disallowEmpty();

        if (size == 1) {
            first = null;
        } else {
            Node<E> secondLast = last.getPrev();
            secondLast.setNext(null);
            last = secondLast;
        }
        size--;
    }

    @Override
    public void remove(int index) {
        this.disallowEmpty();
        this.checkIndex(index);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<E> current = first;
            Node<E> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null && current != null) {
                previous.setNext(current.getNext());
                current.getNext().setPrev(previous);
            }
        }

        size--;
    }

    @Override
    public E getFirst() {
        this.disallowEmpty();

        return first.getData();
    }

    @Override
    public E getLast() {
        this.disallowEmpty();

        return last.getData();
    }

    @Override
    public E get(int index) {
        this.disallowEmpty();
        this.checkIndex(index);

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertFirst(E element) {
        Node<E> node = new Node<>(element, null, first);
        if (first != null) {
            first.setPrev(node);
        }
        first = node;
        if (last == null) {
            last = first;
        }

        size++;
    }

    @Override
    public void insertLast(E element) {
        Node<E> node = new Node<>(element, last, null);
        if (last != null) {
            last.setNext(node);
        }
        last = node;
        if (first == null) {
            first = last;
        }

        size++;
    }

    @Override
    public void insert(E element, int index) {
        this.checkIndex(index);

        if (index == 0) {
            insertFirst(element);
        } else if (index == size - 1) {
            insertLast(element);
        } else {
            Node<E> current = first;
            Node<E> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            Node<E> node = new Node<>(element, previous, current);
            if (previous != null) {
                previous.setNext(node);
            }
            if (current != null) {
                current.setPrev(node);
            }
        }

        size++;
    }

    /**
     * Throws an exception if the size of this linked list is zero.
     */
    private void disallowEmpty() {
        if (size == 0) {
            throw new EmptyException("linked list has no elements");
        }
    }

    /**
     * Throws an exception if the index exceeds the size of this linked list.
     */
    private void checkIndex(int index) {
        if (size <= index) {
            throw new OutOfRangeException(String.format("index %d is outsize list range %d", index, size));
        }
    }

}
