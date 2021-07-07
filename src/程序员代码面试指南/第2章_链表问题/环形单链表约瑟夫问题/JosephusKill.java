package 程序员代码面试指南.第2章_链表问题.环形单链表约瑟夫问题;

public class JosephusKill {
    // 常规解法：时间复杂度（N*M）
    public Node josephusKill1(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        // 1.遍历获取head的前一个结点last=环形链表末尾结点
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        // 2.count计数
        int count = 0;
        // 3.不断遍历链表，只剩一个结点为止
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                // 4.删除一个结点后，计数器归零
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    // 进阶解法：根据链表长度和m，直接求出幸存结点
    public Node josephusKill2(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        // 1.链表长度从1开始记录
        Node cur = head.next;
        int tmp = 1;
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        // 2.获取最终活下来的结点
        tmp = getLive(tmp, m);
        // 3.head遍历到活下来的结点，直接循环自己
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    private int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        // 背公式：活下来结点 = （新结点+m-1）% i +1
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

}
