package 力扣.剑指Offer.第三版.第2章_数组.q6_排序数组中的两个数字之和;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                // 前后两个数小了，就要变大一点，i++
                i++;
            } else {
                // 相反，就要变小一点，j--
                j--;
            }
        }
        return new int[]{i, j};
    }
}
