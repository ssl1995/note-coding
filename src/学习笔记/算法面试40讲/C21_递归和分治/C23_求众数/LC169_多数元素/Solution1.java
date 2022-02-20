package 学习笔记.算法面试40讲.C21_递归和分治.C23_求众数.LC169_多数元素;

/**
 * @author SongShengLin
 * @date 2022/2/17 11:03 PM
 * @description
 */
public class Solution1 {
    /**
     * 多数元素
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 条件给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }

            votes += (x == num) ? 1 : -1;
        }

        int count = 0;
        for (int num : nums) {
            if (x == num) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return x;
        }

        throw new RuntimeException("不存在多数元素");
    }
}
