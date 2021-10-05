package 读书笔记.数据结构By慕课网.栈;

public class StackByArray {
    private Integer[] arr;
    private Integer index;

    public StackByArray(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        // index指向第一个无元素的位置=有元素的下一个位置
        index = 0;
    }

    public void push(int obj) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[index++] = obj;
    }

    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--index];
    }


    public Integer peek() {
        if (index == 0) {
            return null;
        }
        // index指向第一个无元素的位置=有元素的下一个位置
        return arr[index - 1];
    }

    public Integer getSize() {
        return index;
    }

    public Boolean isEmpty() {
        return index == 0;
    }
}

