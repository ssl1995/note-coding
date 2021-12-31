package 读书笔记.剑指Offer.第二版.第4章_解决面试题的思路.q31_栈的压入弹出序列;


public class Solution {

    /**
     * 给一个压入数组和一个弹出数组，判断两者是不是一个栈的压入与弹出序列
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int i1 = 0;
        int i2 = 0;
        for (int numA : pushed) {
            stack[i1++] = numA;
            // 如果栈中还有元素，并且栈顶元素等于弹出数组，i1前移，i2后移
            while (i1 != 0 && stack[i1 - 1] == popped[i2]) {
                i1--;
                i2++;
            }
        }
        // 最后判断i1是否为0
        return i1 == 0;
    }
}
