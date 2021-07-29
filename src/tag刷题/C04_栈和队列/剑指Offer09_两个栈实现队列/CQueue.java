package tag刷题.C04_栈和队列.剑指Offer09_两个栈实现队列;

import java.util.LinkedList;

public class CQueue {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }


    public void appendTail(int value) {
        // 添加:先push再倒入popStack
        stack1.push(value);
        pushToPop(stack1, stack2);
    }

    public int deleteHead() {
        // 判断两个栈非空才出队
        if (stack2.isEmpty() && stack1.isEmpty()) {
            return -1;
        }
        // 删除:先倒入,再删除
        pushToPop(stack1, stack2);
        return stack2.pop();

    }

    // push栈只压入,pop栈只压出
    private void pushToPop(LinkedList<Integer> pushStack, LinkedList<Integer> popStack) {
        // 只有pop栈空,才从push栈导入数据进pop栈
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
