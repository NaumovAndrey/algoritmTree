package org.example;

public class RedBlackTree<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> left, right;
        boolean isRed;

        Node(T data) {
            this.data = data;
            this.isRed = true;
        }
    }

    private Node<T> root;

    public void add(T data) {
        root = add(root, data);
        root.isRed = false;
    }

    private Node<T> add(Node<T> node, T data) {
        if (node == null) {
            return new Node<T>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = add(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = add(node.right, data);
        } else {
            // Duplicate data not allowed
            return node;
        }

        // Rebalance tree
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node<T> node) {
        return node != null && node.isRed;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private void flipColors(Node<T> node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    // ouput
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.data);
        inorderTraversal(node.right);
    }
}
