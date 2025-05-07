package Review;

import java.util.*;

public class ThuatToanKruskal {
//dung danh sach canh
    class Canh{
        int u,v,w;
        public Canh(int u , int v, int w) {
            this.u = u;
            this.v=v;
            this.w=w;
        }
    }
    private int n ,m;
    private int[] parrent;
    private int[] size;
    private List<Canh> list = new ArrayList<>();

    public void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =sc.nextInt();
        parrent = new int[n+1];
        size = new int[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            Canh canh = new Canh(x,y,z);
            list.add(canh);
        }
    }



    public void memSet() {
        for (int i = 0; i < parrent.length; i++) {
            parrent[i] = i;
            size[i]=1;
        }
    }

    public int find(int u) {
        if(u == parrent[u]) {
            return u;
        }
        return parrent[u] = find(parrent[u]);
    }


    public boolean Union(int x , int y) {
        x = find(x);
        y = find(y);
        if(x==y) {
            return false;
        }

        if(size[x] < size[y]) {
            parrent[x] = y;
            size[y] += size[x];
        }
        else {
            parrent[y] = x;
            size[x] += size[y];
        }
        return true;
    }

    public void Kruskal() {
       memSet();
        int d = 0;
        List<Canh> list1 = new ArrayList<>();
        Collections.sort(list, new Comparator<Canh>() {
            @Override
            public int compare(Canh o1, Canh o2) {
                return Integer.compare(o1.w,o2.w);
            }
        });
        for (int i = 0; i < m; i++) {
            Canh canh = list.get(i);
            int dinh1 = canh.u;
            int dinh2 = canh.v;
            int kc = canh.w;
            if(Union(dinh1,dinh2)) {
                list1.add(canh);
                d+=kc;
            }
            if(list1.size() == n-1) {
                break;
            }
        }

        if(list1.size() != n-1) {
            System.out.println("Khong tim dc cay khung nho nhat");
        } else {
            System.out.println(d);
            for (int i = 0; i < list1.size(); i++) {
                Canh kq = list1.get(i);
                System.out.println(kq.u +" " + kq.v + " " + kq.w);
            }
        }
    }

    public static void main(String[] args) {
        ThuatToanKruskal thuatToanKruskal = new ThuatToanKruskal();
        thuatToanKruskal.input();
        thuatToanKruskal.Kruskal();
    }
}
