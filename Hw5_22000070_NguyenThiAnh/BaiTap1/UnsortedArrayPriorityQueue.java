package Hw5_22000070_NguyenThiAnh.BaiTap1;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;
import Hw5_22000070_NguyenThiAnh.BaiTap1.PriorityQueueInterface;

import java.util.Arrays;

public class UnsortedArrayPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface<K,E> {
    protected class ArrEntry<K,E> implements Entry<K,E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public K getKey() {
            return key;
        }
    }
    ArrEntry<K,E> [] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    public void insert(Entry<K, E> entry) {
        if (n >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[n++] = new ArrEntry<>(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if (n >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[n++] = new ArrEntry<>(k, e);
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) throw new IllegalStateException("Priority queue is empty.");
        int minIndex = findMinIndex();
        Entry<K, E> minEntry = array[minIndex];
        array[minIndex] = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        n--;
        return array[findMinIndex()];
    }


    // Phương thức tìm vị trí phần tử nhỏ nhất trong priority queue
    private int findMinIndex() {
        if (n == 0) throw new IllegalStateException("Priority queue is empty.");
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            // Kiểm tra nếu phần tử khác null và có giá trị nhỏ hơn phần tử tại minIndex
            if (array[i] != null && array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }



}
