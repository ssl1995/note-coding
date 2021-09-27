package 力扣.剑指Offer.第三版.第4章_链表.q28_展平多级双向链表;


/**
 * @author SongShengLin
 * @date 2021/9/27 9:16 上午
 * @description 展平多级双向链表
 */
public class Solution {
    // 展平多级链表
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    // 获得head为头结点链表的尾结点，并且展平多级节点
    private Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            // node有子链表，就获得子链表的头结点和尾结点
            if (node.child != null) {
                Node child = node.child;
                // 递归获得子链表的尾结点
                Node childTail = flattenGetTail(child);

                // node的next和child指针都要改变
                node.next = child;
                // 删除掉node的所有子链表指针
                node.child = null;
                // 子链表的前驱指向当前节点
                child.prev = node;
                // 如果node有后继结点，就改变后继节点和子链表尾结点
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                // node有子链表，tail就指向子链表末尾
                tail = childTail;
            } else {
                // node无子链表，tail就指向node
                tail = node;
            }
            // 循环里，一定要后移node
            node = node.next;
        }
        // 整个函数，返回tail
        return tail;
    }
}
