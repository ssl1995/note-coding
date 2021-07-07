package 程序员代码面试指南.第1章_栈和队列.用栈求解汉诺塔;

import java.util.Stack;

public class HanoiProblem2 {

    public static int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        // 3个栈都加入最大值， 保证fStack.peek() < tStack.peek()不发生异常
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        // 保证栈顶到栈底是从小到大
        for (int i = num; i > 0; i--) {
            ls.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rs.size() <= num) {
            step += fStackToStack(record, Action.MToL, Action.LToM, ls, ms, left, mid);
            step += fStackToStack(record, Action.LToM, Action.MToL, ms, ls, mid, left);
            step += fStackToStack(record, Action.RToM, Action.MToR, ms, rs, mid, right);
            step += fStackToStack(record, Action.MToR, Action.RToM, rs, ms, right, mid);
        }
        return step;
    }

    // 定义行为函数
    public enum Action {
        No, LToM, MToL, MToR, RToM
    }

    // 出入栈函数
    public static int fStackToStack(Action[] record, Action preNoAct, Action nowAct,
                                    Stack<Integer> fStack, Stack<Integer> tStack,
                                    String from, String to) {
        // 不相邻原则 && 小压大原则
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            // 满足条件就入栈，打印
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            // 更改行为
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int step = hanoiProblem2(2, "left", "mid", "right");
        System.out.println("It will move " + step + " steps");
    }

}
