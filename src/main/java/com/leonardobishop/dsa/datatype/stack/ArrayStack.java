package com.leonardobishop.dsa.datatype.stack;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.exception.FullException;

/**
 * A array backed stack.
 * @param <E> type
 */
public final class ArrayStack<E> implements Stack<E> {

    private final E[] array;
    private final int capacity;
    private int index;
    private int size;
    private boolean leaky;

    /**
     * Creates a new array backed stack.
     * @param capacity the capacity of this stack
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("stack must have a capacity");
        }
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    /**
     * Creates a new array backed stack.
     * @param capacity the capacity of this stack
     * @param leaky whether elements should fall out of the stack when capacity is reached
     */
    public ArrayStack(int capacity, boolean leaky) {
        this(capacity);
        this.leaky = leaky;
    }

    @Override
    public void push(E element) {
        if (element == null) {
            throw new IllegalArgumentException("cannot push null into stack");
        } else if (!leaky && size == capacity) {
            throw new FullException("non-leaky stack is full");
        }

        array[index] = element;
        index = (index + 1) % capacity;

        if (size != capacity) {
            size++;
        }
    }

    @Override
    public E pop() {
        index = (index + capacity - 1) % capacity;

        if (array[index] == null) {
            throw new EmptyException("stack is empty");
        }

        E element = array[index];
        array[index] = null;
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

}
