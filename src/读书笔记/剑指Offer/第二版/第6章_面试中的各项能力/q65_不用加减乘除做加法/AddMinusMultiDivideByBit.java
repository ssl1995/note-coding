package 读书笔记.剑指Offer.第二版.第6章_面试中的各项能力.q65_不用加减乘除做加法;

public class AddMinusMultiDivideByBit {
    // Q:不能使用算术运算符，分别实现a和b的加、减、乘、除,不用考虑溢出

    // 加法:无进位相加(^)+进位的结果(&<<1)
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {// 当进位为0时,返回此时的sum
            sum = a ^ b;// sum:记录^的结果
            b = (a & b) << 1;// b:进位的结果
            // 下一轮 a=sum
            a = sum;
        }
        return sum;
    }


    // 减法:a+(b的相反数)
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    // 获得一个数相反数
    public static int negNum(int n) {
        // 取反+1=该数的相反数
        return add(~n, 1);
    }

    // 乘法:左移a,无符号右移b
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            // b末尾是1,说明要加1个a
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            // a有符号左移一位
            a <<= 1;
            // b无符号右移一位,因为需要将b磨成0,所以是无符号右移缩小
            b >>>= 1;
        }
        return res;
    }

    // 判断是否是负数
    public static boolean isNeg(int n) {
        return n < 0;
    }

    // 除法:只用考虑a和b是正数的情况
    public static int div(int a, int b) {
        // 将a、b转换成正数
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i >= 0; i = minus(i, 1)) {
            // 让x右移去够到y
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("divisor is 0");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            int res = div(add(a, 1), b);
            return add(res, div(minus(a, multi(res, b)), b));
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
//        int a = (int) (Math.random() * 100000) - 50000;
//        int b = (int) (Math.random() * 100000) - 50000;
//        System.out.println("a = " + a + ", b = " + b);
//        System.out.println(add(a, b));
//        System.out.println(a + b);
//        System.out.println("=========");
//        System.out.println(minus(a, b));
//        System.out.println(a - b);
//        System.out.println("=========");
//        System.out.println(multi(a, b));
//        System.out.println(a * b);
//        System.out.println("=========");
//        System.out.println(divide(a, b));
//        System.out.println(a / b);
//        System.out.println("=========");
//
//        a = Integer.MIN_VALUE;
//        b = 32;
//        System.out.println(divide(a, b));
//        System.out.println(a / b);
        int a = 1;
        System.out.println(negNum(a));
    }

}
