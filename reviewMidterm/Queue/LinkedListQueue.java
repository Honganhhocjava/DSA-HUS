    package reviewMidterm.Queue;

    import java.util.NoSuchElementException;

    public class LinkedListQueue<T>  implements  QueueInterface<T> {
        class Node{
            T element;
            Node next;
        }
         private Node head = null;
        private Node tail = null;
        private int size = 0;

        @Override
        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void enqueue(T element) {
            Node newNode = new Node();
            newNode.element = element;
            if(isEmpty()) {
                head = tail= newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;

        }


        @Override
        public T dequeue() {
           if(isEmpty()) {
               throw new NoSuchElementException();
           }
               Node deleteNode = head;
               head = head.next;
               size--;
               if(head == null) {
                   tail = null;
               }
               return deleteNode.element;
        }

    }
