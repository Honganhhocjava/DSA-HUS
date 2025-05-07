package Hw4_22000070_NguyenThiAnh.BaiTap2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements  StackInterface<E> {
    private E[] array;
    private int size = 0;
    private int defaultSize = 100;

    public ArrayListStack() {
        this.array = (E[]) new Object[defaultSize];
    }


    public ArrayListStack(E[] array) {
        this.array = (E[]) new Object[defaultSize];
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        E element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = element;
        size++;
    }

    @Override
    public E top() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[size - 1];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
    }


    public static void main(String[] args) {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        stack.push(2);
        stack.push(3);

        int pop1 = stack.pop();
        System.out.println("Popped element: " + pop1);

        stack.push(4);

        int pop2 = stack.pop();
        System.out.println("Popped element: " + pop2);
    }

}
