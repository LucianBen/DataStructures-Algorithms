package Sort;

public class BubbleSort {

    // 冒泡排序，a 表示数组，n 表示数组大小

    private static void bubbleSort(int a[], int n) {
        if (n < 1) return;

        for (int i = 1; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 1; j < n - i + 1; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

    }


    public static void main(String[] args) {
        bubbleSort(new int[]{1, 2, 3, 4, 5, 6}, 6);
    }
}
