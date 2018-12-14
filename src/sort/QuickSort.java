package sort;

import java.util.Arrays;

public class QuickSort {
    // 快速排序，a是数组，n表示数组的大小
    private static void quickSort(int[] array, int n) {
        quickSortInternally(array, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] array, int p, int r) {
        if (p > r) return;
        int q = partition(array, p, r);// 获取分区点
        quickSortInternally(array, p, q - 1);
        quickSortInternally(array, q + 1, r);
    }

    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j = p; j <= r; j++) {
            if (array[j] < pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }

        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    private static int[] array = new int[]{3, 5, 6, 7, 2, 1};

    public static void main(String[] args) {
        quickSort(array, 6);
        System.out.println(Arrays.toString(array));
    }
}
