package 牛客算法课.初级班.课2_归并排序和快速排序.Q02_荷兰国旗问题;

public class NetherlandsFlag {
    // Q:<=t放左边，>t放右边
    public static void question(int[] arr, int l, int r, int t) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // <=区域右边界
        int less = l - 1;
        // 遍历指针遇到r就停止
        while (l < r) {
            // 遇到<=t的,交换
            if (arr[l] <= t) {
                swap(arr, ++less, l++);
            } else {
                // >t,遍历指针后移
                l++;
            }
        }
    }

    // Q2:荷兰国旗问题：<t放左边，=t放中间，>t放右边
    public static void netherlandsFlag(int[] arr, int l, int r, int t) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 小于区域右边界
        int less = l - 1;
        // 大于区域左边界
        int more = r + 1;
        // 遍历指针遇到大于区域左边界,就停止遍历
        while (l < more) {
            if (arr[l] < t) {  // 小于,移动less,交换,l后移
                swap(arr, ++less, l++);
            } else if (arr[l] > t) { // 大于,more移动,l不动,因为l的位置数改变了还要重新比较
                swap(arr, --more, l);
            } else {
                // =t,遍历指针后移
                l++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
