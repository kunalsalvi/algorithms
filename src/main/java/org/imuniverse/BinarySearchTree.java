package org.imuniverse;

public class BinarySearchTree {
    private Node<Integer> root;

    public void insert(int value) {
        insert(this.getRoot(), value);
    }

    public Node<Integer> insert(Node<Integer> root, int value) {
        if(root == null) {
            root = new Node<>(value);
        } else if(value < root.item) {
            root.prev = insert(root.prev, value); //insert left - prev = left
        } else if(value > root.item) {
            root.next = insert(root.next, value); //insert right - next = right
        }

        return root;
    }

    public boolean search(Node<Integer> root, int searchValue) {
        if(root == null) {
            return false;
        }

        if(searchValue < root.item) {
            return search(root.prev, searchValue);
        }
        else if(searchValue > root.item) {
            return search(root.next, searchValue);
        }
        return true;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }
}
