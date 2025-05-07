package reviewMidterm.PriorityQueue;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;
import Hw5_22000070_NguyenThiAnh.BaiTap1.PriorityQueueInterface;

import java.util.Arrays;

public class UnsortedArrayPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface<K,E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
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
    protected ArrEntry<K,E> array[];
    protected int n = 0;
    protected int defaultSize = 100;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }




    @Override
    public void insert(Entry<K, E> entry) {
        if( n == array.length ) {
            array = Arrays.copyOf(array,array.length*2);
        }
        array[n++] = new ArrEntry<>(entry.getKey(),entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if( n == array.length ) {
            array = Arrays.copyOf(array,array.length*2);
        }
        array[n++] = new ArrEntry<>(k,e);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Entry<K, E> min() {

        return array[findIndexMin()];
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K,E> entry = array[findIndexMin()];
        n--;
        return entry;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    private int findIndexMin() {
        if(n==0) {
            throw new IllegalStateException();
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(array[i] !=null && array[i].getKey().compareTo(array[index]) < 0 ) {
                index = i;
            }
        }
        return index;
    }
}
