package 慕课网数据结构.链表.练习题.程序员面试指南.打印公共部分;

import 慕课网数据结构.工具类.ListNode;

/*
    打印两个链表的公共部分
 */
public class PrintCommonPart {

    public void printCommonPart(ListNode head1, ListNode head2) {
        System.out.println("Common part:");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
