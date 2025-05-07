package Hw6_22000070_NguyenThiAnh.BaiTap1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key,Value> {
    private class Node {
        Node next ;
        Key key;
        Value value;
    }
    private List list = new LinkedList<>();
    private Node next= null;
    private Node head =null;
    private int size=0;

    @Override
    public void put(Key key, Value value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.next = head;
        head = newNode;

        size++;
    }


    @Override
    public Value get(Key key) {
        Node cuMode = head;
        while (cuMode != null) {
            if(cuMode.key.equals(key)) {
                return cuMode.value;
            }
            cuMode = cuMode.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keyList = new ArrayList<>();
        Node currentNode  = head;
        while (currentNode!=null) {
            keyList.add(currentNode.key);
            currentNode=currentNode.next;
        }
        return keyList;
    }
}
