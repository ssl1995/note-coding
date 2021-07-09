package 牛客算法课.初级班.课12_位运算;

public class GetMax {


    // 非负数，返回1；负数返回0
    public static int sign(int n) {
        // int类型符号位1：表示负数；符号位0：表示正数
        return reverse((n >> 31) & 1);
    }

    // 0返回1,1返回0
    public static int reverse(int n) {
        return n ^ 1;
    }

    /**
     * 方法一：互斥条件，不用if-else判断，但是a-b可能溢出就不对
     */
    public static int getMax1(int a, int b) {
        int c = a - b;// c>0，返回a;c<0,返回b
        int signC = sign(c);// 获得c的符号位
        int reverseSignC = reverse(signC);
        return a * signC + b * reverseSignC;
    }

    /**
     * 方法二：
     */
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;// a、b符号相同返回0；不相同返回1
        int sameSab = reverse(difSab);// 上一个结果取反，两者互斥
        // 返回a条件1 => sameSab * sc：a和b符号相同且c>=0
        // 返回a条件2 => difSab * sa：a和b符号不相同且a>0
        // 两个条件互斥，相加
        int returnA = difSab * sa + sameSab * sc;
        int returnB = reverse(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));

    }

}
