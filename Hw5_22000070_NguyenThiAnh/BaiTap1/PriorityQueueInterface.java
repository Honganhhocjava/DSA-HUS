package Hw5_22000070_NguyenThiAnh.BaiTap1;

import Hw5_22000070_NguyenThiAnh.BaiTap1.Entry;

public interface PriorityQueueInterface<K,E> {
    public int size();
    public boolean isEmpty();
    public void insert(Entry<K,E> entry);
    public void insert(K k , E e);
    public Entry<K,E> removeMin();
    public Entry<K,E> min();
}
