package 刷题笔记.力扣.LC138_复制带随机指针的链表;

/**
 * @author SongShengLin
 * @date 2022/1/11 9:12 AM
 * @description
 */
public class Solution {
    /**
     * 复制一个带有随机指针的链表
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        cur = head;
        Node copyHead = cur.next;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return copyHead;
    }
}
