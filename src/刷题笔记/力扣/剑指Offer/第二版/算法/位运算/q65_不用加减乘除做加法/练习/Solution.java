package 刷题笔记.力扣.剑指Offer.第二版.算法.位运算.q65_不用加减乘除做加法.练习;

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
