package 读书笔记.牛客算法课.中级班.课4.Q06_左大减右大;

public class MaxABSBetweenLeftAndRight {


    public static int maxABS(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        // 最优化：来自问题的问法：|左大-右大|的最大值=全局最大值-min{arr[0],arr[n-1]}
        return max - Math.min(arr[0], arr[arr.length - 1]);
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i != arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000) - 499;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(200);
        System.out.println(maxABS(arr));
    }
}
