package Hw4_22000070_NguyenThiAnh.LuyenTap8;

import java.util.LinkedList;
import java.util.Queue;

// Số cuộc gọi gần đây
public class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (queue.peek() < t - 3000) {
            queue.remove();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // 1
        System.out.println(recentCounter.ping(100));   // 2
        System.out.println(recentCounter.ping(3001));  // 3
        System.out.println(recentCounter.ping(3002));  // 3
    }
}
