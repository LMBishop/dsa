package com.leonardobishop.dsa.test;

import com.leonardobishop.dsa.datatype.tree.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Binary search tree test")
public class BinarySearchTreeTest {

    BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>(5);
    }

    @Test
    @DisplayName("Insertion test")
    public void testInsertion() {
        tree.insert(8);
        tree.insert(2);

        assertEquals(5, tree.getRoot().getData(), "Root should be 5");
        assertEquals(2, tree.getRoot().getLeft().getData(), "Root left child should be 2");
        assertEquals(8, tree.getRoot().getRight().getData(), "Root right child should be 2");

        assertEquals(1, tree.height(), "Height should be 1");
        assertEquals(3, tree.size(), "Size should be 3");

        tree.insert(3);
        tree.insert(1);

        assertEquals(3, tree.getRoot().getLeft().getRight().getData(), "3 in correct place");
        assertEquals(1, tree.getRoot().getLeft().getLeft().getData(), "1 in correct place");

        assertEquals(2, tree.height(), "Height should be 2");
        assertEquals(5, tree.size(), "Size should be 5");

        tree.insert(-1);

        assertEquals(-1, tree.getRoot().getLeft().getLeft().getLeft().getData(), "-1 in correct place");

        assertEquals(3, tree.height(), "Height should be 3");
        assertEquals(6, tree.size(), "Size should be 6");

        tree.insert(10);
        tree.insert(7);

        assertEquals(10, tree.getRoot().getRight().getRight().getData(), "10 in correct place");
        assertEquals(7, tree.getRoot().getRight().getLeft().getData(), "7 in correct place");

        assertEquals(3, tree.height(), "Height should remain 3");
        assertEquals(8, tree.size(), "Size should be 6");
    }

    @Test
    @DisplayName("Contains test")
    public void testContains() {
        tree.insert(8);
        tree.insert(2);

        assertTrue(tree.contains(5), "Should contain 5");
        assertTrue(tree.contains(8), "Should contain 8");
        assertTrue(tree.contains(2), "Should contain 2");
        assertFalse(tree.contains(1), "Should not contain 1");

        tree.insert(3);
        tree.insert(1);

        assertTrue(tree.contains(5), "Should contain 5");
        assertTrue(tree.contains(1), "Should contain 1");
    }

    @Test
    @DisplayName("Removal test")
    public void testRemoval() {
        /*
        tree.insert(8);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);

        tree.remove(1);

        assertFalse(tree.contains(1), "Should not contain 1");

        tree.remove(3);

        assertFalse(tree.contains(3), "Should not contain 3");
        assertTrue(tree.contains(8), "Should contain 8");
        assertTrue(tree.contains(2), "Should contain 2");

        tree.remove(2);
        tree.remove(8);

        assertFalse(tree.contains(3), "Should not contain 3");
        assertFalse(tree.contains(8), "Should not contain 8");
        assertFalse(tree.contains(2), "Should not contain 2");
        assertTrue(tree.contains(5), "Should contain 5");

        assertEquals(1, tree.size(), "Size should be 1");
//        assertEquals(0, tree.height(), "Height should be 0");

        tree.remove(5);

        tree.insert(50);
        tree.insert(80);
        tree.insert(20);
        tree.insert(70);
        tree.insert(30);
        tree.insert(90);
        tree.insert(10);
        tree.insert(100);
        tree.insert(0);
        tree.insert(85);
        tree.insert(15);
        tree.insert(75);
        tree.insert(25);
        tree.insert(60);
        tree.insert(40);

        tree.remove(20);
        tree.remove(30);
        tree.remove(100);
        tree.remove(25);
        tree.remove(50);
        tree.remove(70);
        tree.remove(60);
        tree.remove(80);

        assertFalse(tree.contains(20), "Should not contain 20");
        assertFalse(tree.contains(30), "Should not contain 30");
        assertFalse(tree.contains(100), "Should not contain 100");
        assertFalse(tree.contains(25), "Should not contain 25");
        assertFalse(tree.contains(50), "Should not contain 50");
        assertFalse(tree.contains(70), "Should not contain 70");
        assertFalse(tree.contains(60), "Should not contain 60");
        assertFalse(tree.contains(80), "Should not contain 80");

        assertEquals(7, tree.size(), "Size should be 7");
        //        assertEquals(2, tree.height(), "Height should be 2");

        assertTrue(tree.contains(0), "Should contain 0");
        assertTrue(tree.contains(15), "Should contain 15");
        assertTrue(tree.contains(40), "Should contain 40");
        assertTrue(tree.contains(75), "Should contain 75");
        assertTrue(tree.contains(85), "Should contain 85");
        assertTrue(tree.contains(90), "Should contain 90");
         */
    }

}
