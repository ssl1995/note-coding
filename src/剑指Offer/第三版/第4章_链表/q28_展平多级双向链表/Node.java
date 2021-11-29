package 剑指Offer.第三版.第4章_链表.q28_展平多级双向链表;

/**
 * @author SongShengLin
 * @date 2021/9/27 9:17 上午
 * @description
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }
}
