package reviewMidterm;

import Hw3_22000070_NguyenThiAnh.BaiTap2.ListInterface;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArray() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArray(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public T get(int i) {
        if( i < 0 || i >= n) {
            throw new IllegalStateException();
        } return array[i];
    }

    @Override
    public void remove(T data) {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        for (int i = 0; i <array.length ; i++) {
            if(array[i].equals(data)) {
                for (int j = i; j < array.length; j++) {
                    array[j] = array[j+1];
                }
                array[n-1] = null;
                n--;
            }
        }
    }

    @Override
    public void set(int i, T data) {
        if( i < 0  || i >= n) {
            throw new IllegalStateException();
        }
        array[i] = data;
    }

    @Override
    public void add(T data) {
        if(n == array.length) {
            array = Arrays.copyOf(array,array.length*2);
        }
        array[n++] = data;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void isContain(T data) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(data)) {
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
            private int cunode = 0;
            @Override
            public boolean hasNext() {
                return cunode >= 0;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new IllegalStateException();
                }
                return array[cunode++];
            }
        };
    }
}
