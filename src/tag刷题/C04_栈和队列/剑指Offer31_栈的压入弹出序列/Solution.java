package tag刷题.C04_栈和队列.剑指Offer31_栈的压入弹出序列;


public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 力扣题可以用LinkedList，但牛客不能用，简单题手写栈比较巩固知识
        int[] stack = new int[pushed.length];
        int stackIndex = 0;
        int popAIndex = 0;
        for (int numA : pushed) {
            stack[stackIndex++] = numA;
            while (stackIndex != 0 && stack[stackIndex - 1] == popped[popAIndex]) {
                stackIndex--;
                popAIndex++;
            }
        }
        return stackIndex == 0;
    }
}
