package interview.longhuan;

public class Solution {

    public int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, -10, 3, 10, -7, 7, 2, -5};
        System.out.println(solution.max(arr));
    }
}
