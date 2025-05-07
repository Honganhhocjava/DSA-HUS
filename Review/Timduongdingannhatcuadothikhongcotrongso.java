package Review;

import java.util.*;
//input
//10 10
//1 2
//2 3
//2 4
//3 6
//3 7
//6 7
//7 5
//5 8
//5 10
//8 9

public class Timduongdingannhatcuadothikhongcotrongso {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private int[] parent;
    private int n;

    public void readFile() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        visited = new boolean[n + 1];
        parent= new int[n+1];// Khởi tạo mảng visited với kích thước đúng

        for (int i = 0; i < m; i++) {
            String[] a = sc.nextLine().trim().split(" ");
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
    public void bfs(int u){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            List<Integer> list = hashMap.get(v);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i);
                    if(!visited[b]){
                        parent[b]  = v;
                        queue.add(b);
                        visited[b] = true;
                    }
                }
            }
        }
    }

    public void path(int x , int y){
        List<Integer> re = new ArrayList<>();
        bfs(x);
        if(!visited[y]) {
            System.out.println("Khong cos dduwonfg ddi");
        }
        while (y!=x) {
            re.add(y);
            y=parent[y];
        }
       // re.add(x);
        Collections.reverse(re);
        System.out.println(re);
    }

    public static void main(String[] args) {
        Timduongdingannhatcuadothikhongcotrongso timm = new Timduongdingannhatcuadothikhongcotrongso();
        timm.readFile();
        timm.path(1,10);
    }
}
