package Hw4_22000070_NguyenThiAnh.Baitap4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) {
        if(count == n) {
            queue = Arrays.copyOf(queue, queue.length*2);
            n = queue.length;
        }
        queue[(count+top)%n] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if(count == 0) {
            throw new NoSuchElementException();
        }
        E element = queue[top];
        queue[top] =null;
        top = (top + 1) %n;
        count--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = top;
            private int num = 0;
            @Override
            public boolean hasNext() {
                return num < count;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                num++;
                return queue[(current+num) %n];
            }
        };
    }
}
