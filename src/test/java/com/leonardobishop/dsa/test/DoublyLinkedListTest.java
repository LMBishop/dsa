package com.leonardobishop.dsa.test;

import com.leonardobishop.dsa.datatype.exception.OutOfRangeException;
import com.leonardobishop.dsa.datatype.linkedlist.DoublyLinkedList;
import com.leonardobishop.dsa.datatype.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    @DisplayName("Insertion test")
    public void testInsertion() {
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        assertEquals(1, list.get(0), "First element should be 1");
        assertEquals(5, list.get(4), "Last element should be 5");
        assertEquals(3, list.get(2), "Middle element should be 3");
    }

    @Test
    @DisplayName("Removal test")
    public void testRemoval() {
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.remove(2);

        assertEquals(1, list.get(0), "First element should be 1 after first removal");
        assertEquals(4, list.get(2), "3rd element should be 4 after first removal");
        assertThrows(OutOfRangeException.class, () -> list.get(4), "5th element should not exist after first removal");
        assertEquals(5, list.getLast(), "Last element should be 5 after first removal");

        list.removeLast();

        assertThrows(OutOfRangeException.class, () -> list.get(3), "4th element should not exist after second removal");
        assertEquals(4, list.getLast(), "Last element should be 4 after second removal");

        list.removeFirst();

        assertThrows(OutOfRangeException.class, () -> list.get(2), "3th element should not exist after third removal");
        assertEquals(4, list.getLast(), "Last element should remain 4 after third removal");
        assertEquals(2, list.getFirst(), "First element should be 2 after third removal");
        assertEquals(2, list.size(), "Size should be 2 after third removal");
    }

}
