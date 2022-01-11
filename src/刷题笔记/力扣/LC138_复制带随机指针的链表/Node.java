package 刷题笔记.力扣.LC138_复制带随机指针的链表;

/**
 * @author SongShengLin
 * @date 2022/1/11 9:12 AM
 * @description
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
