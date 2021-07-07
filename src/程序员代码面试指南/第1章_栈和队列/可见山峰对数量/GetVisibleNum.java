package 程序员代码面试指南.第1章_栈和队列.可见山峰对数量;

import java.util.Stack;

public class GetVisibleNum {

    public static int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        // 现在环中找到一个最大值，哪个索引都行
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        // 单调栈：要求从栈底到栈顶严格递减
        Stack<Record> stack = new Stack<>();
        // 将(最大值,1)放入栈底
        stack.push(new Record(arr[maxIndex]));
        // 从最大值的逆时针开始遍历
        int index = nextIndex(maxIndex, size);
        int res = 0;
        while (index != maxIndex) {
            // >就出栈
            while (stack.peek().value < arr[index]) {
                int k = stack.pop().times;
                res += 2 * k + getInternalSum(k);
            }
            // =就次数加1
            if (stack.peek().value == arr[index]) {
                stack.peek().times++;
            } else {
                // >就入栈
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(index, size);
        }
        // 清算第1阶段：弹出的记录不是栈中倒数2个位置
        while (stack.size() > 2) {
            int k = stack.pop().times;
            res += 2 * k + getInternalSum(k);
        }
        // 清算第2阶段：弹出的记录是倒数1个位置
        if (stack.size() == 2) {
            int k = stack.pop().times;
            // 以下的stack.peek().times就是栈底元素了
            res += (stack.peek().times == 1 ? k : k * 2) + getInternalSum(k);
        }
        // 任何环形结构都必然有第3阶段，因为我们是最大值在栈底
        // 清算第3阶段：弹出的记录是栈底
        res += getInternalSum(stack.pop().times);
        return res;
    }

    // 返回内部相同元素之间的可见山峰数
    public static int getInternalSum(int k) {
        // k>1:C(2,k)= (k * (k - 1) / 2)
        return k == 1 ? 0 : (k * (k - 1) / 2);
    }

    // 环形数组中当前位置为i，返回i的下一个索引
    private static int nextIndex(int i, int size) {
        return i < (size - 1) ? i + 1 : 0;
    }

}
