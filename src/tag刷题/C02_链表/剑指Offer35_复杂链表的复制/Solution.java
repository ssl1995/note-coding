package tag刷题.C02_链表.剑指Offer35_复杂链表的复制;


public class Solution {

    // 复制含有random结点的链表，常用方法是map,但是牛客禁用了Map包
    // 不用Map，用有限几个变量完成复制
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node curNext;
        // 原链表结点后接上一个复制val的结点
        while (cur != null) {
            curNext = cur.next;
            cur.next = new Node(cur.val);// 复制的是cur.val的值
            cur.next.next = curNext;
            cur = curNext;
        }
        // 更新复制链表的random结点
        cur = head;
        Node copyCur;
        while (cur != null) {
            curNext = cur.next.next;
            copyCur = cur.next;
            // 复制random指针时先判null
            copyCur.random = (cur.random != null) ? cur.random.next : null;
            cur = curNext;
        }
        cur = head;
        Node copyHead = cur.next;
        while (cur != null) {
            curNext = cur.next.next;
            copyCur = cur.next;
            cur.next = curNext;// cur连接会原来的next
            // copy结点连接时先判next是否null
            copyCur.next = (curNext != null) ? curNext.next : null;
            cur = curNext;
        }
        return copyHead;
    }
}
