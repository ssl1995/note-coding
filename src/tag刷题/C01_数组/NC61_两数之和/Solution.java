package tag刷题.C01_数组.NC61_两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[]{};
        }
        // 因为要获得坐标，所以用map记录<数，坐标>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            if (!map.containsKey(other)) {
                map.put(numbers[i], i);
            } else {
                // 保持小的坐标在前，大的坐标在后
                int index1 = Math.min(i + 1, map.get(other) + 1);
                int index2 = Math.max(i + 1, map.get(other) + 1);
                return new int[]{index1, index2};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(solution.twoSum(num, target)));
    }
}
