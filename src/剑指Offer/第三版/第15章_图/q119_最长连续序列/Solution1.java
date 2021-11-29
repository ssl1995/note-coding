package 剑指Offer.第三版.第15章_图.q119_最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2021/11/29 5:07 下午
 * @description
 */
public class Solution1 {
    // 用并查集
    public int longestConsecutive(int[] nums) {
        // father[i]:记录每个整数所在子集的父节点
        Map<Integer, Integer> fathers = new HashMap<>();
        // counts[i]:i结点为根结点的子集整数数量
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }

        for (int num : nums) {
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }

        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(longest, length);
        }
        return longest;
    }

    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        // 两个父节点不相同，就合并两个子图
        if (fatherOfI != fatherOfJ) {
            fathers.put(fatherOfI, fatherOfJ);

            int countOfI = counts.get(fatherOfI);
            int countOfJ = counts.get(fatherOfJ);

            counts.put(fatherOfJ, countOfI + countOfJ);
        }
    }

    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {10, 5, 9, 2, 4, 3};
        System.out.println(solution.longestConsecutive(nums));
    }
}
