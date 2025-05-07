package Hw6_22000070_NguyenThiAnh.Baitap2;

import java.util.LinkedList;

class HashTableWithChaining {
    private LinkedList<Node>[] table;
    private final int SIZE = 10;
    class Node {
        Node next;
        String key;
        int value;

    }

    public HashTableWithChaining() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return key.length() % SIZE;
    }

    public void put(String key, int value) {
        Node entry = new Node();
        entry.key = key;
        entry.value = value;
        int index = hash(key);
        var bucket = table[index];
        for (int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).equals(entry)) {
                bucket.get(i).value= value;
            }
        }
        bucket.add(entry);
    }

    public Integer get(String key) {
        int index = hash(key);
        for (Node entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        var bucket = table[index];
        for (int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).equals(key)) {
                bucket.remove(bucket.get(i));
            }
        }
    }

}

