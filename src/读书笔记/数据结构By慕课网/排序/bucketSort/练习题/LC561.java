package 读书笔记.数据结构By慕课网.排序.bucketSort.练习题;

import java.util.Arrays;

public class LC561 {
    // 力扣561:2n长度数组拆分n对(a,b)形式，找出每队最小值之和的最大和
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        // 排序后,间隔为2的每位数之和=n对最小值之和的最大和
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
