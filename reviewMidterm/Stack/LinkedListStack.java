package reviewMidterm.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node{
        E element;
        Node next;
    }
    private Node stack = null;

    @Override
    public void push(E element) {
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = stack;
        stack = newNode;
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node popNode = stack;
        stack = stack.next;
        return popNode.element;

    }

    @Override
    public boolean isEmpty() {
        return stack==null;
    }

    @Override
    public E top() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.element;

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node cuNode = stack;
            @Override
            public boolean hasNext() {
                return cuNode!=null;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new IllegalStateException();
                }

                E element = cuNode.element;
                cuNode=cuNode.next;
                return element;
            }
        };
    }



}
