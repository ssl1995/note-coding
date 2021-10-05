package 读书笔记.数据结构By慕课网.队列;

/**
 * LoopQueue：浪费一个空间+使用size
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    // tail指向队尾的后一个位置
    private int front, tail;
    // size记录队列长度
    private int size;

    public LoopQueue(int capacity) {
        // 由于堆满情况会空余一个位置，所以数组长度初始化+1
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 入队：判断队满+入队操作
     */
    @Override
    public void enqueue(E e) {
        // 队满就扩容
        // 队满：tail+1 = front队列满
        // 队空：tail = front队列空
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        // 入队尾
        data[tail] = e;
        // 队尾指针移动一个单位
        tail = (tail + 1) % data.length;
        // 数组元素+1
        size++;
    }


    /**
     * 出队:判空+出队+判断缩容
     */
    @Override
    public E dequeue() {
        // 判空
        if (isEmpty()) {
            throw new IllegalArgumentException("队列已经为空，不能出队列");
        }
        // 出队
        E deElement = data[front];
        front = (front + 1) % data.length;
        size--;
        // 缩容条件：队列长度=数组长度/4 且 数组长度/2存在(防止队列1时不能缩容)
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return deElement;
    }

    /**
     * 获取队首元素：判空+获取队首元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列空，不能获取对头元素");
        }
        return data[front];
    }

    /**
     * 获取队列长度：使用了size的好处，直接返回size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判空条件：头指针 == 尾指针
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取数据最大容量
     */
    public int getCapacity() {
        // 初始化时候+1的容量，所以这里长度-1
        return data.length - 1;
    }

    /**
     * 扩容
     */
    private void resize(int newCapacity) {
        // 老方法：初始化容量+1
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 遍历方式1：
        for (int i = 0; i < size; i++) {
            // 新数组：0 ； 旧数组:front
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        // 遍历方式2：
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if (((i + 1) % data.length) != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
