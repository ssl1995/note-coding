package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q64_求1加到n.练习;

/**
 * @author SongShengLin
 * @date 2022/1/17 11:09 PM
 * @description
 */
public class Solution {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
