//package LeetCode;
//
//import java.util.*;
//
//
//// Muon hoc mon hoc b thi phai hoan thanh dc mon hoc a
//// khong the dong thoi hoc ca a va b duoc
//// tuong duong voi kiem tra do thi co huong co chu trinh hay khong. Neu co chu trinfh thi la sai
//// khong co chu trinh thi dung
//public class Solution2 {
//    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
//    private int[] color;
//    private boolean[] visited;
//    private int[] deGree;
//    int n;
//
//    public void input() {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        int m = sc.nextInt();
//        color = new int[n + 1];
//        visited = new boolean[n + 1];
//        deGree = new int[n + 1];
//        sc.nextLine();
//        for (int i = 0; i < m; i++) {
//            String a[] = sc.nextLine().trim().split(" ");
//            int v = Integer.parseInt(a[0]);
//            int u = Integer.parseInt(a[1]);
//            if (!hashMap.containsKey(v)) {
//                hashMap.put(v, new ArrayList<>());
//            }
//            hashMap.get(v).add(u);
//            deGree[u]++;
////
//
//        }
//    }
//
//    public void setColor() {
//        for (int i = 0; i < color.length; i++) {
//            color[i] = 0;
//        }
//    }
//
//    public boolean Dfs(int u) {
//        color[u] = 1;
//        List<Integer> list = hashMap.get(u);
//        if (list != null) {
//            for (int i = 0; i < list.size(); i++) {
//                int b = list.get(i);
//                if (color[b] == 0) {
//                    if (Dfs(b)) {
//                        return true;
//                    }
//                } else if (color[b] == 1) {
//                    return true;
//                }
//            }
//        }
//        color[u] = 2;
//        return false;
//    }
//
//    public void SetVisited() {
//        for (int i = 0; i < visited.length; i++) {
//            visited[i] = false;
//        }
//    }
//
//    public boolean Kanh() {
//        Queue<Integer> queue = new LinkedList<>();
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (deGree[i] == 0) {
//                queue.add(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            int u = queue.poll();
//            count++;
//            List<Integer> list = hashMap.get(u);
//            if (list != null) {
//                for (int i = 0; i < list.size(); i++) {
//                    int b = list.get(i);
//                    deGree[b]--;
//                    if (deGree[b] == 0) {
//                        queue.add(b);
//                    }
//                }
//            }
//        }
//        if (count == n) {
//            return false;
//        } else {
//            return true;
//        }
//
//    }
//
//    public void check() {
////        for (int i = 0; i <n ; i++) {
////            if(color[i] ==0) {
//        if (Kanh()) {
//            System.out.println("No");
//            return;
//        } else {
//            //  }
//            //}
//            System.out.println("yes");
//        }
//    }
////    public static void main(String[] args) {
////        Solution2 solution2 = new Solution2();
////        solution2.input();
////        solution2.check();
////    }
////}
//}
