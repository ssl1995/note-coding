package tag刷题.C01_数组.NC41_最长无重复子数组;

import java.util.HashMap;

public class Solution {
    public int maxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                // j保证取到连续子数组中的最后一位：取最大
                j = Math.max(map.get(arr[i]) + 1, j);
            }
            map.put(arr[i], i);
            // max每次ij长度和上一轮max的最大值
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 3};
        Solution solution = new Solution();
        int maxLen = solution.maxLength(arr);
        System.out.println(maxLen);
    }
}
