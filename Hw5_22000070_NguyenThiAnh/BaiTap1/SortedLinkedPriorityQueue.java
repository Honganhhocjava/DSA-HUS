package Hw5_22000070_NguyenThiAnh.BaiTap1;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;
import Hw5_22000070_NguyenThiAnh.BaiTap1.PriorityQueueInterface;

public class SortedLinkedPriorityQueue <K extends Comparable,E> implements PriorityQueueInterface<K,E> {
    protected class NodeEntry<K,E> implements Entry<K,E> {
        protected K key;
        private E element;
        private NodeEntry<K,E> next;
        public NodeEntry(K k,E e) {
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
    private NodeEntry<K,E> head;
    private NodeEntry<K,E> tail;
    int n = 0;

    @Override
    public int size() {
        return n ;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public void insert(K k, E e) {
        sortedLinked(k,e);
    }

    @Override
    public void insert(Entry<K, E> entry) {

        sortedLinked(entry.getKey(),entry.getValue());
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        NodeEntry<K, E> min = head;
        head = head.next;
        n--;
        return min;
    }

    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return head;
    }

    private void sortedLinked(K key,E value) {
        NodeEntry<K,E> newNode = new NodeEntry<>(key,value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            NodeEntry<K, E> currentNode = head;
            NodeEntry<K, E> prevNode = null;
            while (currentNode != null && currentNode.getKey().compareTo(key) <= 0) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            if (prevNode == null) {
                newNode.next = head;
                head = newNode;
            } else if (currentNode == null) {
                prevNode.next = newNode;
                tail = newNode;
            } else {
                prevNode.next = newNode;
                newNode.next = currentNode;
            }
        }
        n++;
    }
}
