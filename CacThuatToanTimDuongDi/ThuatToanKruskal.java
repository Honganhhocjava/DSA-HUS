    package BaiTap;

    import java.util.*;

    public class ThuatToanKruskal {
        // tốt nhất khi dùng danh sachs cạnh
        class Node{
            int u,v ,w;
            public Node(int u ,int v , int w){
                this.u = u;
                this.v=v;
                this.w=w;
            }
        }

        private int n,m;
        List<Node> list = new ArrayList<>();
        private int[] parrent;
        private int[] size;


        public void input() {
            Scanner sc = new Scanner(System.in) ;
            n = sc.nextInt();
            m = sc.nextInt();
            parrent = new int[n + 1];
            size = new int[n +1];
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                String a[] = sc.nextLine().trim().split(" ");
                int x = Integer.parseInt(a[0]);
                int y = Integer.parseInt(a[1]);
                int z = Integer.parseInt(a[2]);
                Node newNode = new Node(x,y,z);
                list.add(newNode);
            }
        }

        private void memSet() {
            for (int i = 1; i <= n ; i++) {
                    parrent[i] = i;
                    size[i]=1;
            }
        }

        private int find(int u) {
            if(u == parrent[u]) {
                return u;
            }
            return parrent[u] = find(parrent[u]);
        }

        private boolean Union(int u , int v) {
            u = find(u);
            v = find(v);
            if(u == v) {
                return false;
            }
            if(size[u] < size[v]) {
                parrent[u] = v;
                size[v] += size[u];
            } else {
                parrent[v] = u;
                size[u] += size[v];
            }
            return true;
        }

        public void Kruskal() {
            List<Node> result = new ArrayList<>();
            int d = 0;
            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.w,o2.w);
                }
            });

            for (int i = 0; i < m; i++) {
                Node e = list.get(i);
                int x = e.u;
                int y = e.v;
                int z = e.w;
                if(Union(x,y)) {
                    d+=z;
                    result.add(e);
                }
                if(result.size() == n-1) {
                    break;
                }
            }


            if(result.size() != n-1) {
                System.out.println("không có");
            } else {
                System.out.println(d);
                for (int i = 0; i < result.size(); i++) {

                    Node node = result.get(i);
                    System.out.println(node.u  + " " + node.v + " " + node.w);
                }
            }
        }

        public static void main(String[] args) {
            ThuatToanKruskal thuatToanKruskal = new ThuatToanKruskal();
            thuatToanKruskal.input();
            thuatToanKruskal.memSet();
            thuatToanKruskal.Kruskal();
        }
    }
