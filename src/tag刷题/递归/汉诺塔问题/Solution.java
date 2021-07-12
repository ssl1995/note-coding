package tag刷题.递归.汉诺塔问题;

import java.util.List;

public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    // 将A中的n个盘子借助B移动到C盘子
    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 最简单情况举例:只有一个盘子,直接将A中的盘移动到C中
        if (n == 1) {
            C.add(0, A.remove(0));
            return;
        }
        // A大于一个盘子.就要借助B来移动
        // A中n-1个盘子借助C移动到B
        move(n - 1, A, C, B);
        // A中剩下的一个盘子,放入C中
        C.add(0, A.remove(0));
        // 将B中n-1个盘子借助A移动到C中
        move(n - 1, B, A, C);
    }
}
