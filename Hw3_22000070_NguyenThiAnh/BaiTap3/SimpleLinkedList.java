package Hw3_22000070_NguyenThiAnh.BaiTap3;

import java.util.Iterator;

public class SimpleLinkedList<T> implements  Iterable<T>{
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if(top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if(top == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node cuNode = top;
        for (int j = 0; j < i ; j++) {
            cuNode = cuNode.next;
        }
        return cuNode.data;
    }

    public void set(int i ,T data) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node();
        newNode.data = data;
        Node cuNode = top;
        for (int j = 0; j < i; j++) {
            cuNode = cuNode.next;
        }
        cuNode = newNode;
    }

    public boolean isContain(T data) {
        Node cuNode = top;
        while (cuNode!= null) {
            if (cuNode.data.equals(data)) {
                return true;
            }
            cuNode = cuNode.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n==0;
    }

    public T removeTop() {
        if(top.next == null) {
            top = null;
            bot = null;
        }
        T remove = top.data;
        top = top.next;
        n--;
        return remove;
    }

    public T removeBot() {
        T remove = bot.data;
        if(top ==  bot) {
            top = null;
            bot = null;
        } else {
            Node cuNode = top;
            while (cuNode!= bot) {
                cuNode = cuNode.next;
            }
            cuNode.next = null;
            bot = cuNode;
            n--;
        }
        return remove;
    }

    public T remove(T data) {
        if(top.data.equals(data)) {
            removeTop();
        }
        if(bot.data.equals(data)){
            removeBot();

        }
        Node cuNode = top;
        Node preNode = null;
        while (cuNode!= null && !cuNode.data.equals(data)) {
            preNode = cuNode;
            cuNode = cuNode.next;
        }
        T removeData = cuNode.data;
        preNode.next = cuNode.next;
        n--;
        return removeData;
    }

    public int indexOf(T data) {
        Node current = top;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = top;
            @Override
            public boolean hasNext() {
                return currentNode!= null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
