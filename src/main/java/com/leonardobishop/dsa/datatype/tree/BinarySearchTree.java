package com.leonardobishop.dsa.datatype.tree;

import com.leonardobishop.dsa.datatype.exception.DuplicateElementException;
import com.leonardobishop.dsa.datatype.exception.ElementDoesNotExistException;

/**
 * A binary search tree.
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements BinaryTree<E> {

    private BinaryNode<E> root;
    private int size;
    private int height;

    public BinarySearchTree(E root) {
        this.root = new BinaryNode<>(root);
        this.size = 1;
        this.height = 0;
    }

    @Override
    public BinaryNode<E> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public void insert(E element) {
        root = insert(element, root, 1);
        size++;
    }

    private BinaryNode<E> insert(E element, BinaryNode<E> node, int depth) {
        if (node == null) {
            node = new BinaryNode<>(element);
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(insert(element, node.getRight(), depth + 1));
        } else if (element.compareTo(node.getData()) < 0) {
            node.setLeft(insert(element, node.getLeft(), depth + 1));
        } else {
            throw new DuplicateElementException("element already in tree");
        }

        if (depth - 1 > height) {
            height = depth - 1;
        }
        return node;
    }

    @Override
    public boolean contains(E element) {
        return search(element, root) != null;
    }

    private BinaryNode<E> search(E element, BinaryNode<E> node) {
        if (node == null) {
            return null;
        } else if (element.equals(node.getData())) {
            return node;
        } else if (element.compareTo(node.getData()) > 0) {
            return search(element, node.getRight());
        } else if (element.compareTo(node.getData()) < 0) {
            return search(element, node.getLeft());
        } else {
            return null;
        }
    }

    @Override
    public void remove(E element) {
        throw new UnsupportedOperationException("not implemented yet for binary search tree");
        /*
         TODO FIX
         if (!contains(element)) {
             throw new ElementDoesNotExistException(String.format("element %s does not exist in tree", element));
         }
         root = findSuccessor(element, root);
         size--;
        */

    }

    private BinaryNode<E> findSuccessor(E element, BinaryNode<E> node) {
        if (node == null) {
            return null;
        } else if (element.compareTo(node.getData()) < 0) {
            node.setLeft(findSuccessor(element, node.getLeft()));
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(findSuccessor(element, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                if (node.getLeft().getData().compareTo(node.getRight().getData()) < 0) {
                    node.setData(node.getLeft().getData());
                } else {
                    node.setData(node.getRight().getData());
                }

                node.setRight(findSuccessor(node.getData(), node.getRight()));
            }
        }
        return node;
    }
}
