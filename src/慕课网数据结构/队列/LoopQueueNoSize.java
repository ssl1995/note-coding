package 慕课网数据结构.队列;


/**
 * LoopQueueNoSize：浪费一个空间+不使用size
 */
public class LoopQueueNoSize<E> implements Queue<E> {
    private E[] data;
    private int front, tail;

    public LoopQueueNoSize(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueNoSize() {
        this(10);
    }


    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列已经为空，不能再出队");
        }
        E res = data[front];
        // 请将出队的元素位置判null
        data[front] = null;
        front = (front + 1) % data.length;
        // 缩容
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列已经为空");
        }
        return data[front];
    }

    /**
     * 完全不使用size获取队列长度，只使用front和tail判断所以的逻辑
     */
    @Override
    public int getSize() {
        // tail>=front，队列长度就是tail-front
        // tail<front，队列长度tail - front + data.length = data.length -(front-tail)
        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            // 注意：data[(front + i) % data.length]
            newData[i] = data[(front + i) % data.length];
        }
        // 返回值为void，所以需要引用传递
        data = newData;
        // 队头重置为0
        front = 0;
        // 队尾为原队列长度
        tail = getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueNoSize<Integer> queue = new LoopQueueNoSize<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}

