package 牛客算法课.基础班提升.课6_暴力递归到动态规划.Q03_纸牌先后手;

public class CardsInLine {

    // Q:两个聪明人对于一个arr,先后手交替进行获得的总分数？
    // 基础班讲的暴力递归
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(after(arr, 0, arr.length - 1), before(arr, 0, arr.length - 1));
    }

    // 先手函数
    public static int after(int[] arr, int i, int j) {
        // 数组区间只有一个数
        if (i == j) {
            return arr[i];
        }
        // 数组区间大于一个数
        return Math.max(arr[i] + before(arr, i + 1, j), arr[j] + before(arr, i, j - 1));
    }

    // 后手函数
    public static int before(int[] arr, int i, int j) {
        // 数组区间只有一个数
        if (i == j) {
            return 0;
        }
        // 数组区间大于一个数
        return Math.min(after(arr, i + 1, j), after(arr, i, j - 1));
    }

    // 动态规划
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 两张表
        int[][] after = new int[arr.length][arr.length];
        int[][] before = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            // base case:after的对角线是原数组值
            // base case:before的对角线是0，由于数组初始化int就是0所以没有明写
            after[j][j] = arr[j];
            // 一般情况
            for (int i = j - 1; i >= 0; i--) {
                after[i][j] = Math.max(arr[i] + before[i + 1][j], arr[j] + before[i][j - 1]);
                before[i][j] = Math.min(after[i + 1][j], after[i][j - 1]);
            }
        }
        return Math.max(after[0][arr.length - 1], before[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 1};
        System.out.println(win1(arr));
        System.out.println(win2(arr));

    }

}
