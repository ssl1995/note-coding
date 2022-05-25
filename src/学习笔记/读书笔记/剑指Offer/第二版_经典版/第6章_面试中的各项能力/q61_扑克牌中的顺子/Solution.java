package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q61_扑克牌中的顺子;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * 输入: nums=[1,2,3,4,5]，就是已经抽出来的5个数字啦
     * 输出: True
     */
    public boolean isStraight(int[] nums) {
        // set判断是否有重复的数
        Set<Integer> set = new HashSet<>();
        // 假设扑克牌中大小王为0,A=1,范围[0(任意，包括大小王),A(1),2...10,J(11),Q(12),K(13)]
        int min = 13, max = 0;
        for (int num : nums) {
            // 如果是大小王,这一轮循环跳过
            if (num == 0) {
                continue;
            } else {
                // 不是大小王,
                // 若有重复数字,必不可能构成顺子
                if (set.contains(num)) {
                    return false;
                }
                // 若没有重复数字,找到当前的max,min
                // 每一轮必须满足判断顺子的条件:max-min<5
                min = Math.min(min, num);
                max = Math.max(max, num);
                // 当前元素放进set中,给之后的遍历重复元素做铺垫
                set.add(num);
            }
        }
        // 如果是连续的，最大值-最小值<5
        // 返回整个数组中的max-min<5的布尔值
        return max - min < 5;
    }
}
