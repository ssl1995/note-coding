package 牛客.NC111_最大数;

public class Solution {
    // 数组值组合成最大值字符串，注意首位还是0的判断
    public String solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                long num1 = Long.parseLong(x + "" + y);
                long num2 = Long.parseLong(y + "" + x);
                // 找最大值，1+2 < 2+1,肯定就交换
                if (num1 < num2) {
                    nums[i] = y;
                    nums[j] = x;
                }
            }
        }
        // 注意：数组首位是最大值，还为0，那么直接返回“0”
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {30, 1};
        System.out.println(solution.solve(nums));
    }
}
