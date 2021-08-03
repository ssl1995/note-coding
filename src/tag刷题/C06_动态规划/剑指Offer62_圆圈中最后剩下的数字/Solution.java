package tag刷题.C06_动态规划.剑指Offer62_圆圈中最后剩下的数字;

public class Solution {

    // 思考反推过程
    public int lastRemaining(int n, int m) {
        // n代表数组长度,n=长度1时,res=0
        int res = 0;
        for (int i = 2; i <= n; i++) {
            // res = (res +m) % n
            res = (res + m) % i;
        }
        return res;
    }
}
