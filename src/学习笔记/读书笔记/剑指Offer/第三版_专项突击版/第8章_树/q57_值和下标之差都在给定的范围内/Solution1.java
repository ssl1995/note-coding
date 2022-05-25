package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第8章_树.q57_值和下标之差都在给定的范围内;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/10/14 8:52 上午
 * @description
 */
public class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // map<桶编号，桶中的值(只能有一个值)>
        Map<Integer, Integer> buckets = new HashMap<>();
        // 桶大小为t+1，因为t可能=0并且桶中要先存一个数才能判断是否包含
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucketId(num, bucketSize);

            if ((buckets.containsKey(id))
                    || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num)
                    || (buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num)) {
                return true;
            }

            buckets.put(id, num);
            if (i >= k) {
                buckets.remove(getBucketId(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int getBucketId(int num, int bucketSize) {
        return num >= 0 ? num / bucketSize : (num + 1) / bucketSize - 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {2147483647, -1, 2147483647};
//        int k = 3;
        int k = 1;
//        int t = 0;
        int t = 2147483647;
        System.out.println(solution1.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
