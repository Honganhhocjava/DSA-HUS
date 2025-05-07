package Hw6_22000070_NguyenThiAnh.BaiTap5;

import java.util.ArrayList;

public class MyHashMap {

    private class Data {
        int key ;
        int value;
            Data(int key,int value) {
                this.key = key;
                this.value = value;
            }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Data) {
                return this.key == ((Data) obj).key;

            }
            return false;
        }
    }

    private final int size = 1000;
    private ArrayList<Data> myBuckets[];

    public MyHashMap() {
      myBuckets = new ArrayList[size];
        for (int i = 0; i < myBuckets.length ;i++) {
            myBuckets[i] = new ArrayList<>();
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void put(int key , int value) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        Data newData = new Data(key,value);
        int index =bucket.indexOf(newData);
        if(index>=0) {
            bucket.get(index).value = value;
        } else {
            bucket.add(newData);
        }
    }


    public void remove(int key ) {
        int hashMapIndex = hashFunction(key);
        var bucket = myBuckets[hashMapIndex];
        Data dataDele = new Data(key , 0);
        if(bucket.contains(dataDele)) {
            bucket.remove(dataDele);
        }

    }

    public int get(int key) {
        int hashmapIndex = hashFunction(key);
        var bucket = myBuckets[hashmapIndex];
        Data findData = new Data(key,0);
        int index = bucket.indexOf(findData);
        if(index >= 0) {
            return bucket.get(index).value;
        }
        return -1;
    }


    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(1,2);
        myHashMap.put(101,1);
        System.out.println(" " +  myHashMap.get(1));
        System.out.println(" " +  myHashMap.get(10));
        myHashMap.remove(1);
        System.out.println(" " +  myHashMap.get(1));
        System.out.println(" " +  myHashMap.get(101));
    }
}
