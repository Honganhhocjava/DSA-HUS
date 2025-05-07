package Hw4_22000070_NguyenThiAnh.LuyenTap9;

public class MyCircularDeque {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        queue = new int[capacity];
        size = 0;
        front = 0;
        rear = -1;

    }

    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = value;
        size++;
        return true;

    }

    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        rear = (rear+1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        front = (front+1)%capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        rear = (rear- 1 +capacity )%capacity;
        size--;
        return true;
    }


    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return queue[front];

    }

    public int getRear() {
        if(isEmpty()) {
            return  -1 ;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }
}
