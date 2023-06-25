package org.example;

public class Tree {
    private Node root;

    static class Node{
        int value;
        Node left, right;
        Color color;
    }

    enum Color{
        red,
        black
    }

    public void insert(int value){
        if (root == null){
            root = new Node();
            root.value = value;
        } else {
            insert(root, value);
            root = balance(root);
        }
        root.color = Color.black;
    }

    private void insert(Node node, int value){
        if (node.value != value){
            if (node.value < value){ //right
                if (node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color =  Color.red;
                } else {
                    insert(node.right, value);
                }
            } else {
                if (node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color =  Color.red;
                } else {
                    insert(node.left, value);
                }
            }
        }
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if (node == null){
            return null;
        }
        if (node.value == value){
            return node;
        }
        if (node.value < value){
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }

    public Node balance(Node root){
        return null;
    }
}
