package 剑指Offer.第二版.第4章_解决面试题的思路.q35_复杂链表的复制;


public class Solution {

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。
     * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        // 不使用辅助空间，直接在原结点后面连接一个复制结点
        // 第一次遍历，使原链表结点后接上一个复制val的结点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 第二次遍历，更新复制链表的random结点
        cur = head;
        Node copy;
        while (cur != null) {
            // 先记录cur后面的next、copy结点
            next = cur.next.next;
            copy = cur.next;
            // 复制random指针时先判null
            copy.random = (cur.random != null) ? cur.random.next : null;
            cur = next;
        }
        // 第三次遍历，使原链表和复制链表分离
        cur = head;
        // 记录复制链表的返回值
        Node copyHead = cur.next;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            // cur连接回原来的next
            cur.next = next;
            // copy结点连接时先判next是否null
            copy.next = (next != null) ? next.next : null;
            cur = next;
        }
        return copyHead;
    }
}
