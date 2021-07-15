package 剑指Offer.正序版.剑指Offer09_两个栈实现队列;

import java.util.LinkedList;

public class CQueue {

    private LinkedList<Integer> pushStack;
    private LinkedList<Integer> popStack;

    public CQueue() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }


    public void appendTail(int value) {
        // 添加:先push再倒入popStack
        pushStack.push(value);
        pushToPop(pushStack, popStack);
    }

    public int deleteHead() {
        // 判断两个栈非空才出队
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            return -1;
        }
        // 删除:先倒入,再删除
        pushToPop(pushStack, popStack);
        return popStack.pop();

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
