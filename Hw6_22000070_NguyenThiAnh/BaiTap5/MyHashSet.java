package Hw6_22000070_NguyenThiAnh.BaiTap5;

import java.util.ArrayList;

public class MyHashSet {
    private final int size = 1000;
    private ArrayList<Integer> buckets[];
    public MyHashSet() {
        buckets = new ArrayList[size];
        for (int i = 0; i < buckets.length ; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public int hashFunction(int key) {
        return key % size;
    }

    public void add (int key) {
        int index = hashFunction(key);
        var bucket = buckets[index];
        if(!bucket.contains(key)) {
            bucket.add(key);
        }

    }

    public void remove(int key) {
        int index = hashFunction(key);
        var bucket = buckets[index];
        int vitri = bucket.indexOf(key);
        if(vitri >=0) {
            bucket.remove(vitri);
        }
    }


    public boolean contains(int key) {
        int index = hashFunction(key);
        var bucket = buckets[index];
        if(bucket.contains(key)) {
            return true;
        }
        return false;
    }
}
