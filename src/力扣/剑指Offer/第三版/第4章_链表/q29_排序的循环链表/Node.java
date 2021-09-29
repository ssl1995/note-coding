package 力扣.剑指Offer.第三版.第4章_链表.q29_排序的循环链表;

/**
 * @author SongShengLin
 * @date 2021/9/29 9:16 上午
 * @description
 */
public class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
