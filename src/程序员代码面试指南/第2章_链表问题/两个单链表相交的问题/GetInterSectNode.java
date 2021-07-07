package 程序员代码面试指南.第2章_链表问题.两个单链表相交的问题;


public class GetInterSectNode {
    // 主问题：判断两个链表是否相交，相交就返回第一个相交结点
    public Node getInterSectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 0.先判断两个链表是否有环，力扣142同题
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 1.无环链表相交，力扣160同题
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 2.有环链表相交
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        // 3.一个有环，一个无环，不可能相交
        return null;
    }

    // 解决问题3：判断有环链表的相交
    private Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 1.两个入环结点相同，相交点在未入环之前
        // 和问题2解决办法一致，结束条件是入环结点而已
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;// 记录差值
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            // cur1指向长的头结点，cur2指向慢的头结点
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {// 2.两个入环结点不相交，有2种情况
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == cur2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    // 解决问题2：判断无环链表的相交，与力扣160同题
    private Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 1.遍历两个链表，同时记录长度差值
        Node cur1 = head1;
        Node cur2 = head2;
        // 记录差值
        int n = 0;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        // 2.如果末尾节点不等，就肯定不相交
        if (cur1 != cur2) {
            return null;
        }
        // 3.cur1指向长的头结点，cur2指向慢的头结点
        cur1 = n > 0 ? head1 : head2;
        cur2 = (cur1 == head1) ? head2 : head1;
        // 差值此时取绝对值
        n = Math.abs(n);
        // 4.让长的先遍历len长-len短的距离
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        // 5.最后2个同时遍历，走到末尾就是相交结点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 解决问题1；判断一个链表是否有环,有就返回第一个入环结点，与力扣142同题
    private Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        // 1.使快慢指针第一次相遇
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 2.如果相遇，快指针必须重新指向head
        fast = head;
        // 3.规律：第二次相遇的时候，一定在第一个入环的节点处
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
