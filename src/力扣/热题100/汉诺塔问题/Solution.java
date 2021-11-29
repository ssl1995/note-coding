package 力扣.热题100.汉诺塔问题;

import java.util.List;

public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();// n是总的盘子数量
        move(A, B, C, n);
    }

    // 将A中的n个盘子借助B移动到C盘子
    private void move(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        // base case:只有一个盘子,直接将A中的盘移动到C中
        if (n == 1) {
            C.add(0, A.remove(0));
            return;
        }
        // A大于一个盘子.就要借助B来移动
        move(A, C, B, n - 1);// A中n-1个盘子借助C移动到B
        C.add(0, A.remove(0));// A中剩下的一个盘子,放入C中
        move(B, A, C, n - 1);// 将B中n-1个盘子借助A移动到C中
    }
}
