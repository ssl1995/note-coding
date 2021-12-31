package 学习笔记.剑指Offer.第二版.第2章_面试需要的基础知识.q10_II_青蛙跳台阶;

public class JZ9 {
    // f(n)=f(n-1)+f(n-2)+...+f(0)
    // f(0)=1,f(1)=1,f(2)=2,f(3)=4
    // 变态跳台阶问题：规律从n=1开始,f(n)=2^(n-1)
    public int jumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        return (int) Math.pow(2, target - 1);
    }
}
