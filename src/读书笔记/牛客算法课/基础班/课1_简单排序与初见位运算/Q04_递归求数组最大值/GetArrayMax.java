package 读书笔记.牛客算法课.基础班.课1_简单排序与初见位运算.Q04_递归求数组最大值;

public class GetArrayMax {
    // 获取数组中最大值，学习递归行为

    // 方法一：遍历查找
    public static int getArrayMax1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    // 方法二：递归法，学习递归
    public static int getArrayMax2(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        // 递归结束：只有一个数，返回这个数
        if (l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;
        // 从中间值的左右两边拿信息
        int left = process(arr, l, mid);
        int right = process(arr, mid + 1, r);
        // 选左右两边最大值返回
        return Math.max(left, right);
    }

}
