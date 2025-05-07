package Hw4_22000070_NguyenThiAnh.Baitap4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements QueueInterface<E>{
    class Node {
        E element ;
        Node next;
    }

    private Node head = null;
    private Node tail = null;
    private int n = 0;

    @Override
    public void enqueue(E element) {
        Node newNode = new Node();
        newNode.element = element;
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;

    }

    @Override
    public E dequeue() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        E element = head.element;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        n--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueInterator();
    }


    private class LinkedListQueueInterator implements Iterator<E> {

        private Node currentNode = head;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = currentNode.element;
            currentNode=currentNode.next;
            return element;
        }
    }
}
