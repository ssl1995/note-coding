package 刷题笔记.力扣.热门100.LC461_汉明距离;

/**
 * @author SongShengLin
 * @date 2022/2/26 11:22 PM
 * @description
 */
public class Solution {
    /**
     * 汉明距离
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：有两个位置不同
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     */
    public int hammingDistance(int x, int y) {
        // 将所以位置的1放在同一个数上=异或
        int num = x ^ y;
        int res = 0;
        while (num != 0) {
            // 判断末尾1，用&1
            res += (num & 1) == 1 ? 1 : 0;
            num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1;
        int y = 4;
        System.out.println(solution.hammingDistance(x, y));
    }
}
