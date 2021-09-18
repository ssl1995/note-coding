package 力扣.剑指Offer.第三版.第3章_字符串.q16_不含重复字符的最长子字符串;

public class Solution1 {
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
        // 优化：关心哈希表中的值有没有>1，用一个变量记录
        int countDup = 0;
        for (; i < s.length(); i++) {
            // s中没有说明只含有小写字母，所以不用-'a'
            counts[s.charAt(i)]++;
            if (counts[s.charAt(i)] == 2) {
                countDup++;
            }
            // countDup>0就说明有重复字符
            while (countDup > 0) {
                j++;
                counts[s.charAt(j)]--;
                if (counts[s.charAt(j)] == 1) {
                    countDup--;
                }
            }
            // j初始化为-1，所以i-j不用减1
            longest = Math.max(longest, i - j);
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "babcca";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLongestSubstring(s));
    }

}
