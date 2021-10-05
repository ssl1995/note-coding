package 读书笔记.数据结构By慕课网.链表;

public class Node<E> {
    public E e;
    public Node<E> next;

    public Node(E e, Node<E> next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e) {
        this(e, null);
    }

    public Node() {
        this(null, null);
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
