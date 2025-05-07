package Hw2_22000070_NguyenThiAnh.BaiTap4;

// De bai : Nhập và một số nguyên dương n, tiếp theo là n số nguyên lần lượt là các phần tử
// của một dãy số, hãy đếm tần số (số lần xuất hiện) của các số trong dãy và in nó ra màn hình
// dưới dạng sau: "a1 t1; a2 t2; ... an tn; ", trong đó t1 là số lần xuất hiện của số a1, t2 là
// số lần xuất hiện của a2, ... a1, a2, .. an không trùng nhau và được sắp xếp tăng dần.
//
//Ví dụ:
public class Baitap4_1 {
    public static int[] quickSort(int a[], int l, int r) {
        int p = a[(l+r)/2];
        int i = l, j = r;
        while (i < j){
            while (a[i] < p){
                i++;
            }
            while (a[j] > p){
                j--;
            }
            if (i <= j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (i < r){
            quickSort(a, i, r);
        }
        if (l < j) {
            quickSort(a, l, j);
        }
        return a;
    }
    public static void Count(int a[]) {
        int n = a.length;
        int count = 1;
        for (int i = 1; i < a.length ; i++) {
            if(a[i] == a[i-1]) {
                count++;
            } else {
                System.out.print(a[i - 1] + " " +  count + " ");
                count = 1;
            }
        }
        System.out.println(a[n - 1] + " " + count + " ");
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 6, 9, 2,2};
        quickSort(a,0, a.length - 1);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        Count(quickSort(a,0,a.length - 1));
    }


}
