package com.leonardobishop.dsa.datatype.queue;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.exception.FullException;

/**
 * A array backed queue.
 * @param <E> type
 */
public final class ArrayQueue<E> implements Queue<E> {

    private final E[] array;
    private final int capacity;
    private int frontIndex;
    private int size;

    /**
     * Creates a new array backed queue.
     * @param capacity the capacity of this queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("queue must have a capacity");
        }
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public void queue(E element) {
        if (element == null) {
            throw new IllegalArgumentException("cannot push null into queue");
        } else if (size == capacity) {
            throw new FullException("queue is full");
        }

        array[(frontIndex + size) % capacity] = element;

        size++;
    }

    @Override
    public E dequeue() {
        if (array[frontIndex] == null) {
            throw new EmptyException("queue is empty");
        }

        E element = array[frontIndex];
        array[frontIndex] = null;
        frontIndex = (frontIndex + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public E peek() {
        return array[frontIndex];
    }

    @Override
    public int size() {
        return size;
    }

}
