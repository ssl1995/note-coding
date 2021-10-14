package 读书笔记.剑指Offer.第三版.第8章_树.q57_值和下标之差都在给定的范围内;

import java.util.TreeSet;

/**
 * @author SongShengLin
 * @date 2021/10/14 8:52 上午
 * @description
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {

            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
