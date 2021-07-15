package 剑指Offer.分类版.C04_字符串.剑指Offer50_第一个只出现一次的字符;

import java.util.HashMap;

public class Solution {

    // 法1:HashMap<Character, Integer>
    public char firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    // 法2: HashMap<Character, Boolean>,速度比法1快很多
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            // 0次:false
            // 1次:true,第一次遇见true,就返回它
            // 2次:false...
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
