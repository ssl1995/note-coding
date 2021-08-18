package 牛客算法课.基础班提升.课5_位运算题.Q02_判断2和4的幂;

public class Power {
    // 是不是2的幂
    public static boolean is2Power(int n) {
        // 假设n=2,那么二进制n=010,n-1=001
        // 010 & 001 = 0,说明是2的幂
        return (n & (n - 1)) == 0;
    }

    // 是不是4的幂
    public static boolean is4Power(int n) {
        /*
            4的幂:
                1.首先的是2的幂:(n & (n - 1)) == 0
                1.4的幂的规律: n & 10101...010101必为非0
                    4^0=1,4^1=4,4^2=16...依次换成二进制位:1,100,1000,100000,每次1左移两个单位
                10101...010101换成32位16进制是0x55555555

         */
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(is2Power(2));
        System.out.println(is4Power(4));
    }

}
