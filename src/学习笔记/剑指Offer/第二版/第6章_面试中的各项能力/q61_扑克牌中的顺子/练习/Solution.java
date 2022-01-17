package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q61_扑克牌中的顺子.练习;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/1/17 8:55 AM
 * @description
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 13;
        for (int num : nums) {
            if (num == 0) {
                continue;
            } else {
                if (set.contains(num)) {
                    return false;
                }
                max = Math.max(num, max);
                min = Math.min(num, min);
                set.add(num);
            }
        }
        return max - min <= 4;
    }
}
