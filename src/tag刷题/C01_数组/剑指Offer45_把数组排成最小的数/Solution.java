package tag刷题.C01_数组.剑指Offer45_把数组排成最小的数;

import java.util.Arrays;

public class Solution {
    // 调用Arrays.sort，速度最快
    public String minNumber1(int[] nums) {
        // 将nums转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 将strs按(x + y).compareTo(y + x)进行排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        // 将排序后的strs转换为str返回
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    // 手写比较逻辑，速度较慢
    public String minNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                long num1 = Long.parseLong(x + "" + y);
                long num2 = Long.parseLong(y + "" + x);
                // 如果字符串：x+y>y+x，则y在前
                if (num1 > num2) {
                    nums[i] = y;
                    nums[j] = x;
                }
                // 如果字符串：x+y<y+x，则x在前
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
