package 刷题笔记.力扣.热门100.LC169_多数元素;

/**
 * @author SongShengLin
 * @date 2022/6/18 16:43
 * @description
 */
public class Solution {

    /**
     * 多数元素
     * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例：
     * 输入：nums = [3,2,3]
     * 输出：3
     */
    public int majorityElement(int[] nums) {
        int x = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (x == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    // 更换候选者
                    x = nums[i];
                    count = 1;
                }
            }
        }

        return x;
    }
}
