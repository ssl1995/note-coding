package 剑指Offer.分类版.C04_栈和队列.剑指Offer31_栈的压入弹出序列;


public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 力扣题可以用LinkedList，但牛客不能用，简单题手写栈比较巩固知识
        int[] stack = new int[pushed.length];
        int index1 = 0;
        int index2 = 0;
        for (int numA : pushed) {
            stack[index1++] = numA;
            while (index1 != 0 && stack[index1 - 1] == popped[index2]) {
                index1--;
                index2++;
            }
        }
        return index1 == 0;
    }
}
