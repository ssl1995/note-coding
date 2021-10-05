package 读书笔记.数据结构By慕课网.哈希表.练习题.剑指Offer;

import java.util.HashSet;

/**
 * 剑指offer03：找出重复的数字，在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Offer03 {
    // 使用哈希表方法，难点是必须盲写对set.contains
    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // 原地置换法
    /*
            i : 0 1 2 3 4
       nums[i]:[0 1 2 4 4]
     */
    public int findRepeatNumber2(int[] nums) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                // 如果有重复，就返回
                if (nums[i] == nums[temp]) {
                    return nums[i];
                }
                // i和temp对应的值互换
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
