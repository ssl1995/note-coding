package 程序员代码面试指南.第2章_链表问题.删除链表中间节点.力扣;

class Solution {
    // 237. 删除链表中的节点
    public void deleteNode(ListNode node) {
        // 本题参数只给了待删除node，并且归并不是末尾节点
        // 就不能遍历获得pre节点，于是先让node获取后面结点值然后再删除
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 奇数返回中间，偶数返回中间靠右：fast != null && fast.next != null
        // 奇数返回中间，偶数返回中间靠左：fast != null && fast.next.next != null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
