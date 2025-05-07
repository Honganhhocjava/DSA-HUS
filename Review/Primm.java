package Review;

import java.util.*;

public class Primm {
    class Canh{
        int u , v,w;
        public Canh(int u , int v , int w) {
            this.u = u;
            this.v = v;
            this.w =w;
        }
    }
    class Node{
        int b,c;
        public Node(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }

    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private int n, m;
   // private int[] mau;
    private boolean[] visited;

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[100];
    //    mau = new int[n + 1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] c = sc.nextLine().trim().split(" ");
            int x= Integer.parseInt(c[0]);
            int y = Integer.parseInt(c[1]);
            int z = Integer.parseInt(c[2]);
           if(!hashMap.containsKey(x)) {
               hashMap.put(x,new ArrayList<>());
           } hashMap.get(x).add(new Node(y,z));
            if(!hashMap.containsKey(y)) {
                hashMap.put(y,new ArrayList<>());
            } hashMap.get(y).add(new Node(x,z));
        }
    }
    public void setVisited(){
        Arrays.fill(visited,false);
    }

    public void Prim(int u){
        List<Canh> MST = new ArrayList<>();
        int d = 0;
        visited[u] = true;
        while (MST.size() < n-1) {
            int x1=0;
            int y1=0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == true) {
                List<Node> list = hashMap.get(i);
                if(list!=null){
                    for (int j = 0; j < list.size(); j++) {
                        Node e= list.get(j);
                        int dinh = e.b;
                        int kc = e.c;
                        if(!visited[dinh] && kc <min) {
                            min = kc;
                            x1 = dinh;
                            y1=i;
                            }
                        }
                    }
                }

            }
            MST.add(new Canh(x1,y1,min));
            d+=min;
            visited[x1]=true;
        }
        System.out.println(d);
        for (int i = 0; i < MST.size(); i++) {
            Canh canh = MST.get(i);
            System.out.println(canh.u + " " + canh.v + " " +canh.w);
        }

    }

    public static void main(String[] args) {
        Primm primm = new Primm();
        primm.input();
        primm.Prim(1);
    }

}
