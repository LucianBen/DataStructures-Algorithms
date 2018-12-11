package search;

public class BinarySearchVariants {
    //查找第一个值等于给定值的元素
    private static int bsearchFirst(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                // 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
                // 如果 mid 不等于 0，但 a[mid] 的前一个元素 a[mid-1] 不等于 value，
                // 那也说明 a[mid] 就是我们要找的第一个值等于给定值的元素。
                // 如果经过检查之后发现 a[mid] 前面的一个元素 a[mid-1] 也等于 value，
                // 那说明此时的 a[mid] 肯定不是我们要查找的第一个值等于给定值的元素。
                // 那我们就更新 high=mid-1，因为要找的元素肯定出现在 [low, mid-1] 之间。
                if ((mid == 0) || (array[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    private static int bsearchLast(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (array[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    private static int bsearchMoreThan(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] >= value) {
                if (mid == 0 || array[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    //查找最后一个小于等于给定值的元素
    private static int bsearchLessThan(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || array[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 8, 8, 10};
        System.out.println("查找给定值的第一个元素在 "
                + bsearchFirst(array, 10, 8));
        System.out.println("查找给定值的最后一个元素在 "
                + bsearchLast(array, 10, 8));
        System.out.println("查找第一个大于等于给定值的元素在 "
                + bsearchMoreThan(array, 10, 7));
        System.out.println("查找最后一个小于等于给定值的元素在 "
                + bsearchLessThan(array, 10, 7));
    }
}
