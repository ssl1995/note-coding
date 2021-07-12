package 牛客算法课.基础班.课9_递归.Q03_纸牌先后手;

public class CardsInLine {
    // 方法1:需要先后两个函数
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 先手和后手中的最大值
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    // 先手函数
    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            // 先手只剩一个数,先手再拿=是有收益
            return arr[i];
        }
        // 选择左边收益/右边收益的最大值返回
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    // 后手函数
    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            // 后手,只剩一个数是,后手没法拿=没有收益
            return 0;
        }
        // 上一轮先手过后,这一轮的后手就拿
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    // 方法2:暴力递归改动态规划,不需要先手和后手两个函数,基础提升班讲
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 1};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }

}
