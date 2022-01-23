package 学习笔记.牛客算法课.中级班.课4.Q05_接雨水;


public class WaterProblem {
    /**
     * 接雨水问题
     * 以下2种方法都是最优解:空间O(1)，时间O(n)
     */
    public static long getWater1(int[] arr) {
        int left = 0, right = arr.length - 1;
        int height = 0;
        // 水量根据返回值是long可知会超过int型
        long water = 0;
        while (left < right) {
            // 当前左右指针最小值
            int min = Math.min(arr[left], arr[right]);
            // 更新桶高：当前左右指针和桶高的最大值
            height = Math.max(height, min);
            // 雨水量 = 桶高-当前最矮
            water += arr[left] <= arr[right] ? (height - arr[left++]) : (height - arr[right--]);
        }
        return water;
    }

    public static long getWater2(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        long value = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;
        int r = arr.length - 2;
        while (l <= r) {
            if (leftMax <= rightMax) {
                value += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                value += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return value;
    }

    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(WaterProblem.getWater1(nums));
    }

}
