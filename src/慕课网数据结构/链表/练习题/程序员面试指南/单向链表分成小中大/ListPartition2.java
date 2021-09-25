package 慕课网数据结构.链表.练习题.程序员面试指南.单向链表分成小中大;

import 慕课网数据结构.工具类.Node;

public class ListPartition2 {
    // 方法2:使用分开的三个链表连接，保证稳定性和不需要额外空间
    public Node listPartition1(Node head, int pivot) {
        Node sH = null;// 小的头
        Node sT = null;
        Node eT = null;// 等于的头
        Node eH = null;
        Node bH = null;// 大于的头
        Node bT = null;
        Node next;
        // 分成3个链表
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }

            } else if (head.val > pivot) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            } else {
                if (eT == null) {
                    eT = head;
                    eH = head;
                } else {
                    eH.next = head;
                    eH = head;
                }
            }
            // head指向下一个结点
            head = next;
        }
        // 小的和相等的重新连接
        if (sT != null) {
            sT.next = eH;
            eT = (eT == null) ? sT : eT;
        }
        // 相等的和大的重新连接
        if (eT != null) {
            eT.next = bH;
        }
        return (sH != null) ? sH : (eT != null) ? eT : bH;
    }
}


