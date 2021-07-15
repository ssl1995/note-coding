package 剑指Offer.正序版.剑指Offer48_最长无重复子串长度;

import java.util.HashMap;

public class Solution {

    // 法1:最长无重复子串,map法最直观的写法
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        // 将s转为字符数组,比如['a','b','c','a','b','c','b','b']
        char[] chars = s.toCharArray();
        // map<该字符,该字符上次出现的位置下标>,初始化value全为-1
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, -1);
        }
        // pre:str[i-1]为结尾的无重复子串的起始位置的前一个位置,初试值为-1
        int pre = -1;
        // len:记录无重复子串的最大长度
        // len初始化0:可理解为chars[0]与上一次出现chars[0]的距离为0
        int len = 0;
        // curLen:i与pre的差值
        // curLen初始化0:可理解为chars[0]与不存在的chars[-1]为结尾的子串前一个位置差值为0
        int curLen = 0;
        for (int i = 0; i < chars.length; i++) {
            // 假设map.get(chars[i])=i‘
            // 如果i‘在pre右边,说明[i’+1,i]一定是chars[i]结尾的无重复子串
            if (map.get(chars[i]) >= pre) {
                pre = map.get(chars[i]);// pre和i‘谁在右边,更新谁=作为下一轮chars[i-1]的起始位置前一位
                curLen = i - map.get(chars[i]);
            } else {// 如果i‘在pre左边,说明[pre+1,i]一定是chars[i]结尾的无重复子串
                curLen = i - pre;
            }
            // len记录每轮的最大值
            len = Math.max(len, curLen);
            // 更新map,记录元素与它最近出现的位置
            map.put(chars[i], i);
        }
        return len;
    }

    // 法2:map法改为更简单的写法
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // 哈希表使用一位数组,速度更快,字符数组中的字符ASCII码不超过127
        int[] map = new int[128];
        for (int i = 0; i < 128; i++) {
            map[i] = -1;
        }
        int pre = -1;
        int len = 0;
        int curLen;
        for (int i = 0; i < chars.length; i++) {
            // 先找到pre与i'的最右边的值
            pre = Math.max(pre, map[chars[i]]);
            // 直接计算i与最右边元素的差值,减少if判断
            curLen = i - pre;
            // 记录每轮的len长度
            len = Math.max(len, curLen);
            // 更新map
            map[chars[i]] = i;
        }
        return len;
    }
}
