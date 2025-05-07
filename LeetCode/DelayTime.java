package LeetCode;

import java.util.*;

public class DelayTime {
    // bài toán là có 1 cổng thông tin cho sẵn bây h muốn truyền thông tin ngắn nhất tới các điểm
    class Node{
        int u,v;
        public Node(int u,int v) {
            this.u = u;
            this.v = v;
        }
    }

    private int n,k ,m;
    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private final int INF = Integer.MAX_VALUE;
    private int[] d ;
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = new int[n+1];
        sc .nextLine();
        for (int i = 0; i < m  ; i++) {
            String []a = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            if(!hashMap.containsKey(x)) {
                hashMap.put(x,new ArrayList<>());
            } hashMap.get(x).add(new Node(y,z));
        }
        k = sc.nextInt();
        Delay(k);
    }
    public void setD() {
        for (int i = 0; i < d.length; i++) {
            d[i] = INF;
        }
    }


    public void Delay(int x) {
        setD();
        d[x] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.v,o2.v);// so sanh theo trọng số
            }
        });
        priorityQueue.add(new Node(x,0));
        while (!priorityQueue.isEmpty()) {
            Node e = priorityQueue.poll();
            int canh = e.u;
            int trongso = e.v;
            if(trongso > d[canh]) {
                continue;
            }
            List<Node> list = hashMap.get(canh);
            if(list!=null) {
               for(Node node : list) {
                    int a = node.u;
                    int b = node.v;
                    if(d[a] > d[canh] + b) {
                        d[a] = d[canh] +b;
                        priorityQueue.add(new Node(a,d[a]));
                    }
                }
            }
        }
        List<Integer> p = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            p.add(d[i]);
            ///System.out.println(d[i]);
        }
        Collections.sort(p);
       Collections.reverse(p);
       if(p.get(0) != INF) {
           System.out.println(p.get(0));
       } else {
           System.out.println("-1");
       }


    }

    public static void main(String[] args) {
        DelayTime delayTime = new DelayTime();
        delayTime.input();
    }
}
//6 8
//1 2 7
//1 3 12
//2 3 2
//2 4 9
//3 5 10
//4 6 1
//5 4 4
//5 6 5
//1