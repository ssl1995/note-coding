package 剑指Offer.分类版.C09_数学.剑指Offer14_剪绳子I;

public class JZ67 {
    // 将长度为target的绳子等分为m段，使其乘积最大，m、target都是整数，target>1并且m>1，m<=target
    public int cutRope(int target) {
        if (target <= 3) {
            return target - 1;
        }
        int a = target / 3;
        int b = target % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * (2 * 2);
        }
        return (int) Math.pow(3, a) * 2;
    }
}
