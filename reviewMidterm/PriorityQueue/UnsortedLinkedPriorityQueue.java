package reviewMidterm.PriorityQueue;

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
    public void insert(K k, E e) {

        NodeEntry<K,E> newNode = new NodeEntry<>(k,e);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K,E> newNode = new NodeEntry<>(entry.getKey(),entry.getValue());
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        NodeEntry<K,E> removeCurrent = head;
        NodeEntry<K,E> preRemove = null;
        NodeEntry<K,E> currentNode  = head;
        NodeEntry<K,E> preCurrent = null;
        while (currentNode!= null) {
            if( currentNode.getKey().compareTo(removeCurrent.getKey()) <0) {
                removeCurrent = currentNode;
                preRemove = preCurrent;
            }
            preCurrent = currentNode;
            currentNode=currentNode.next;


            if(preRemove == null) {
                head = head.next;
                if(head == null) {
                    tail= null;
                }
            } else {
                preRemove.next = removeCurrent.next;
                if(removeCurrent == tail) {
                    tail = preRemove;
                }

            }

        }
        n--;
        return removeCurrent;

    }


    @Override
    public Entry<K, E> min() {
        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> nextNode = head.next;
        while (nextNode != null) {
            if (nextNode.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = nextNode;
            }
            nextNode = nextNode.next;
        }
        return minNode;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }
}