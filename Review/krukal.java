package Review;
import java.util.*;
public class krukal {
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
        parrent = new int[100];
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

    public void memset(){
        for (int i = 0; i <n; i++) {
            parrent[i] = i;
            size[i] =1;
        }
    }
    public int find(int u){
        if(u==parrent[u]) {
            return u;
        }
        return parrent[u] = find(parrent[u]);
    }

    public boolean Unuon(int a, int b) {
        a = find(a);
        b = find(b);
        if(a ==b) {
            return false;
        }

        if(size[a] <size[b])  {
            parrent[a] = b;
            size[b] += size[a];
        } else  {
            parrent[b] = a;
            size[a] += size[b];
        }
        return true;
    }

    public void Krukal(){
        memset();
        int d = 0;
        List<Canh> result = new ArrayList<>();
        Collections.sort(list, new Comparator<Canh>() {
            @Override
            public int compare(Canh o1, Canh o2) {
                return Integer.compare( o1.w,o2.w);
            }
        });
        for (int i = 0; i < m; i++) {
            Canh canh1 = list.get(i);
            int dinh1 = canh1.u;
            int dinh2 = canh1.v;
            int trongso = canh1.w;
            if(Unuon(dinh1,dinh2)) {
                result.add(canh1);
                d += trongso;
            } if(result.size() == n-1) {
                break;
            }
        }
      //  System.out.println(d);
        if(result.size() != n-1) {
            System.out.println("Khong tim dc cay khung nho nhat");
        } else {
            System.out.println(d);
            for (int i = 0; i < result.size(); i++) {
                Canh kq = result.get(i);
                System.out.println(kq.u + " " + kq.v + " " + kq.w);
            }
        }
    }

    public static void main(String[] args) {
        krukal k = new krukal();
        k.input();
        k.Krukal();
    }

}
