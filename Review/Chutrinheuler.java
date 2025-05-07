package Review;

import java.util.*;

public class Chutrinheuler {
    private int n , m ;
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
            int v = Integer.parseInt(a[0]);
            int u = Integer.parseInt(a[1]);
            if (!hashMap.containsKey(v)) {
                hashMap.put(v, new ArrayList<>());
            }
            hashMap.get(v).add(u);
            if (!hashMap.containsKey(u)) {
                hashMap.put(u, new ArrayList<>());
            }
            hashMap.get(u).add(v);

        }
    }

    public void euler(int v) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> ec = new ArrayList<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            List<Integer> list = hashMap.get(u);
            if(!list.isEmpty()) {
                int b = list.get(0);
                stack.push(b);
                hashMap.get(u).remove((Integer) b);
                hashMap.get(b).remove((Integer) u);
            }else {
                stack.pop();
                ec.add(u);
            }
        }
        Collections.reverse(ec);
        System.out.println(ec);
    }

    public static void main(String[] args) {
        Chutrinheuler chutrinheuler = new Chutrinheuler();
        chutrinheuler.input();
        chutrinheuler.euler(1);
    }
}
