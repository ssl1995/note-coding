package 读书笔记.数据结构By慕课网.队列.练习题.程序员代码面试指南.数组实现队列;

// 用数组实现一个大小固定的队列
public class ArrayToQueue {
    private Integer[] arr;
    // 用size解耦掉取余的过程
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayToQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = obj;
        end = (end == arr.length - 1) ? 0 : end + 1;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = start;
        start = (start == arr.length - 1) ? 0 : start + 1;
        return arr[tmp];
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

}