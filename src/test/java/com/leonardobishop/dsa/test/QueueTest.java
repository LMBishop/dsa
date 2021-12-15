package com.leonardobishop.dsa.test;

import com.leonardobishop.dsa.datatype.exception.EmptyException;
import com.leonardobishop.dsa.datatype.exception.FullException;
import com.leonardobishop.dsa.datatype.queue.ArrayQueue;
import com.leonardobishop.dsa.datatype.queue.LinkedQueue;
import com.leonardobishop.dsa.datatype.queue.Queue;
import com.leonardobishop.dsa.datatype.stack.ArrayStack;
import com.leonardobishop.dsa.datatype.stack.LinkedStack;
import com.leonardobishop.dsa.datatype.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Queue implementation test")
public class QueueTest {

    @Test
    @DisplayName("Linked queue test")
    public void testLinkedStack() {
        testQueue(new LinkedQueue<>());
    }

    @Test
    @DisplayName("Array queue test")
    public void testArrayQueue() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayQueue<>(0), "Exception should be thrown on illegally sized queue");
        Queue<Integer> queue = new ArrayQueue<>(4);
        testQueue(queue);

        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.queue(4);

        assertThrows(FullException.class, () -> queue.queue(5), "Exception should be thrown on full queue");
        assertThrows(IllegalArgumentException.class, () -> queue.queue(null), "Exception should be thrown on illegal queue push");
    }

    public void testQueue(Queue<Integer> queue) {
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.queue(4);

        assertEquals(4, queue.size(), "Size should be 4 after 4 insertions");
        assertEquals(1, queue.peek(), "First element should be 1");
        assertEquals(1, queue.dequeue(), "First dequeued element should be 1");
        assertEquals(3, queue.size(), "Size should be 3 after 4 insertions and 1 removal");

        queue.dequeue();
        queue.dequeue();

        assertEquals(4, queue.dequeue(), "Final dequeued element should be 4");
        assertThrows(EmptyException.class, queue::dequeue, "Exception should be thrown on empty queue");
    }

}
