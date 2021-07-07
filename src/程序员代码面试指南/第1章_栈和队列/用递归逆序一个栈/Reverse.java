package 程序员代码面试指南.第1章_栈和队列.用递归逆序一个栈;

import java.util.Stack;

public class Reverse {
    public static void reverse(Stack<Integer> stack) {
        // 1.递归结束:因为get操作有弹出，肯定是栈空为结束
        if (stack.isEmpty()) {
            return;
        }
        // 2.想成普通方法，一次获得栈底元素
        int i = getAndRemoveLastElement(stack);
        // 3.递归逆序入栈
        reverse(stack);
        stack.push(i);
    }

    // 返回栈底元素
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        // 1.先弹出栈顶元素
        int result = stack.pop();
        // 2.递归结束：栈为空，返回当前弹出元素
        if (stack.empty()) {
            return result;
        } else {
            // 3.这里递归得到last = 栈底元素
            int last = getAndRemoveLastElement(stack);
            // 4.每一次都原栈的元素返回去
            stack.push(result);
            // 5.每一次递归返回都是最后一个元素
            return last;
        }
    }
}
