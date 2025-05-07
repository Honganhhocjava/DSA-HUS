package reviewMidterm;

import Hw3_22000070_NguyenThiAnh.BaiTap2.ListInterface;

import java.util.Iterator;

public class SimpleLinedk<T> implements ListInterface<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;


    @Override
    public int size() {
        return n;
    }

    @Override
    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()) {
            top = bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    @Override
    public void set(int i, T data) {
        Node currentNode = top;
        for (int j = 0; j < i; j++) {
            currentNode= currentNode.next;
        }
        currentNode.data = data;

    }

    @Override
    public void remove(T data) {
        Node currentNode = top;
        while (currentNode.next!= null) {
            if (currentNode.next.data.equals(data)) {
                currentNode.next = currentNode.next.next;
                n--;
            }
            currentNode=currentNode.next;
        }

    }


    @Override
    public T get(int i) {
        Node currentNode = top;
        for (int j = 0; j < i; j++) {
            currentNode= currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public void isContain(T data) {
        boolean found = false;
        Node currentNode = top;
        while (currentNode!= null) {
            if (currentNode.data.equals(data)) {
                found = true;
                break;
            }
        }
        if(found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = top;
            @Override
            public boolean hasNext() {
                return top != null;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw  new IllegalStateException();
                }
                T data = currentNode.data;
                currentNode=currentNode.next;
                return data;
            }
        };
    }
}
