package 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q01_链表的环问题;


import 牛客算法课.基础班.课4_链表.Q02_链表反转.Node;

public class GetInterSectNode {
    // 主问题：判断两个链表是否相交，相交就返回第一个相交结点，无就返回空节点
    public Node getInterSectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 先判断两个链表是否有环，返回入环结点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 情况1.无环链表相交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 情况2:有环链表相交
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        // 情况3:一个有环，一个无环，不可能相交
        return null;
    }

    // 判断一个链表是否有环,有就返回第一个入环结点，无就返回空结点
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

    // 判断无环链表的相交，返回相交结点
    private Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 1.遍历两个链表，同时记录长度差值和尾结点是否相同
        Node cur1 = head1;
        Node cur2 = head2;
        // 记录差值
        int len = 0;
        while (cur1 != null) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len--;
            cur2 = cur2.next;
        }
        // 两个无环链表,如果末尾节点不等，就肯定不相交
        if (cur1 != cur2) {
            return null;
        }
        // 2.让长链表先走两个链表的长度差的绝对值步数
        // cur1指向长的头结点，cur2指向慢的头结点
        cur1 = len > 0 ? head1 : head2;
        cur2 = (cur1 == head1) ? head2 : head1;
        // 注意:差值此时取绝对值
        len = Math.abs(len);
        while (len != 0) {
            len--;
            cur1 = cur1.next;
        }
        // 3.此时两个节点同时走,相交时就是无环链表入环结点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 判断有环链表的相交,已知两个链表的入环结点loop1,loop2
    private Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 情况1:两个有环链表入环结点相同,第一个相交结点在未入环结点前面
        if (loop1 == loop2) {
            // 修改遍历指针结束条件为入环结点,其余与判断无环链表的入环方法一样,
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            // 修改遍历指针结束条件为入环结点即可
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
        } else {// 情况2:两个有环链表入环结点不相同,有如下两种情况
            cur1 = loop1.next;
            while (cur1 != loop1) {
                // 1:如果两个有环链表终止位置能相遇,返回任意一个都是相交结点
                if (cur1 == cur2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            // 2:如果两个有环链表终止位置也不同,那么不可能相交
            return null;
        }
    }
}
