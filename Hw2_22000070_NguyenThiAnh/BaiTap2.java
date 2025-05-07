package Hw2_22000070_NguyenThiAnh;

import java.util.Arrays;
import java.util.Scanner;

public class BaiTap2 {
    public static <T extends Comparable<T>>
        void selectionSort(T[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                int min = i;
                for (int j = i+1; j < array.length ; j++) {
                    if(array[j].compareTo(array[min]) < 0) {
                        min = j;
                    }
                }
                if(min != i ) {
                    T temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                }
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng số nguyên: ");
        int n = sc.nextInt();
        Integer[] intAr = new Integer[n];
        System.out.println("Nhập các số nguyên:");
        for (int i = 0; i < n; i++) {
            intAr[i] = sc.nextInt();
        }
        selectionSort(intAr);
        System.out.println("Mảng sau khi sắp xếp (tăng dần): " + Arrays.toString(intAr));

        System.out.print("\nNhập số phần tử của mảng chuỗi: ");
        int m = sc.nextInt();
        sc.nextLine();
        String[] strAr = new String[m];
        System.out.println("Nhập các chuỗi:");
        for (int i = 0; i < m; i++) {
            strAr[i] = sc.nextLine();
        }

        selectionSort(strAr);
        System.out.println("Mảng chuỗi sau khi sắp xếp (tăng dần): " + Arrays.toString(strAr));
    }

}
