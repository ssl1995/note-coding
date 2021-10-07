package 读书笔记.剑指Offer.第三版.第6章_栈.q37_小行星碰撞;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/7 9:11 上午
 * @description
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int n : asteroids) {
            // 一直出栈：栈非空 且 栈顶>0 且 栈顶<n的绝对值(n此时必为负数，绝对值为-n)
            while (!stack.isEmpty() && stack.peek() > 0 && n < 0 && stack.peek() < -n) {
                stack.pop();
            }
            // 相同，一起爆炸，也要出栈
            if (!stack.isEmpty() && n < 0 && stack.peek() == -n) {
                stack.pop();
            } else if (stack.isEmpty() || stack.peek() < 0 || n > 0) {
                stack.push(n);
            }
        }
        // 保证相对次序不变
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
