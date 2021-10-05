package 读书笔记.剑指Offer.第三版.第3章_字符串.q15_字符串中的所有变位词;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s1, String s2) {
        ArrayList<Integer> indices = new ArrayList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']++;
            counts[s1.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            indices.add(0);
        }
        for (int i = s2.length(); i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']--;
            counts[s1.charAt(i - s2.length()) - 'a']++;
            if (areAllZero(counts)) {
                indices.add(i - s2.length() + 1);
            }
        }
        return indices;
    }

    /**
     * 判断数组元素是否全为0
     * @param counts
     * @return 布尔值
     */
    private boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
