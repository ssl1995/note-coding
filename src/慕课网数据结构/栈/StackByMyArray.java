package 慕课网数据结构.栈;


import 慕课网数据结构.数组.Array;

public class StackByMyArray<E> {
    // 调用自己的数组类
    Array<E> array;

    public StackByMyArray(int capacity) {
        array = new Array<>(capacity);
    }

    public StackByMyArray() {
        array = new Array<>();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:").append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
