package Hw2_22000070_NguyenThiAnh;

import java.util.Scanner;

public class Baitap6 {
    public static void sort(int a[]){
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i ;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
                if(min != i) {
                    int temp = a[min];
                    a[min] = a[i];
                    a[i] = temp;
                }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int k = sc.nextInt();
        if(k <= n) {
            System.out.println("phan tu o vi tri k sau khi sap xep tang dan la: " + a[k]);
        } else {
            System.out.println("out of index");
        }

    }
}
