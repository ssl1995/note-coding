package 读书笔记.数据结构By慕课网.栈;


import 读书笔记.数据结构By慕课网.链表.LinkedList;

/**
 * 自己的链表实现一个栈
 */
public class StackByList<E> {
    private LinkedList<E> list;

    public StackByList() {
        list = new LinkedList<E>();
    }


    public void push(E e) {
        list.addFirst(e);
    }


    public E pop() {
        return list.removeFirst();
    }


    public E peek() {
        return list.getFirst();
    }


    public int getSize() {
        return list.getSize();
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
