package com.leonardobishop.dsa.datatype.tree;

public interface BinaryTree<E> {

    BinaryNode<E> getRoot();

    int size();

    int height();

    void insert(E element);

    boolean contains(E element);

    void remove(E element);

    class BinaryNode<T> {

        private T data;
        private BinaryNode<T> left;
        private BinaryNode<T> right;
        private BinaryNode<T> parent;

        public BinaryNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public BinaryNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<T> left) {
            this.left = left;
        }

        public BinaryNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryNode<T> right) {
            this.right = right;
        }

        public BinaryNode<T> getParent() {
            return parent;
        }

        public void setParent(BinaryNode<T> parent) {
            this.parent = parent;
        }
    }

}
