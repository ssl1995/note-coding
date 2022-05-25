package 刷题笔记.力扣.代码随想录.C03_哈希表.Q7_续金信;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 10:12 AM
 * @Describe:
 */
public class Solution {
    /**
     * LC383 续金信
     * 输入：magazine = "aa", magazine = "aab"
     * 输出：true
     * 注意：1.都是小写字母；2.magazine在magazine只能用一次
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 都是小写就固定了长度
        int[] map = new int[26];
        int temp;
        for (char c : magazine.toCharArray()) {
            temp = c - 'a';
            map[temp]++;
        }

        for (char c : ransomNote.toCharArray()) {
            temp = c - 'a';
            if (map[temp] > 0) {
                // 只能使用一次，就减一
                map[temp]--;
            } else {
                return false;
            }
        }

        return true;
    }
}
