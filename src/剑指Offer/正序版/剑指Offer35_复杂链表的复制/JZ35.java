package 剑指Offer.正序版.剑指Offer35_复杂链表的复制;


public class JZ35 {
    // 牛客不能用map传统解法，
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode next;
        // 原链表结点后接上一个复制label的新结点
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = pHead;
        RandomListNode curCopy;
        // 更新复制链表的random结点
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = (cur.random != null) ? cur.random.next : null;
            cur = next;
        }
        RandomListNode copyHead = pHead.next;
        cur = pHead;
        // 断开原结点和复制结点
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = (next != null) ? next.next : null;
            cur = next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        JZ35 jz35 = new JZ35();
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n1.random = n3;
        n2.next = n3;
        n2.random = n5;
        n3.next = n4;
        n3.random = n5.next;
        n4.next = n5;
        n4.random = n2;
        RandomListNode copyHead = jz35.Clone(n1);
        System.out.println(copyHead.label);
    }
}
