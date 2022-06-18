package 刷题笔记.力扣.热门100.LC206_反转单链表;

import 刷题笔记.力扣.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/6/18 17:38
 * @description
 */
public class Solution1 {

    /**
     * 反转单链表
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 保存最后结点= 反转后的头结点
        ListNode res = reverseList(head.next);
        // 这里的head = 倒数第二个节点
        head.next.next = head;
        head.next = null;
        return res;
    }
}
