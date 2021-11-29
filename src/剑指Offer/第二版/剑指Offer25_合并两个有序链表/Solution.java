package 剑指Offer.第二版.剑指Offer25_合并两个有序链表;


import 剑指Offer.utils.ListNode;

public class Solution {
    // 和力扣21相同

    // 法1:迭代法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 设定一个哑结点,方便返回值
        ListNode dummyNode = new ListNode(-1);
        // cur指针指向每次比较的较小值结点
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null) {
            // 判断较小值,cur指向它
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // 判断完后移cur
            cur = cur.next;
        }
        // 循环结束,cur指向非空链表头部
        cur.next = (l1 == null) ? l2 : l1;
        return dummyNode.next;
    }

    // 法2:递归法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归结束情况1:某个链表遍历到了末尾
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 递归判断，每一次都返回最小值结点进递归栈
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            // 递归结束条件2:返回某个链表的最小值结点
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            // 递归结束条件2:返回某个链表的最小值结点
            return l2;
        }
    }


}
