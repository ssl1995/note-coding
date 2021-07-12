package 牛客算法课.基础班.课2_归并排序和快速排序.Q01_归并排序;

public class SmallSum {

    // 小和:某个数左边有多少个比它小的 转为 某个数右边有多少个比它大的
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return smallSum(arr, 0, arr.length - 1);
    }

    private static int smallSum(int[] arr, int l, int r) {
        // 递归终止:一个数不会产生小和,返回0
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        // 左右两边排好序，并且求小和;
        int left = smallSum(arr, l, mid);
        int right = smallSum(arr, mid + 1, r);
        int lastMerge = merge(arr, l, mid, r);
//        return smallSum(arr, l, mid) + smallSum(arr, mid + 1, r) + merge(arr, l, mid, r);
        return left + right + lastMerge;
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0, p = l, q = mid + 1;
        int res = 0;
        while (p <= mid && q <= r) {
            // 求小和关键：右大于左，小和=arr[l]*(右边大于的长度)
            res += arr[p] < arr[q] ? arr[p] * (r - q + 1) : 0;
            temp[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            temp[i++] = arr[p++];
        }
        while (q <= r) {
            temp[i++] = arr[q++];
        }
        System.arraycopy(temp, 0, arr, l, r - l + 1);
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }

}
