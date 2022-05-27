package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第5章_哈希表.q32_有效的变位词;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/10/6 11:17 上午
 * @description
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 判断元素顺序是否相同
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
            if (i == s.length() - 1) {
                return false;
            }
        }
        // 元素顺序不相同，如果只含英文小写字母，用int[]；如果是Unicode编码集，用map
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }
            counts.put(c, counts.get(c) - 1);
        }
        return true;
    }
}
