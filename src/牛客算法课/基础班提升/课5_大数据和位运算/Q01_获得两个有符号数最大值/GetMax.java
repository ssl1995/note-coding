package 牛客算法课.基础班提升.课5_大数据和位运算.Q01_获得两个有符号数最大值;

public class GetMax {


    // Q:判断有符号的a和b的最大值,不能用任何判断语句

    // 常规方法:判断差值的符号位是正还是负
    // 缺陷:a-b可能会溢出,但是得到了互斥条件和加号,可以用于判断
    public static int getMax1(int a, int b) {
        int c = a - b;// c>0，返回a;c<0,返回b
        int signC = sign(c);// 获得c的符号位
        int reverseSignC = reverse(signC);
        // 假设a=2,b=1,signC=1,reverseSignC=0
        // 返回 2*1+1*0=2=a
        return a * signC + b * reverseSignC;
    }

    // 非负数，返回1；负数返回0
    public static int sign(int n) {
        // 有符号数,0代表正数,1代表负数
        // 0 & 1 = 0,再反转为1,此时让1代表非负数
        // 1 & 1 = 1,再反转为0,此时让0代表负数
        return reverse((n >> 31) & 1);
    }

    // 0返回1,1返回0
    public static int reverse(int n) {
        return n ^ 1;
    }

    // 改进后的方法:溢出啦也不会出错
    public static int getMax2(int a, int b) {
        int c = a - b;// 假设a=2,b=1
        int signA = sign(a);// a是非负数为1
        int signB = sign(b);// b是非负数为1
        int signC = sign(c);// 差值是非负数为1
        int isDifSignAB = signA ^ signB;// a、b符号相同返回0;不相同返回1
        int isSameSignAB = reverse(isDifSignAB);// 上一个结果取反，两者互斥
        /*
            假设最大值是a,那么返回a的条件
                1.a和b符号位相同(isSameSignAB),且a-b>=0(signC),返回a
                2.a和b符号位不相同(isDifSignAB),且a>0(signA),返回a
         */
        int returnA = isDifSignAB * signA + isSameSignAB * signC;
        // 返回b的情况和返回a互斥,取反即可
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
