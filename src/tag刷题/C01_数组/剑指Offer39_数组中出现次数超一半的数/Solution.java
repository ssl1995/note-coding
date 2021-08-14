package tag刷题.C01_数组.剑指Offer39_数组中出现次数超一半的数;


public class Solution {
    // 方法1:摩尔投票法
    // 出现次数超过一半的数，一定不会被抵消掉，最后留下的一定是它
    public int majorityElement(int[] nums) {
        int cur = 0, count = 0;
        for (int num : nums) {
            // count = 0 说明需要更新cur为当前数字
            if (count == 0) {
                cur = num;
            }
            // cur遇见相同数字，就count+1;否则count-1
            if (cur == num) {
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }
}
