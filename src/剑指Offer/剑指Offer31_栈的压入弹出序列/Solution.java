package 剑指Offer.剑指Offer31_栈的压入弹出序列;

import java.util.LinkedList;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 使用一个辅助栈,模拟pushed过程,途中匹配popped
        LinkedList<Integer> stack = new LinkedList<>();
        // i遍历popped数组
        int i = 0;
        for (int num : pushed) {
            // 一直往stack压入pushed元素
            stack.push(num);
            // 直到stack.peek与popped第i个元素匹配,stack就出栈,i++
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        // 辅助栈如果匹配完了为空就是true
        return stack.isEmpty();
    }
}
