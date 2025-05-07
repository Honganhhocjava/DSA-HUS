package Hw6_22000070_NguyenThiAnh.BaiTap1;

import java.util.ArrayList;
import java.util.List;

public class ArraySymbolTable<Key extends Comparable<Key>,Value> extends AbstractSymbolTable<Key,Value> {
    private static final int capacity = 10;
    private Key[] keys;
    private Value[] values;
    private int size = 0;

    public ArraySymbolTable() {
      keys = (Key[]) new Comparable[capacity];
      values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        keys[size] = key;
        values[size] = value;
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
            }
            keys[size - 1] = null;
            values[size - 1] = null;
            size--;
            return;
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
}
