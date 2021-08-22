package interview.wangyi.Q1_数组中小于等于M的组合数;

public class Solution {
    public int process(int[] arr, int m) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int other = m - arr[i];
            for (int j = 0; j < arr.length && i != j; j++) {
                if (arr[j] <= other) {
                    res++;
                }
            }
        }
        return res;
    }
}
