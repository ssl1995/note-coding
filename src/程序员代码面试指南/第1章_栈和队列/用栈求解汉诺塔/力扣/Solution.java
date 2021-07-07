package 程序员代码面试指南.第1章_栈和队列.用栈求解汉诺塔.力扣;

import java.util.List;

// 力扣面试题 08.06. 汉诺塔问题
class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.size() > 0) {
            hanota(A.size(), A, B, C);
        }
    }

    private void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 递归结束条件:n=0就结束
        if (n < 1) {
            return;
        }
        hanota(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        hanota(n - 1, B, A, C);
    }
}
