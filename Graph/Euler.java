package Graph;

import java.util.*;

// đầu vào
//5 6
//1 2
//2 3
//3 1
//2 4
//4 5
//2 5


public class Euler {
    private int n , m ;
    private HashMap<Integer, List<Integer>>  hashMap = new HashMap<>();

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

    public void Euler(int v) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> ec = new ArrayList<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            List<Integer> list = hashMap.get(u);
            if(!list.isEmpty()){
                    int b = list.get(0);
                    stack.push(b);
                    hashMap.get(u).remove((Integer) b);
                    hashMap.get(b).remove((Integer) u);
            } else {
                stack.pop();
                ec.add(u);
            }
        }

        Collections.reverse(ec);
        for (int i = 0; i < ec.size(); i++) {
            System.out.print(ec.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        Euler euler = new Euler();
        euler.input();
        euler.Euler(1);
    }
}
