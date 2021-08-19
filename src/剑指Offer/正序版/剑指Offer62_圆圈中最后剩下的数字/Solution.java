package 剑指Offer.正序版.剑指Offer62_圆圈中最后剩下的数字;

public class Solution {

    // 思考反推过程
    public int lastRemaining(int n, int m) {
        // 初始化：反推，最后剩下的数字下标为0
        int index = 0;
        for (int i = 2; i <= n; i++) {// 从倒数第二轮开始反推
            // 下一轮下标=(当前下标+报数长度)%上一轮剩余数字个数
            index = (index + m) % i;
        }
        // 数字为0到n-1,倒推回去后的索引既是下标也是数字本身
        return index;
    }
}
