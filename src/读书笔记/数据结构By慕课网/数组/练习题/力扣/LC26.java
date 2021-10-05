package 读书笔记.数据结构By慕课网.数组.练习题.力扣;


/**
 * 26. 删除排序数组中的重复项
 * 题目：给定一个有序排序好的数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 例子：给定数组 nums = [1,1,2],函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2
 */
public class LC26 {
    // i指向重复元素第一个索引，j从1开始遍历数组
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0, i = 1;
        while (i < nums.length) {
            // j指向不相等的元素
            if (nums[i] != nums[j]) {
                if (i-j> 1) {
                    nums[j + 1] = nums[i];
                }
                j++;
            }
            i++;
        }
        return j + 1;
    }
}
