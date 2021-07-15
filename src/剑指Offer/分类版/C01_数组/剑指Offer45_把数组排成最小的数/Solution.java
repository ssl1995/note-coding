package 剑指Offer.分类版.C01_数组.剑指Offer45_把数组排成最小的数;

import java.util.Arrays;

public class Solution {
    public String minNumber(int[] nums) {
        // 将nums转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 贪心:将字符串数组排成最小值,按照两个字符串拼接整体大小排序=按(x + y).compareTo(y + x)进行排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        // 将排序后的字符串数组转换为一个字符串,返回它
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
