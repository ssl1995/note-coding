package 学习笔记.剑指Offer.专项突击版.第4章_链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author songshenglin
 * @date 2021/9/21 10:40
 * @description
 */
public class DummyNode {
    // 单链表添加结点：没有哨兵
    public static ListNode appendNoDummy(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        // 没有哨兵结点，就要判空
        if (head == null) {
            return newNode;
        }

        // 没有哨兵，遍历结点从head开始
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return newNode;
    }

    // 单链表添加结点：使用哨兵，统一添加结点逻辑
    public static ListNode appendOfDummy(ListNode head, int val) {
        // 哨兵结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode newNode = new ListNode(val);
        // 有哨兵，遍历结点从哨兵开始，就可以统一逻辑
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return newNode;
    }

    // 单链表删除：不使用哨兵
    public static ListNode deleteNoDummy(ListNode head, int val) {
        // 没有哨兵结点，就要判空和判断是否删除第一个结点
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        // 没有哨兵，从头结点开始遍历
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                // 删除完结点，记得停止循环
                break;
            }
            node = node.next;
        }
        return head;
    }

    // 单链表删除：使用哨兵
    public static ListNode deleteOfDummy(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 有哨兵，遍历结点从哨兵开始，就可以统一逻辑
        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                // 删除完结点，记得停止循环
                break;
            }
            node = node.next;
        }
        return head;
    }

}
