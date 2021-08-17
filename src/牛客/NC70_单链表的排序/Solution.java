package 牛客.NC70_单链表的排序;

import 剑指Offer.utils.ListNode;

public class Solution {

    // 题目:排序无序单链表，变成升序单链表
    public ListNode sortInList(ListNode head) {
        return mergeSortList(head);
    }

    // 归并排序单链表
    private ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMidNode(head);// 找到中点位置：链表奇数长返回中点，偶数长返回中间靠左位置
        ListNode next = middle.next;// 记录中点下一个位置
        middle.next = null;// 切割中点，一定要中间.next置空
        ListNode left = mergeSortList(head);// 以左边的头head开始递归
        ListNode right = mergeSortList(next);// 以右边的头next开始递归
        // 合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null & right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    // 找到链表中心：奇数是中点，偶数是中心靠左的位置
    private ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 画图，slow此时就指向奇数中点/偶数靠左的位置
        return slow;
    }

    // 找到链表中心：奇数是中点，偶数是中心靠右的位置
    private ListNode getMidNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // slow要多走一步，所以fast在head即可
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 画图，slow此时就指向奇数中点/偶数靠左的位置
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(solution.getMidNode(head).val);
        System.out.println(solution.getMidNode1(head).val);
    }


}
