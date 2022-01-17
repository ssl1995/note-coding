package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q65_不用加减乘除做加法.练习;

/**
 * @author SongShengLin
 * @date 2022/1/17 11:21 PM
 * @description
 */
public class Solution {
    public int add(int a, int b) {
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }
}
