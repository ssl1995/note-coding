package tag刷题.C06_动态规划.NC91_最长递增子序列;


import java.util.Arrays;

public class Solution {

    // 牛客：返回arr中的最长递增子序列
    // 示例：arr=[1,2,8,6,4]，返回=[1,2,4]
    public int[] LIS(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }
        // arr：[1,2,8,6,4]

        // list:[1,2,4,0,0]，表示arr[0..i]中最长子序列
        int[] list = new int[n];// 不能用list，会超时
        list[0] = arr[0];
        int index = 1;// 遍历list的索引，也是最长子序列长度

        // dp[i]:[1,2,3,3,3]，表示arr[0..i]中最长子序列长度
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (list[index - 1] < arr[i]) {
                list[index++] = arr[i];
                dp[i] = index;
            } else {
                int left = 0, right = index - 1;
                int first = 0;
                // 二分变种，在list中找第一个>=arr[i]的值
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (list[mid] < arr[i]) {
                        left = mid + 1;
                    } else if (list[mid] >= arr[i]) {
                        first = mid;
                        right = mid - 1;
                    }
                }
                // 找到位置后替换掉，注意是替换不是插入
                list[first] = arr[i];
                // dp[i]对应的序列其实是list的[0, first]部分，长度为first+1
                dp[i] = first + 1;
            }
        }
        //这里的求法是倒着遍历，找到满足长度的dp就记录，然后更新。（即同样值的dp，选尽量靠右边的）
        int[] res = new int[index];
        for (int j = n - 1, i = index; j >= 0; j--) {
            if (dp[j] == i) {
                res[--i] = arr[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 8, 6, 4};
        int[] res = solution.LIS(arr);
        System.out.println(Arrays.toString(res));
    }
}
