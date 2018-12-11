package search;

public class BinarySearch {
    // 二分查找的递归实现
    public static int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + (high - low) >> 1;
        if (a[mid] == value) return mid;
        else if (a[mid] < value) return bsearchInternally(a, mid + 1, high, value);
        else return bsearchInternally(a, low, mid - 1, value);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int count = bsearch(a, 9, 5);
        System.out.println(count + "");
    }
}
