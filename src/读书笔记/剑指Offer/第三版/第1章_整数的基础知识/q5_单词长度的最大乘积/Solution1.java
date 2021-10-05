package 读书笔记.剑指Offer.第三版.第1章_整数的基础知识.q5_单词长度的最大乘积;

/**
 * @author SongShengLin
 * @date 2021/9/10
 */
public class Solution1 {
    // 法2：利用位运算将二维数组降低成一维数组
    public int maxProduct(String[] words) {
        // 将之前的二维数组中的二维，使用1位的int类型来判断字符串是否相同
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                // 防止重复字符干扰结果,使用|=：0与0=0，其余为1，保证位运算
                flags[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 两个字符串相同，&后==1
                // 两个字符串不相同，&后==0
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    res = Math.max(res, prod);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "foo", "bar", "fxyz", "abcdef"};
        Solution1 s1 = new Solution1();
        int res = s1.maxProduct(words);
        System.out.println(res);
    }
}
