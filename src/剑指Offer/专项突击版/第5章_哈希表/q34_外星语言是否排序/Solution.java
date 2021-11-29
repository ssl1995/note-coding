package 剑指Offer.专项突击版.第5章_哈希表.q34_外星语言是否排序;

/**
 * @author SongShengLin
 * @date 2021/10/6 12:02 下午
 * @description
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderArr)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断word1是否按照orderArr规则，排在word2前面
     */
    private boolean isSorted(String word1, String word2, int[] orderArr) {
        int i = 0;
        for (; i < word1.length() && i < word2.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            // 每次循环只用判断一次就出结果
            if (orderArr[c1 - 'a'] < orderArr[c2 - 'a']) {
                return true;
            }
            if (orderArr[c1 - 'a'] > orderArr[c2 - 'a']) {
                return false;
            }
        }
        // 循环结束，还没出结果，判断i是否到达单词1末尾
        return i == word1.length();
    }
}
