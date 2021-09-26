package 慕课网数据结构.链表.练习题.程序员面试指南.单向链表分成小中大;

import 慕课网数据结构.工具类.Node;

public class ListPartition1 {
    // 方法1:使用荷兰国旗改进，但是改变了稳定性
    public Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        // 1.记录链表长度
        int i = 0;
        Node cur = head;
        // 遍历计算出链表长度
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        // 2.生成链表长度的数组，遍历链表，放进数组
        Node[] nodeArr = new Node[i];
        cur = head;
        i = 0;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 3.荷兰国旗划分
        arrPartition(nodeArr, pivot);
        // 4.将数组改成链表，返回数组[0]
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1] = null;
        return nodeArr[0];
    }

    private void arrPartition(Node[] nodeArr, int pivot) {
        int lt = -1, gt = nodeArr.length, index = 0;
        while (index != gt) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++lt, index++);
            } else if (nodeArr[index].val > pivot) {
                swap(nodeArr, --gt, index++);
            } else {
                index++;
            }
        }
    }

    private void swap(Node[] nodeArr, int i, int j) {
        Node t = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = t;
    }
}
