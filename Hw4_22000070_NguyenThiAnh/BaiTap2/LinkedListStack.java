    package Hw4_22000070_NguyenThiAnh.BaiTap2;

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class LinkedListStack<E> implements StackInterface<E> {
        class Node{
            E element;
            Node next;
        }
        private Node stack = null;

        @Override
        public void push(E element) {
            Node newNode = new Node();
            newNode.element = element;
            newNode.next = stack;
            stack = newNode;
        }

        @Override
        public E pop() {
            if(stack == null) {
                throw new NoSuchElementException();
            }
            E element = stack.element;
            stack = stack.next;
            return element;
        }

        @Override
        public boolean isEmpty() {
            return stack == null;
        }

        @Override
        public E top() {
            if(stack == null) {
                throw new NoSuchElementException();
            }
            return stack.element;
        }

        @Override
        public Iterator<E> iterator() {
            return new StackIterator();
        }

        class StackIterator implements Iterator<E> {
            private Node currentNode = stack;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = currentNode.element;
                currentNode = currentNode.next;
                return element;
            }
        }

        public static void main(String[] args) {
            LinkedListStack<Integer> stack = new LinkedListStack<>();

            stack.push(2);
            stack.push(3);

            Integer pop1 = stack.pop();
            System.out.println("Popped element: " + pop1);

            stack.push(4);

            Integer pop2 = stack.pop();
            System.out.println("Popped element: " + pop2);
        }

    }
