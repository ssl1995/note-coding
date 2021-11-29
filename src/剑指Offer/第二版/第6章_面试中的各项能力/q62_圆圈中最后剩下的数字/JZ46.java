package 剑指Offer.第二版.第6章_面试中的各项能力.q62_圆圈中最后剩下的数字;

public class JZ46 {

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 && m == 0) {// 牛客规定，没有环和报数，返回-1
            return -1;
        }
        int res = 0;
        for (int len = 2; len <= n; len++) {
            res = (res + m) % len;
        }
        return res;
    }
}
