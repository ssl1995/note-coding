package 学习笔记.读书笔记.程序员代码面试指南.第1章_栈和队列.q06_用栈来求解汉诺塔问题.栈方法;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/1/9 11:16 PM
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int steps = hanoiProblem(num, "left", "mid", "right");
        System.out.println("It will move " + steps + " steps.");
    }

    public static int hanoiProblem(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        LinkedList<Integer> lS = new LinkedList<>();
        LinkedList<Integer> mS = new LinkedList<>();
        LinkedList<Integer> rS = new LinkedList<>();
        // 防止小压大原则导致数据越界
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        // 初始化左栈
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int steps = 0;
        while (rS.size() != num + 1) {
            steps += fStackToStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            steps += fStackToStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            steps += fStackToStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            steps += fStackToStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return steps;
    }

    private static int fStackToStack(Action[] record, Action preNoAct, Action nowAct
            , LinkedList<Integer> fStack, LinkedList<Integer> tStack
            , String from, String to) {
        // 假设前一个动作是L->M,根据小压大原则,L->M不会发生;根据相邻不可逆原则,M->L不会发生
        // 那么下一个动作只能是M->R or R->M中的任意一个
        // 结论：前一个动作是preNoAct，那么剩下3个动作只能一个会发生 且 满足小压大原则
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

}


enum Action {
    /**
     * 行为枚举
     */
    No, LToM, MToL, MToR, RToM
}