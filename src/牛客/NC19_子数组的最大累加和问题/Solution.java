package 牛客.NC19_子数组的最大累加和问题;

public class Solution {

    public int maxsumofSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {// 累加和<0,说明不可能是最大累加和，重置为0
                sum = 0;
            } else {// 累加和>=0，max记录每次累加中的最大值
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,-10,3,10,-7,7,2,-5};
        System.out.println(solution.maxsumofSubarray(arr));
    }
}
