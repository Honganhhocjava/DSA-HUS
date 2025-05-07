package Hw2_22000070_NguyenThiAnh;

import java.util.Arrays;
import java.util.Scanner;

public class BaiTap9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        find(a,k);
        sc.close();
    }

    public static void swap(int a[],int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] bubbleSort(int a[] ) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j+ 1]) {
                    swap(a,j,j+1);
                }
            }
        }
        return a;
    }
    public static void find(int a[] , int k) {
        int a1[] = Arrays.copyOf(a,a.length);
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +" ");
        }
        System.out.println();
        System.out.println("gia tri vi tri thu " + k + " khi chua sap xep: " + a1[k]);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if(a[i] == a1[k]){
                System.out.println("sau sap xep gia tri " + a1[k] + " o vi tri thu moi la: " + i);
                break;
            }
        }
    }
}
