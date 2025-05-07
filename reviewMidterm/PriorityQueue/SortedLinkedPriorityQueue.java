package reviewMidterm.PriorityQueue;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;
import Hw5_22000070_NguyenThiAnh.BaiTap1.PriorityQueueInterface;

public class SortedLinkedPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface<K,E> {
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
    public Entry<K, E> removeMin() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        Entry<K,E> min = head;
        head = head.next;
        n--;
        return min;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }


    @Override
    public void insert(Entry<K, E> entry) {
        sortedLinekList(entry.getKey(),entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        sortedLinekList(k,e);
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        Entry<K,E> min = head;
        return min;
    }

    private void sortedLinekList(K k , E e)  {
        NodeEntry<K,E> newNode = new NodeEntry<>(k,e);
        NodeEntry<K,E> currentNode = head;
        NodeEntry<K,E> preNode = null;
        while (currentNode!= null && currentNode.getKey().compareTo(k) < 0) {
            preNode = currentNode;
            currentNode= currentNode.next;
        }
        if(preNode == null) {
            newNode.next = head;
            head = newNode;
        }

        else {
            preNode.next = newNode;
            newNode.next = currentNode;
        }
        if(newNode.next == null) {
            tail=newNode;
        }
        n++;
    }


}
