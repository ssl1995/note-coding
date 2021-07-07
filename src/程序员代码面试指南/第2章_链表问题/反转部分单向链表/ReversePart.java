package 程序员代码面试指南.第2章_链表问题.反转部分单向链表;

public class ReversePart {

    public Node reversePart(Node head, int form, int to) {
        int len = 0;
        Node node1 = head;// 指向反转的第一个结点
        Node fPre = null;// from前一个结点
        Node tPos = null;// to后一个结点
        // 1.找出fPre、tPos结点，node1遍历获取出链表长度len
        while (node1 != null) {
            len++;
            fPre = (len == form - 1) ? node1 : fPre;
            tPos = (len == to + 1) ? node1 : tPos;
            node1 = node1.next;
        }
        // 2.判断条件满足1<=from<=to<=len
        if (head == null || form < 1 || to > len || form > to) {
            return head;
        }
        // 3.node1指向反转部分的第一个结点，不再改变
        node1 = (fPre == null) ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        // 4.node2到tPos-1遍历，反转链表
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        // 5.fPre != null,就fPre.next = node1;返回头结点
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        // 6.fPre != null,返回node1
        return node1;
    }
}
