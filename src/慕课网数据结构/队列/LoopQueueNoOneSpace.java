package 慕课网数据结构.队列;

/**
 * LoopQueue1：不浪费1个空间的循环队列
 * 改动如下：
 * 1.初始化数组
 * 2.是否为空
 * 3.入队时扩容操作及resize
 * 4.toString遍历队列方法
 */
public class LoopQueueNoOneSpace<E> implements Queue<E> {
    // 判空不浪费一个空间，但依然使用size标记队列长度
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueueNoOneSpace(int capacity) {
        // 改1：由于不浪费一个空间，所以不用初始化+1的
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
    }

    public LoopQueueNoOneSpace() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }


    @Override
    public void enqueue(E e) {
        // 改3：我们不再使用front和tail之间的关系来判断队列是否为满，而直接使用size
        if (size == getCapacity()) {
            resize((getCapacity() * 2));
        }
        data[size] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("不能出队，因为队列为空");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("不能出队，因为队列为空");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public boolean isEmpty() {
        // 改2：队列为空
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        // 改4：遍历方式
        for (int i = 0; i < size; i++) {
            res.append(data[(front + i) % data.length]);
            if ((i + front + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

}
