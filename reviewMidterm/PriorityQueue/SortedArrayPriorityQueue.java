package reviewMidterm.PriorityQueue;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;
import Hw5_22000070_NguyenThiAnh.BaiTap1.PriorityQueueInterface;

import java.util.Arrays;

public class SortedArrayPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface<K,E> {
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

    ArrEntry<K,E> array[];
    int n = 0;
    int defaultSize = 100;


    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }


    @Override
    public void insert(Entry<K, E> entry) {
        if(n == array.length) {
            array = Arrays.copyOf(array,array.length*2);
        }
        sortInsert(entry.getKey(),entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if(n == array.length) {
            array = Arrays.copyOf(array,array.length*2);
        }
        sortInsert(k,e);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Entry<K, E> min() {
        return array[0];
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K,E> remove = array[0];
        array[0] = null;
        return remove;
    }

    private void  sortInsert(K key , E value) {
       int i = n-1;
       while (i>=0 && array[i].getKey().compareTo(key) > 0 ) {
           array[i+1] =  array[i];
           i--;
       }
       array[i+1] = new ArrEntry<>(key,value);
       n++;
    }
}
