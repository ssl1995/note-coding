package 牛客.NC95_数组中的最长连续子序列;

import java.util.Arrays;

public class Solution {
    // 排序
    public int MLS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int maxSubLen = 0;
        // count记录连续的个数，因为一个单独的数本身就是连续的，所以初始化和重置都为1
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == 1) {
                count++;
            } else if (arr[i + 1] - arr[i] == 0) {
                continue;
            } else {
                count = 1;// 后一个数不等于前一个数，计数器重置为1
            }
            // 记录最长连续子序列的长度
            maxSubLen = Math.max(count, maxSubLen);
        }
        return maxSubLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.MLS(arr));
    }
}
