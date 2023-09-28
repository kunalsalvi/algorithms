package org.imuniverse;

public class Node<E> {
    Node<E> next;
    Node<E> prev;
    E item;

    public Node(E item){
        this.item = item;
    }
}
