package 慕课网数据结构.链表;

public class LinkedList<E> {

    // head指向真实的第一个结点：缺点就是添加链表头操作有区别
    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<E>(null, null);
        size = 0;
    }

    /**
     * 获取链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表判空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 中间加一个结点
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,args illegal");
        }
        // 如果有dummyHead就不用判断if(index==0)
        Node<E> prev = dummyHead;
        // 将prev遍历到指定结点的前一个结点
        // 如果没有dummyHead，就是遍历到index-1
        // 如果是dummyHead，就是遍历到index=index-1+1
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 最佳写法：参看前面
        prev.next = new Node<E>(e, prev.next);
        size++;
    }

    /**
     * 表头添加元素
     */
    public void addFirst(E e) {
        /*
        dummyHead = new Node(e, dummyHead);
        ==以下代码
        Node node = new Node(e);
        node.next = head;
        head = node;
        */
        add(0, e);
    }

    /**
     * 最后添加一个结点
     */
    public void addLast(E e) {
        add(size, e);
    }

    public E getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index illegal");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return getIndex(0);
    }

    public E getLast() {
        return getIndex(size - 1);
    }

    /**
     * 更新链表操作
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed,index illegal");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断是否有该元素
     */
    public boolean contains(E e) {
        Node cur = dummyHead;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除一个元素
     */
    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed,index illegal");
        }
        Node<E> prev = dummyHead;
        // 找到index前一个结点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 待删除结点
        Node<E> delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        // size-1
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return delete(0);
    }

    public E removeLast() {
        return delete(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
