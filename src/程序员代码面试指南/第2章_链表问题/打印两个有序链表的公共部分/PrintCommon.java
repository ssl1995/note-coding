package 程序员代码面试指南.第2章_链表问题.打印两个有序链表的公共部分;

/*
    剑指 Offer 52. 两个链表的第一个公共节点
    注意：该两个链表不一定有序
 */
public class PrintCommon {
    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
