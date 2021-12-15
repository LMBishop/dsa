package com.leonardobishop.dsa.datatype.stack;

public interface Stack<E> {

    /**
     * Inserts an element onto the top of stack.
     * @param element element to push
     */
    void push(E element);

    /**
     * Removes the top element off the stack and returns it.
     * @return the popped element
     */
    E pop();

    /**
     * Returns the size of the stack.
     * @return size of stack
     */
    int size();

}
