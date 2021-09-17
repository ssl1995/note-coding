package 力扣.剑指Offer.第二版.剑指Offer31_栈的压入弹出序列;


public class JZ21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        // 牛客bug：导包只能用ArrayList，还不如用int[]方便
        int[] stack = new int[pushA.length];
        int stackIndex = 0;
        int popAIndex = 0;
        for (int numA : pushA) {
            stack[stackIndex++] = numA;
            while (stackIndex != 0 && stack[stackIndex - 1] == popA[popAIndex]) {
                stackIndex--;
                popAIndex++;
            }
        }
        return stackIndex == 0;
    }
}
