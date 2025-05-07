package Hw5_22000070_NguyenThiAnh.BaiTap1;

public class main {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer,String> pq1 = new UnsortedArrayPriorityQueue<>();
        pq1.insert(3,"banana");
        pq1.insert(2,"mango");
        pq1.insert(1,"orange");
        pq1.insert(5,"apple");
        System.out.println("Min:" + pq1.min().getValue());


        PriorityQueueInterface<Integer,String> pq2 = new SortedArrayPriorityQueue<>();
        pq2.insert(1,"banana");
        pq2.insert(2,"mango");
        pq2.insert(4,"orange");
        pq2.insert(5,"apple");
        System.out.println("Min: " + pq2.min().getValue());


        PriorityQueueInterface<Integer, String> pq3 = new UnsortedLinkedPriorityQueue<>();
        pq3.insert(6, "Lemon");
        pq3.insert(2, "Peach");
        pq3.insert(8, "Watermelon");
        System.out.println("Min: " + pq3.min().getValue());

        PriorityQueueInterface<Integer, String> pq4 = new SortedLinkedPriorityQueue<>();
        pq4.insert(7, "Pineapple");
        pq4.insert(1, "Strawberry");
        pq4.insert(3, "Blueberry");
        System.out.println("Min: " + pq4.min().getValue());

    }
}


