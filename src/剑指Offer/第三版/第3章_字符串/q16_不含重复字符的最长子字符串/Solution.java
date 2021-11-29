package 剑指Offer.第三版.第3章_字符串.q16_不含重复字符的最长子字符串;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 字符串s中没有说明只有小写字母，所以范围是ASCII码的256个字符
        int[] counts = new int[256];
        // i=right指针
        int i = 0;
        // j=left指针
        int j = -1;
        // longest初始化为1
        int longest = 1;
        for (; i < s.length(); i++) {
            // s中没有说明只含有小写字母，所以不用-'a'
            counts[s.charAt(i)]++;
            if (hasGreaterThan1(counts)) {
                j++;
                counts[s.charAt(j)]--;
            }
            // j初始化为-1，所以i-j不用减1
            longest = Math.max(longest, i - j);
        }
        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "babcca";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

}
