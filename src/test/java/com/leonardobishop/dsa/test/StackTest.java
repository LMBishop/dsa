package com.leonardobishop.dsa.test;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.exception.FullException;
import com.leonardobishop.dsa.datatype.stack.ArrayStack;
import com.leonardobishop.dsa.datatype.stack.LinkedStack;
import com.leonardobishop.dsa.datatype.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Stack implementation test")
public class StackTest {

    @Test
    @DisplayName("Linked stack test")
    public void testLinkedStack() {
        testStack(new LinkedStack<>());
    }

    @Test
    @DisplayName("Non-leaky array stack test")
    public void testNonLeakyArrayStack() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayStack<>(0), "Exception should be thrown on illegally sized stack");
        Stack<Integer> stack = new ArrayStack<>(4);
        testStack(stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertThrows(FullException.class, () -> stack.push(5), "Exception should be thrown on full stack");
        assertThrows(IllegalArgumentException.class, () -> stack.push(null), "Exception should be thrown on illegal stack push");
    }

    @Test
    @DisplayName("Leaky array stack test")
    public void testLeakyArrayStack() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayStack<>(0), "Exception should be thrown on illegally sized stack");
        Stack<Integer> stack = new ArrayStack<>(4, true);
        testStack(stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertDoesNotThrow(() -> stack.push(5), "5th element should be accepted onto stack");

        assertEquals(5, stack.pop(), "First popped element should be 5");
        assertEquals(4, stack.pop(), "Second popped element should be 4");
        assertEquals(3, stack.pop(), "Third popped element should be 3");
        assertEquals(2, stack.pop(), "Fourth popped element should be 2");
        assertThrows(EmptyException.class, stack::pop, "Stack should now be empty");
    }

    public void testStack(Stack<Integer> stack) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.size(), "Size should be 4 after 4 insertions");
        assertEquals(4, stack.pop(), "First popped element should be 4");
        assertEquals(3, stack.size(), "Size should be 3 after 4 insertions and 1 removal");

        stack.pop();
        stack.pop();

        assertEquals(1, stack.pop(), "Final popped element should be 1");
        assertThrows(EmptyException.class, stack::pop, "Exception should be thrown on empty stack");
    }

}
