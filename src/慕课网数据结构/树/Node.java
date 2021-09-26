package 慕课网数据结构.树;

/**
 * @Author ssl
 * @Date 2020/12/7 9:59
 * @Description
 */
public class Node<E extends Comparable<E>> {
    public E e;
    public Node<E> left;
    public Node<E> right;

    public Node(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }
}
