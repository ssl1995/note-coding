package 牛客算法课.中级班.课2.Q01_去重数字对;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubvalueEqualK {

    // 统计arr中，距离相差k的两个数有哪些，重复的算一对，比如(1,2)和(2,1)算重复的一对
    public static List<List<Integer>> allPair(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer cur : set) {
            if (set.contains(cur + k)) {
                res.add(Arrays.asList(cur, cur + k));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 8, 7};
        int k = 4;
        // [[1, 5], [4, 8]]
        System.out.println(allPair(arr, k));
    }
}
