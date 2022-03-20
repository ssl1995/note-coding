package 刷题笔记.力扣.代码随想录.C02_链表.LC707_设计链表;

/**
 * @author SongShengLin
 * @date 2022/3/19 08:59
 * @description
 */
public class MyLinkedList {

    /**
     * 链表长度，从1开始
     */
    private int size;
    /**
     * 虚拟头结点
     */
    private ListNode dummy;

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        dummy = new ListNode();
        size = 0;
    }

    public int get(int index) {
        // size从1开始，index从0开始
        if (index < 0 || size <= index) {
            return -1;
        }
        ListNode cur = dummy;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
//        System.out.println(cur.val);
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 超过长度就停止
        if (index > size) {
            return;
        }
        // 负数，就在第一个位置添加
        if (index < 0) {
            index = 0;
        }
        size++;

        ListNode pre = dummy;
        for (int i = 0; i <= index - 1; i++) {
            pre = pre.next;
        }

        ListNode node = new ListNode(val);
        node.next = pre.next;
        pre.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;

        ListNode pre = dummy;
        for (int i = 0; i <= index - 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);// 1->2->3
        list.get(1);// 2
        list.deleteAtIndex(1);// 1->3
        list.get(1);// 3
    }
}
