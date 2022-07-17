package 刷题笔记.力扣.剑指Offer.第二版.算法.位运算.q64_求1加到n.练习;

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
