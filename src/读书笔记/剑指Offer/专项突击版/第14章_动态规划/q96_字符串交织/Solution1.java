package 读书笔记.剑指Offer.专项突击版.第14章_动态规划.q96_字符串交织;

/**
 * @author SongShengLin
 * @date 2021/11/18 9:16 上午
 * @description
 */
public class Solution1 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() < s2.length()) {
            return isInterleave(s2, s1, s3);
        }
        // 列需要前2个，行只需要1个，所以可以优化成一维数组
        boolean[] dp = new boolean[s2.length() + 1];
        // 初始化：两个空字符能拼接成任何字符
        dp[0] = true;

        // 初始化列
        for (int i = 0; i < s2.length(); i++) {
            dp[i + 1] = s2.charAt(i) == s3.charAt(i) && dp[i];
        }

        for (int i = 0; i < s1.length(); i++) {
            // 二维数组中每一个新的行开始=一维数组中每一个行的开始，就要从左到右开始重新计算dp[0]
            dp[0] = dp[0] && s1.charAt(i) == s3.charAt(i);

            for (int j = 0; j < s2.length(); j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                char c3 = s3.charAt(i + j + 1);
                // 动态转移方程
                dp[j + 1] = (c1 == c3 && dp[j + 1]) || (c2 == c3 && dp[j]);
            }
        }

        return dp[s2.length()];
    }


}
