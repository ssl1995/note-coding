package 刷题笔记.力扣.热门100.LC17_电话号码组合.练习;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/3/12 11:09 PM
 * @description
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        process(map, digits, 0, new StringBuffer(), res);
        return res;
    }


    private void process(Map<Character, String> map, String digits, Integer index, StringBuffer sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            Character c = letters.charAt(i);
            sb.append(c);

            process(map, digits, index + 1, sb, res);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
