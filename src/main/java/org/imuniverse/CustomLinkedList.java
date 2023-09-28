package org.imuniverse;

import java.util.NoSuchElementException;

public class CustomLinkedList<E> {
    Node<E> first, last;
    int noOfNodes = 0;
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if(noOfNodes == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        noOfNodes++;
    }

    //Assumption is that position starts from 0
    public void deleteKthNode(int nodePosition) {
        if(nodePosition >= noOfNodes) {
            throw new NoSuchElementException();
        }

        Node<E> nodeForDeletion = last;
        for (int i = 0; i < noOfNodes; i++) {
            if(i == nodePosition) {
                Node<E> prevNode = nodeForDeletion != null ? nodeForDeletion.prev : null;
                Node<E> nextNode = nodeForDeletion.next;

                if(prevNode != null) {
                    prevNode.next = nodeForDeletion.next;
                }
                if(nextNode != null) {
                    nextNode.prev = nodeForDeletion.prev;
                }

                if(nodeForDeletion.prev == null) {
                    first = nextNode;
                }

                if(nodeForDeletion.next == null) {
                    last = prevNode;
                }
                nodeForDeletion = null;
                noOfNodes--;
                break;
            } else {
                nodeForDeletion = nodeForDeletion != null ? nodeForDeletion.prev : null;
            }
        }
    }
    public void displayContents() {
        Node<E> node = first;
        for(int i = 0; i < noOfNodes; i++) {
            System.out.print(node.item + " -> ");
            node = node.next;
        }
        System.out.println();
    }

}
