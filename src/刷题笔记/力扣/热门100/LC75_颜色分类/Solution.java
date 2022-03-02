package 刷题笔记.力扣.热门100.LC75_颜色分类;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/28 8:24 AM
 * @description
 */
public class Solution {

    /**
     * 颜色分类：0-红，1-白，2-蓝色
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {
        // 计数排序:0、1、2表示3种不同的数
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < count[0]; i++) {
            nums[i] = 0;
        }
        for (int i = count[0]; i < count[0] + count[1]; i++) {
            nums[i] = 1;
        }
        for (int i = count[0] + count[1]; i < count[0] + count[1] + count[2]; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
