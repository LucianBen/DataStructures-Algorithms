package Sort;

import java.util.Arrays;

public class InsertionSort {
    //插入排序，a 表示数组，n 表示数组大小
    private static void insertionSort(int a[], int n) {
        if (n < 0) return;
        for (int i = 0; i < n; i++) {
            int value = a[i];
            int j = i;
            for (; j > 0; j--) {
                if (a[j - 1] > value) {
                    a[j] = a[j - 1]; // 数据移动
                } else {
                    break;
                }
            }
            a[j] = value;// 插入数据
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        insertionSort(new int[]{4, 5, 6, 1, 3, 2}, 6);
    }
}
