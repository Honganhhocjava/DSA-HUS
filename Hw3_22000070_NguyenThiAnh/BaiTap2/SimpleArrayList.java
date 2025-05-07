package Hw3_22000070_NguyenThiAnh.BaiTap2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T>{
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList (int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if(n == array.length) {
            array = Arrays.copyOf(array, array.length*2);
        }
        array[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        if(i >= n || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if(i >= n || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n-1] = null;
                n--;
            }
        }

    }

    @Override
    public void isContain(T data) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
                found = true;
                break;
            }
        }
        if(found) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
    }
}
