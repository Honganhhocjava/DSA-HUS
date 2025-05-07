package reviewMidterm.Queue;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue <T> implements  QueueInterface<T>{
    private T[] array;
    private int top = 0;
    private int count = 0;
    private int n ;
    private int defaultSize = 100;

    public ArrayQueue() {
        n = defaultSize;
        this.array = (T[]) new Object[defaultSize];
    }

    @Override
    public boolean isEmpty(){
        return count==0;
    }

    @Override
    public void enqueue(T element) {
        if(count == n) {
            array = Arrays.copyOf(array,array.length*2);
        }
        array[(top+count)%n] = element;
        count++;

    }

    @Override
    public T dequeue() {
        if(count == 0) {
            throw new NoSuchElementException();
        }
        T dequeue = array[top];
        array[top] = null;
        top=(top+1)%n;
        count--;
        return dequeue;
    }

}
