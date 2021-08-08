package 牛客算法课.中级班.课1.Q03_染色;

public class ColorLeftRight {

    // RGRGR -> RRRGG
    // 左边是R，右边是G，最少需要染色多少个？
    // 法:左右预处理,类似动态规划
    public static int minPaint1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int n = cs.length;
        // 明确：目标是R在左边，G在右边，那么右边是R都要染成G，
        // 用right预统计[n-1,0]有多少个R染成G
        int[] right = new int[n];
        right[n - 1] = cs[n - 1] == 'R' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (cs[i] == 'R' ? 1 : 0);
        }
        // left统计[0,n-1]有多少个G需要染成R
        int[] left = new int[n];
        left[0] = cs[0] == 'G' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + (cs[i] == 'G' ? 1 : 0);
        }
        // min初始化为left[最右]、right[最左]边界值最小值
        int min = Math.min(left[n - 1], right[0]);
        for (int i = 1; i < n; i++) {
            min = Math.min(left[i] + right[i - 1], min);
        }
        return min;
    }

    // 优化：减少为一个Right数组，left是变量
    public static int minPaint2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] cs = s.toCharArray();
        // 明确：R在左边，G在右边，那么右边是R都要染成G，用right预统计[len-1,0]有多少个R？
        int[] right = new int[cs.length];
        right[cs.length - 1] = cs[cs.length - 1] == 'R' ? 1 : 0;
        for (int i = cs.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (cs[i] == 'R' ? 1 : 0);
        }
        int res = right[0];
        int left = 0;
        for (int i = 0; i < cs.length - 1; i++) {
            left += cs[i] == 'G' ? 1 : 0;
            res = Math.min(res, left + right[i + 1]);
        }
        res = Math.min(res, left + (cs[cs.length - 1] == 'G' ? 1 : 0));
        return res;
    }


    public static void main(String[] args) {
//        String test = "RGRGR";
        String test = "GGRGGR";
        System.out.println(minPaint2(test));
        System.out.println(minPaint1(test));

    }

}
