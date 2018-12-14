package sort;

import java.util.Arrays;

public class MergeSort {
    //归并排序算法, a是数组，n表示数组大小
    private static void mergeSort(int[] array, int n) {
        mergeSortInternally(array, 0, n - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] array, int p, int r) {
        // 递归终止条件
        if (p >= r) return;
        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(array, p, q);
        mergeSortInternally(array, q + 1, r);
        // 将 A[p...q] 和 A[q+1...r] 合并为A[p...r]
        merge(array, p, q, r);

    }

    private static void merge(int[] array, int p, int q, int r) {
        // 初始化变量i, j, k
        int i = p;
        int j = q + 1;
        int k = 0;
        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = array[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (int i1 = 0; i1 <= r - p; i1++) {
            array[p + i1] = tmp[i1];
        }
    }

    private static int[] array = {1, 4, 7, 9, 5, 2, 3, 6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        mergeSort(array, 8);
        System.out.println(Arrays.toString(array));
    }


}
