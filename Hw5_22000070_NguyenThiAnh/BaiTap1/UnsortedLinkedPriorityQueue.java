package Hw5_22000070_NguyenThiAnh.BaiTap1;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;
import Hw5_22000070_NguyenThiAnh.BaiTap1.PriorityQueueInterface;

public class UnsortedLinkedPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface<K,E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        protected K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
            next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newNode = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (head == null) {
            head = tail = newNode;
            tail.next = null;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (head == null) {
            head = tail = newNode;
            tail.next = null;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    public Entry<K, E> removeMin() {
        if (head == null) {
            return null;
        }


        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> minPrev = null;
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> prev = null;

        while (current != null) {
            if (current.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = current;
                minPrev = prev;
            }
            prev = current;
            current = current.next;
        }


        if (minPrev == null) {
            head = head.next;
        } else {
            minPrev.next = minNode.next;
        }

        if (minNode == tail) {
            tail = minPrev;
        }

        n--;
        return minNode;
    }

    @Override
    public Entry<K, E> min() {
        if (head == null) {
            return null;
        }

        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> current = head.next;

        while (current != null) {
            if (current.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = current;
            }
            current = current.next;
        }

        return minNode;
    }

}
