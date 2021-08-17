package 剑指Offer.C03_字符串.剑指Offer48_最长无重复子串长度;

import java.util.HashMap;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] cs = s.toCharArray();// s转化为字符数组，便于遍历和put
        // map<该字符,该字符上次出现的位置下标>,初始化value全为-1
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            map.put(c, -1);
        }
        int pre = -1;// pre:str[i-1]为结尾的无重复子串的起始位置的前一个位置,初试值为-1
        int res = 0;// 记录区间最大的len
        int len;// len记录记录i与pre之间的距离
        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) >= pre) {// 假设map.get(chars[i])=i‘,如果i‘在pre右边,说明[i’+1,i]一定是chars[i]结尾的无重复子串
                pre = map.get(cs[i]);// pre和i‘谁在右边,更新谁=作为下一轮chars[i-1]的起始位置前一位
            } // 如果i‘在pre左边,说明[pre+1,i]一定是chars[i]结尾的无重复子串
            len = i - pre;
            // 以上几句，可以统一为以下2句：记得住那句就写那句
            // pre = Math.max(map.get(cs[i]), pre);
            // len = i - pre;
            res = Math.max(res, len);
            // 更新map,记录元素与它最近出现的位置
            map.put(cs[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "aabcd";
        int len1 = solution.lengthOfLongestSubstring(str);
        System.out.println(len1);
    }
}
