package Hw2_22000070_NguyenThiAnh;
import java.util.Random;

public class BaiTap1 {
    static int comparisons = 0;
    static int swaps = 0;
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println();
        System.out.println("Sau khi sap xep la:");
        int[] arr100 = random.ints(5,0,10000).toArray();
        long startTime = System.nanoTime();
        bubbleSort(arr100);
        long endTime = System.nanoTime();
        System.out.println("Thời gian chạy (100 phần tử): " + (endTime - startTime) + " ns");
//
        System.out.println();
        System.out.println("Sau khi sap xep la:");
        int[] arr102 = random.ints(100,0,10000).toArray();
        startTime = System.nanoTime();
        selectionSort(arr102);
        endTime = System.nanoTime();
        System.out.println("Thời gian chạy (100 phần tử): " + (endTime - startTime) + " ns");

        System.out.println();
        System.out.println("Sau khi sap xep la:");
        int[] arr101 = random.ints(100,0,10000).toArray();
        startTime = System.nanoTime();
        insertionSort(arr101);
        endTime = System.nanoTime();
        System.out.println("Thời gian chạy (100 phần tử): " + (endTime - startTime) + " ns");

        System.out.println();
        System.out.println("Sau khi sap xep la:");
        int[] arr103 = random.ints(100,0,10000).toArray();
        startTime = System.nanoTime();
        quickSort(arr103,0,arr103.length - 1);
        endTime = System.nanoTime();
        System.out.println("Thời gian chạy (100 phần tử): " + (endTime - startTime) + " ns");
//
        System.out.println();
        System.out.println("Sau khi sap xep la:");
        int[] arr104 = random.ints(100,0,10000).toArray();
        startTime = System.nanoTime();
        merge_sort(arr104,0,arr104.length - 1);
        endTime = System.nanoTime();
        System.out.println("Thời gian chạy (100 phần tử): " + (endTime - startTime) + " ns");


        System.out.println();
        System.out.println("Sau khi sap xep la:");
        int[] arr105 = random.ints(100,0,10000).toArray();
        startTime = System.nanoTime();
        quickSort(arr105,0,arr105.length - 1);
        endTime = System.nanoTime();
        System.out.println("Thời gian chạy (100 phần tử): " + (endTime - startTime) + " ns");

    }

    public static void swap(int a[],int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] bubbleSort(int a[] ) {
        int n = a.length;
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if(a[j] > a[j+ 1]) {
                   swap(a,j,j+1);
                   swaps++;
                   swapped = true;
                }
            }
          //  System.out.print("Bubble Sort - After pass " + (i + 1) + ": ");
            //printArr(a);
            // Nếu không có đổi chỗ nào, dừng vòng lặp
            if (!swapped) break;
        }
//        System.out.println("Total comparisons: " + comparisons);
//        System.out.println("Total swaps: " + swaps);
        return a;
    }

    public static int[] selectionSort(int a[]) {
        int n = a.length;
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, min, i);
                swaps++;
            }
          //  System.out.print("Selection Sort - After pass " + (i + 1) + ": ");
            //printArr(a);
        }

//        System.out.println("Total comparisons: " + comparisons);
//        System.out.println("Total swaps: " + swaps);
        return a;
    }

    public static int[] insertionSort(int a[]) {
        int n = a.length;
        int comparisons = 0;
        int swaps = 0;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    swaps++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = key;
           // System.out.print("Insertion Sort - After pass " + i + ": ");
            //printArr(a);
        }

//        System.out.println("Total comparisons: " + comparisons);
//        System.out.println("Total swaps: " + swaps);
        return a;
    }


    public static int[] merge_sort(int a[], int first, int last) {
        int totalSwaps = 0;
        if ( first < last) {
            int mid = (first + last) / 2;
            merge_sort(a, first, mid);
            merge_sort(a, mid + 1, last);
            merge(a, first, mid, last);
            //printArr(a);
        }
        return new int[] {0, totalSwaps};
    }
    public static int merge(int a[], int first, int mid , int last) {
        int comparisons1 = 0;
        int swaps1 = 0;
        int  n1 = mid - first + 1;
        int n2 = last - mid ;
        int aL[] = new int[n1];
        int aR[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            aL[i] = a[first + i];
        }
        for (int j = 0; j < n2; j++) {
            aR[j] = a[mid + j + 1];
        }
        int i = 0;
        int j = 0;
        int k = first;
        while (i < n1 && j < n2) {
            comparisons1++;
            if(aL[i] <= aR[j]) {
                a[k] = aL[i];
                i++;
            }
            else {
                a[k] = aR[j];
                j++;
            }
            swaps1++;
            k++;
        }
        while (i < n1) {
            a[k] = aL[i];
            i++;
            k++;
            swaps1++;
        }
        while (j < n2) {
            a[k] = aR[j];
            j++;
            k++;
            swaps1++;
        }
      //  System.out.println("Total swaps: " + swaps1);
        return swaps1;
    }

    public static int[] quickSort(int a[], int l, int r) {
        int comparisons = 0;
        int swaps = 0;
        int p = a[(l+r)/2];
        int i = l, j = r;
        while (i < j){
            while (a[i] < p){
                comparisons++;
                i++;
            }
            while (a[j] > p){
                comparisons++;
                j--;
            }
            if (i <= j){
               swap(a,i,j);
                swaps++;
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
      //  System.out.print("Quick Sort - After partition [" + l + ", " + r + "]: ");
        //printArr(a);
       // System.out.println("Total swaps: " + swaps);
        return new int[]{comparisons, swaps};
    }}

//        public static void printArr(int a[]) {
//        int n = a.length;
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i] + " ");
//        }
//    }

