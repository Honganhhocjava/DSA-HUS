package Hw4_22000070_NguyenThiAnh.Baitap4;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
