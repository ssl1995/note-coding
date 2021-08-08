package 牛客算法课.中级班.课1.Q02_苹果和牛羊吃草;

public class AppleMinBags {

    // 普通解法
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        // 6和8的最小公倍数是24
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {// 返回-1代表不能整除6
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    public static int minBagBase6(int rest) {
        // 返回-1代表不能整除6
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    // 最优解：给的参数n是int，返回值也是int，通过普通法+对数器，可以查看是否有规律
    // 因为给的参数n是int，返回值也是int，是可以找规律的
    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {// 奇数是肯定不行的
            return -1;
        }
        if (apple < 18) {// 苹果树<18，没有明确规律，枚举答案
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        // 苹果树>18，有明确规律
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " 需要袋子:" + minBags(i));
        }
//        int max = Integer.MAX_VALUE;
//        int testTime = 100000000;
//        for (int test = 0; test < testTime; test++) {
//            int apple = (int) (Math.random() * max);
//            if (minBags(apple) != minBagAwesome(apple)) {
//                System.out.println("error");
//            }
//        }

    }

}
