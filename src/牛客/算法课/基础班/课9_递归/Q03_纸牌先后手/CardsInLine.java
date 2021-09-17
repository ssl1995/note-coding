package 牛客.算法课.基础班.课9_递归.Q03_纸牌先后手;

public class CardsInLine {
    // Q:给一个arr=[1,2,100]，两个玩家每次只能拿走
    // 方法1:
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 先手和后手中的最大值
        return Math.max(before(arr, 0, arr.length - 1), after(arr, 0, arr.length - 1));
    }

    // 先手函数
    public static int before(int[] arr, int i, int j) {
        if (i == j) {
            // 先手只剩一个数,先手再拿=是有收益
            return arr[i];
        }
        // 选择左边收益/右边收益的最大值返回
        return Math.max(arr[i] + after(arr, i + 1, j), arr[j] + after(arr, i, j - 1));
    }

    // 后手函数
    public static int after(int[] arr, int i, int j) {
        if (i == j) {
            // 后手,只剩一个数是,后手没法拿=没有收益
            return 0;
        }
        // 上一轮先手过后,这一轮的后手就拿
        return Math.min(before(arr, i + 1, j), before(arr, i, j - 1));
    }

    // 方法2:暴力递归改动态规划,不需要先手和后手两个函数,基础提升班讲
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] before = new int[arr.length][arr.length];
        int[][] after = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            // i==j时，肯定先手赢，before对角线为该元素值
            before[i][i] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                before[j][i] = Math.max(arr[j] + after[j + 1][i], arr[i] + after[j][i - 1]);
                after[j][i] = Math.min(before[j + 1][i], before[j][i - 1]);
            }
        }
        return Math.max(before[0][arr.length - 1], after[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 1};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }

}
