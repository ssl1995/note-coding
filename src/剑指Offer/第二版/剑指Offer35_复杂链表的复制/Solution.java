package 剑指Offer.第二版.剑指Offer35_复杂链表的复制;


public class Solution {

    // 复制含有random结点的链表，常用方法是map,但是牛客禁用了Map包
    // 不用Map，用有限几个变量完成复制
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        // 第一次遍历，使原链表结点后接上一个复制val的结点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);// 复制的是cur.val的值
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
            cur = next;// cur移动到next
        }
        // 第三次遍历，使原链表和复制链表分离
        cur = head;
        Node copyHead = cur.next;// 记录复制链表的返回值
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;// cur连接回原来的next
            // copy结点连接时先判next是否null
            copy.next = (next != null) ? next.next : null;
            cur = next;
        }
        return copyHead;
    }
}
