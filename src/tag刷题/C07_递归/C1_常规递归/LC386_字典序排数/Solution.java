package tag刷题.C07_递归.C1_常规递归.LC386_字典序排数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        // 第一位数不能从0开始
        for (int num = 1; num <= 9; num++) {
            dfs(res, num, n);
        }
        return res;
    }

    private void dfs(List<Integer> res, int cur, int n) {
        // cur只是0-9中的一位数，超过n就停止递归
        if (cur > n) {
            return;
        }
        res.add(cur);
        // 非第一位数的其他位数，从0到9开始
        for (int i = 0; i <= 9; i++) {
            // 每次当前位的cur*10作为下一位数的高位
            dfs(res, 10 * cur + i, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13;
        List<Integer> res = solution.lexicalOrder(n);
        System.out.println(res);
    }
}
