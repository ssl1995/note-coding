package 刷题笔记.力扣.热门100.LC139_单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/2/21 11:11 PM
 * @description
 */
public class Solution {
    /**
     * 单词拆分
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     * 注意，你可以重复使用字典中的单词。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i]:s的前i个字符能否被匹配
        boolean[] dp = new boolean[n + 1];
        // 空串表示可以被任意单词匹配
        dp[0] = true;

        Set<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // 内存循环只有匹配成功一次，就跳出到外层；开启下一个外层循环
                    break;
                }
            }
        }

        return dp[n];

    }
}
