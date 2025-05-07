package reviewMidterm;


import Hw3_22000070_NguyenThiAnh.BaiTap2.ListInterface;

import java.util.Arrays;
import java.util.Iterator;

public class LinkedList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public LinkedList() {
        array = (T[]) new Object[defaultSize];
    }

    public LinkedList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void add(T data) {
        if(n == array.length) {
            array= Arrays.copyOf(array,array.length*2);

        }
        array[n++] = data;
    }

    @Override
    public void set(int i, T data) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
            array[i] = data;
    }

    @Override
    public T get(int i) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }

        return array[i];
    }


    @Override
    public void remove(T data) {
        T remove = data;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(remove)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
            }
            array[--n] = null;

        }
    }

    @Override
    public void isContain(T data) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                System.out.println("Yes");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No");

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curent = 0;
            @Override
            public boolean hasNext() {
                return curent < n;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new IllegalStateException();
                }
                return array[curent++];
            }
        };
    }
}