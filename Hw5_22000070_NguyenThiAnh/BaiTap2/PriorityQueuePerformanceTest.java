package Hw5_22000070_NguyenThiAnh.BaiTap2;

import Hw5_22000070_NguyenThiAnh.BaiTap1.*;

import java.util.Random;
import java.util.Scanner;

public class PriorityQueuePerformanceTest {

    public static Entry<Integer, Integer>[] generateEntries(int n) {
        Entry<Integer, Integer>[] entries = new Entry[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(10000);
            entries[i] = new SortedArrayPriorityQueue<Integer, Integer>().new ArrEntry<>(value, value);
        }
        return entries;
    }



    public static void testPerformance(PriorityQueueInterface<Integer, Integer> pq, Entry<Integer, Integer>[] entries) {
        long startTime, endTime;

        startTime = System.nanoTime();
        for (Entry<Integer, Integer> entry : entries) {
            pq.insert(entry);
        }
        endTime = System.nanoTime();
        System.out.println("Insert time: " + (endTime - startTime) / 1e6 + " ms");

        // Đo thời gian thực hiện removeMin
        startTime = System.nanoTime();
        while (!pq.isEmpty()) {
            pq.removeMin();
        }
        endTime = System.nanoTime();
        System.out.println("RemoveMin time: " + (endTime - startTime) / 1e6 + " ms");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n (10^3 đến 10^8) :");
        int n = sc.nextInt();
        Entry<Integer, Integer>[] entries = generateEntries(n);

//        System.out.println("UnsortedLinkedPriorityQueue:");
//        PriorityQueueInterface<Integer, Integer> pq3 = new UnsortedLinkedPriorityQueue<Integer, Integer>();
//        testPerformance(pq3, entries);
//
//        System.out.println("SortedLinkedPriorityQueue:");
//        PriorityQueueInterface<Integer, Integer> pq4 = new SortedLinkedPriorityQueue<Integer, Integer>();
//        testPerformance(pq4, entries);
//
//        System.out.println("UnsortedArrayPriorityQueue:");
//        PriorityQueueInterface<Integer, Integer> pq1 = new UnsortedArrayPriorityQueue<Integer, Integer>();
//        testPerformance(pq1, entries);

        System.out.println("SortedArrayPriorityQueue:");
        PriorityQueueInterface<Integer, Integer> pq2 = new SortedArrayPriorityQueue<Integer, Integer>();
        testPerformance(pq2, entries);



    }
}
