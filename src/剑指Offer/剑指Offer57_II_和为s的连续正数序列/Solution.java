package 剑指Offer.剑指Offer57_II_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] findContinuousSequence(int target) {
        // 初始化:i左边数,初试化为1;j右边数,初试化为2;所以初始化sum为3
        int i = 1, j = 2, sum = 3;
        // 不知道结果数组多大,暂时使用链表存储结果
        List<int[]> res = new ArrayList<>();
        // 循环结束:左边界数和右边界数相等,跳出循环
        while (i < j) {
            // 相等时,记录结果到临时一维数组,最后加入res链表中
            if (sum == target) {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = k;
                }
                res.add(temp);
            }
            // 移动窗口和指针,>和=逻辑相同,合并在一起书写
            if (sum >= target) {
                sum -= i++;
            } else {
                sum += ++j;
            }
        }
        // Java中二维数组列数可变
        return res.toArray(new int[0][]);
    }
}
