package 慕课网数据结构.排序.mergerSort.practice;

// 小和问题
public class SmallSum {
    private SmallSum() {
    }

    public static int smallSum(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r) + merger(nums, l, mid, r);
    }

    private static int merger(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p = l;
        int q = mid + 1;
        // 小和问题的结果
        int res = 0;
        while (p <= mid && q <= r) {
            // 左边<右边小,就会产生小和
            // 小和=右边元素个数*左边该数
            res += arr[p] < arr[q] ? (r - q + 1) * arr[p] : 0;
            help[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            help[i++] = arr[p++];
        }
        while (q <= r) {
            help[i++] = arr[q++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

}
