package 刷题笔记.力扣.代码随想录.C03_哈希表.LC202_快乐树;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/3/20 19:36
 * @description
 */
public class Solution {
    /**
     * 快乐数
     * 输入：n = 19
     * 输出：true
     * 解释：n>1
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        // 数只要重复出现一次，就不是快乐数
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextInt(n);
        }
        return n == 1;
    }

    private int getNextInt(int n) {
        int res = 0;
        while (n != 0) {
            int num = n % 10;
            res += num * num;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        System.out.println(solution.isHappy(n));
    }
}
