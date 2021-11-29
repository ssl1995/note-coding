package 剑指Offer.第二版.剑指Offer39_数组中出现次数超一半的数;

public class JZ28 {
    // 牛客：只能用摩尔投票法，其他方法限制了不能导包
    public int MoreThanHalfNum_Solution(int[] nums) {
        int cur = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                cur = num;
            }
            if (cur == num) {
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }
}
