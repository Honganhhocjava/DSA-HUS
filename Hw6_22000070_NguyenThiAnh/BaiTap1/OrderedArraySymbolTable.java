package Hw6_22000070_NguyenThiAnh.BaiTap1;

import java.util.ArrayList;
import java.util.List;

public class OrderedArraySymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private static final int defautSize = 10;
    private Key[] keys;
    private Value[] values;
    private int size = 0;

    public OrderedArraySymbolTable() {
        keys = (Key[]) new Comparable[defautSize];
        values = (Value[]) new Object[defautSize];
    }

    @Override
    public void put(Key key, Value value) {
        int i;
        for (i = size - 1; i >= 0 && keys[i].compareTo(key) > 0; i--) {
            keys[i + 1] = keys[i];
            values[i + 1] = values[i];
        }
        if (i >= 0 && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        keys[i + 1] = key;
        values[i + 1] = value;
        size++;
    }


    @Override
    public Value get(Key key) {
        for (int i = 0; i < size ; i++) {
            if(keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                for (int j = i; j < size - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                keys[size - 1] = null;
                values[size - 1] = null;
                size--;
                return;
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)) {
                return true;
            }
        } return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public Key min() {
        if(size==0) {
            return null;
        }
        return keys[0];
    }

    @Override
    public Key max() {
        if(size==0) {
            return null;
        }
        return keys[size-1];
    }

    public int binarySearch(Key[] keys , Key key) {
        int l = 0;
        int r = size-1;
        while (l <= r) {
            int m = (l+r)/2;
            if(keys[m].equals(key)) {
                return m;
            } if(keys[m].compareTo(key) <0 ) {
                l = m+1;
            } if(keys[m].compareTo(key) >0) {
                r = m-1;
            }

        }
        return -1;


    }

    @Override
    public Key floor(Key key) {
       int i = binarySearch(keys,key);
       if(i>=0) {
           return keys[i];
       }
       if(i-1 < 0) {
           return null;
       }
        return keys[i-1];
    }

    @Override
    public Key ceiling(Key key) {
        int i = binarySearch(keys,key);
        if(i>=0) {
            return keys[i];
        }
        if(i+1 >= size) {
            return null;
        }
        return keys[i+1];
    }

    @Override
    public int rank(Key key) {
        int i = binarySearch(keys,key);
        return i;
    }

    @Override
    public Key select(int k) {
       if(k <0 || k >= size) {
           return null;
       }
       return keys[k];
    }

    @Override
    public void deleteMin() {
        if(size == 0) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        keys[size-1]= null;
        values[size-1] = null;
        size--;

    }

    @Override
    public void deleteMax() {
        if(size == 0) {
            return;
        }
        keys[size-1] = null;
        size--;
    }

    @Override
    public int size(Key u, Key v) {
        int ranku = rank(u);
        int ranlv = rank(v);
        if(ranku > ranlv) {
            return 0;
        }
        return ranlv-ranku+1;
    }

    @Override
    public Iterable<Key> keys(Key u, Key v) {
        List<Key> keyList = new ArrayList<>();
        if(u.compareTo(v) > 0 ) {
            Key temp = u;
            u = v;
            v = temp;
        }

        int start = rank(u);
        int end = rank(v);
        for (int i = start; i < end; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }
}
