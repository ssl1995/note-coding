package 牛客算法课.中级班.课5.Q03_相邻是4的倍数;

public class NearMultiple4Times {

    public static boolean nearMultiple4Times(int[] arr) {
        int a = 0; // 奇数有多少个
        int b = 0; // 不是4的倍数有多少个
        int c = 0; // 是4的倍数的数有多少个
        for (int num : arr) {
            if ((num & 1) != 0) {// 判断奇数
                a++;
            } else {
                if (num % 4 == 0) {
                    c++;
                } else {
                    b++;
                }
            }
        }
        // 奇：a
        // 不是4倍数：b
        // 4倍数：c
        // b=0,调整为:奇4奇4奇4奇...。规律c>=a-1
        // b!=0,调整为:222...2+4奇4奇4奇4奇...。规律c>=a
        return b == 0 ? (c >= a - 1) : (c >= a);
    }

}
