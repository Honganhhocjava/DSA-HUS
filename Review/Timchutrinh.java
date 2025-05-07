package Review;

import java.util.*;

public class Timchutrinh {
    // do thi vo huong thi dung dfs va bfs
    // do thi co huong thi dfs va kanh();
    //dau vao la danh sach canh

    private HashMap<Integer,List<Integer>> list = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    private int n , m;
    private int[] vissted1;
    private boolean[] vissted2;
    private int[] pa;
    int start,end;

    public void  input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        vissted2 = new boolean[n+1];
        vissted1 = new int[n+1];
        pa = new int[n+1];
        sc.nextLine();
        for (int i = 0; i <m ; i++) {
            String []a = sc.nextLine().trim().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);
            if(!list.containsKey(u)) {
                list.put(u,new ArrayList<>());
            } list.get(u).add(v);
            if(!list.containsKey(v)) {
                list.put(v,new ArrayList<>());
            } list.get(v).add(u);
        }
    }

    public boolean Bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        vissted2[u] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            List<Integer> list1 = list.get(v);
            if(list1 != null) {
                for (int i = 0; i < list1.size(); i++) {
                    int b = list1.get(i);
                    if(!vissted2[b]) {
                        pa[b] =v;
                        queue.offer(b);
                        vissted2[b] =true;
                    }
                     else if(b != pa[v]) {
                         start = b;
                         end = v;
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public void check(){
        for (int i = 0; i < n; i++) {
            if(!vissted2[i]) {
                if(Bfs(i)) {
                    System.out.println("yes");
                    result.add(start);
                    while (end!= start) {
                        result.add(end);
                        end = pa[end];
                    }
                    result.add(start);
                    Collections.reverse(result);
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println("No");

    }

    public static void main(String[] args) {
        Timchutrinh timchutrinh = new Timchutrinh();
        timchutrinh.input();
        timchutrinh.check();
    }
}
