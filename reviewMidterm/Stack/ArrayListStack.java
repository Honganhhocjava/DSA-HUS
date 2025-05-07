package reviewMidterm.Stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements StackInterface<E> {
    private E[] array;
    private int size = 0;
    private int defaulsize = 1000;

    public ArrayListStack() {
        this.array =(E[]) new Object[defaulsize];
    }

    @Override
    public void push(E element) {
        if(size == array.length) {
            array= Arrays.copyOf(array,array.length*2);
        }
        array[size++] = element;

    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[--size];
    }


    @Override
    public boolean isEmpty() {
       return size==0;
    }


    @Override
    public E top() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[size-1];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
        private int n = 0;

            @Override
            public boolean hasNext() {
                return n < size;
            }
            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }

                return array[n++];
            }
        };
    }
}
