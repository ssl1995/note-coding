package 刷题笔记.力扣.热门100.LC206_反转单链表;

import 刷题笔记.力扣.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/12/1 5:40 下午
 * @description
 */
public class Solution {

    /**
     * 反转单链表
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            // 先记录后继结点
            ListNode next = cur.next;
            // 反转
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 返回pre，不是cur
        return pre;
    }
}
