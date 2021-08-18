package 牛客算法课.基础班提升.课5_位运算题.Q01_获得两个有符号数最大值;

public class GetMax {


    // Q:判断有符号的a和b的最大值,不能用任何判断语句

    // 法1:差值的符号位是正还是负来判断，因为符号位是互斥的
    public static int getMax1(int a, int b) {
        int c = a - b;// 缺陷是算差值可能会溢出
        int signC = sign(c);// 获得c的符号位，1代表a大，0代表b大
        int reverseSignC = reverse(signC);// 符号位互斥值
        // 假设a=2,b=1,signC=1,reverseSignC=0
        // 返回 2*1+1*0=2=a
        return a * signC + b * reverseSignC;// 利用互斥可以求出谁大谁小
    }

    // 返回0代表负数，返回1代表非负数
    public static int sign(int n) {
        // 有符号数第32位代表正负数,0代表正数,1代表负数
        // 第32位是0(正数) ^ 1 = 1, 1代表非负数
        // 第32位是1(负数) ^ 1 = 0, 0代表负数
        return (n >> 31) ^ 1;
    }

    // 0变1,1变0
    public static int reverse(int n) {
        return n ^ 1;
    }

    // 法2:溢出啦也不会出错
    public static int getMax2(int a, int b) {
        int c = a - b;// 假设a=2,b=1
        int signA = sign(a);// a是非负数为1
        int signB = sign(b);// b是非负数为1
        int signC = sign(c);// 差值是非负数为1
        int isDif = signA ^ signB;// a、b符号相同返回0;不相同返回1
        int isSame = reverse(isDif);// a、b符号相同返回1;不相同返回0
        /*
            假设最大值是a,那么返回a的条件
                1.a和b符号位相同(isSameSignAB),且a-b>=0(signC),返回a
                2.a和b符号位不相同(isDifSignAB),且a>0(signA),返回a
         */
        int returnA = isDif * signA + isSame * signC;
        int returnB = reverse(returnA);// 返回b的条件和a互斥
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));

    }

}
