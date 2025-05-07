package Hw7_22000070_NguyenThiAnh.BaiTap1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    @Override
    public T root() {
        return (T) array[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    public T get(int index) {
        if (index >= 0 && index < n) {
            return (T) array[index];
        }
        return null;
    }

    public int getDefaultsize() {
        return defaultsize;
    }

    public void setDefaultsize(int defaultsize) {
        this.defaultsize = defaultsize;
    }

    @Override
    public int numChildren(T p) {
        int index = (int) p;
        int indexL = 2 * index + 1;
        int indexR = 2 * index + 2;

        int count = 0;
        if (indexL < array.length && array[indexL] != null) {
            count++;
        }

        if (indexR < array.length && array[indexR] != null) {
            count++;
        }

        return count;
    }

    @Override
    public T parent(T p) {
        int index = (int) p;
        if (index <= 0 || index >= array.length || array[index] == null) {
            return null;
        }
        return (T) Integer.valueOf((index - 1) / 2);
    }

    @Override
    public T left(T p) {
        int index = (int) p;
        int leftIndex = index * 2 + 1;
        if (leftIndex >= array.length || array[leftIndex] == null) {
            return null;
        }
        return (T) Integer.valueOf(leftIndex);
    }

    @Override
    public T right(T p) {
        int index = (int) p;
        int rightIndex = index * 2 + 2;
        if (rightIndex >= array.length || array[rightIndex] == null) {
            return null;
        }
        return (T) Integer.valueOf(rightIndex);
    }

    @Override
    public T sibling(T p) {
        int index = (int) p;
        if (index <= 0) {
            return null;
        }
        if (index % 2 == 0) {
            return (T) Integer.valueOf(index - 1);
        }
        return (T) Integer.valueOf(index + 1);
    }

    public void setRoot(E element) {
        array[0] = element;
        n = 1;
    }

    public void setLeft(int p, E element) {
        int leftIndex = p * 2 + 1;
        if (leftIndex >= array.length) {
            throw new IndexOutOfBoundsException("Index exceeds tree size");
        }
        array[leftIndex] = element;
        n++;
    }

    public void setRight(int p, E element) {
        int rightIndex = p * 2 + 2;
        if (rightIndex >= array.length) {
            throw new IndexOutOfBoundsException("Index exceeds tree size");
        }
        array[rightIndex] = element;
        n++;
    }
}
