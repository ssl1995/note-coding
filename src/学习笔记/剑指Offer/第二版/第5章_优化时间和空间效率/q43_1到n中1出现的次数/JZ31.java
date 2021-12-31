package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q43_1到n中1出现的次数;

public class JZ31 {
    // 从1到n中，含有数字1的出现的次数
    // 比如：1~13中包含1的数字有1、10、11、12、13因此共出现6次

    // 最笨的方法，从1到n统计，每个数中1出现的次数，但是会超时
    // 所以找规律，用low、cur、high、digit、res5个变量找规律
    public int NumberOf1Between1AndN_Solution(int n) {
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        int digit = 1;
        int res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else if (cur > 1) {
                res += (high + 1) * digit;
            }
            low = cur * digit + low;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        return res;
    }

}
