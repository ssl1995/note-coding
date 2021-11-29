package 剑指Offer.第二版.剑指Offer61_扑克牌中的顺子;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 从一幅扑克牌中抽出5张牌,判断是否是顺子
    public boolean isStraight(int[] nums) {
        // set判断是否有重复的数
        Set<Integer> set = new HashSet<>();
        // 扑克牌顺子大小从大小王为0,A=1到K=13,范围[0,A,2...10,J,Q,K]
        int min = 13, max = 0;
        // 遍历数组中每一个数字
        for (int num : nums) {
            // 如果是大小王,这一轮循环跳过
            if (num == 0) {
                continue;
            } else {
                // 不是大小王,
                // 若有重复数字,必不可能构成顺子
                if (set.contains(num)) {
                    return false;
                } else {
                    // 若没有重复数字,找到当前的max,min
                    // 每一轮必须满足判断顺子的条件:max-min<5
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                    // 当前元素放进set中,给之后的遍历重复元素做铺垫
                    set.add(num);
                }
            }
        }
        // 返回整个数组中的max-min<5的布尔值
        return max - min < 5;
    }
}
