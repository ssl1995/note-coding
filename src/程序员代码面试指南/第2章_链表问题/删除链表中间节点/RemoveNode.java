package 程序员代码面试指南.第2章_链表问题.删除链表中间节点;

public class RemoveNode {
    // 问题1：删除链表中间节点
    public static Node removeMidNode(Node head) {
        // 1.只有一个结点或没有结点，就返回head
        if (head == null || head.next == null) {
            return head;
        }
        // 2.有两个结点，就删除头结点
        if (head.next.next == null) {
            return head.next;
        }
        // 3.有三个以上结点，规律：末尾移动两位，待删除结点移动一位
        Node pre = head;// 记录待删除结点前一个结点
        Node cur = head.next.next;
        // 4.奇数返回中间，偶数返回中间靠右：fast != null && fast.next != null
        // 5.奇数返回中间，偶数返回中间靠左：fast != null && fast.next.next != null
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    // 问题2：删除链表中a/b的结点，a<b,a>1
    public static Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        // 1.获取链表长度
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // 2.获取待删除结点在链表中的位置，是一个公式
        n = (int) Math.ceil((double) (a * n) / (double) b);
        // 3.n的值==1，删除头结点
        if (n == 1) {
            return head.next;
        }
        // 4.n>1，遍历到n=1的地方
        if (n > 1) {
            cur = head;
            // 5.找到待删除结点的前一个结点
            while (--n != 1) {
                cur = cur.next;
            }
            // 6.删除结点
            cur.next = cur.next.next;
        }
        return head;
    }
}
