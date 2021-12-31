package 刷题笔记.牛客.NC41_最长无重复子数组;

import java.util.HashMap;

public class Solution {
    // 最长无重复子数组长度
    public int maxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // map<元素，最近出现的下标>
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                // 如果该元素出现过，j指向它最近出现位置下一位
                j = Math.max(map.get(arr[i]) + 1, j);
            }
            // 更新map<元素，最近出现的下标>
            map.put(arr[i], i);
            // max取i与j长度的最大值=最长无重复子数组的长度
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 2, 2};
        Solution solution = new Solution();
        int maxLen = solution.maxLength(arr);
        System.out.println(maxLen);
    }
}
