package 读书笔记.数据结构By慕课网.队列;

public interface Queue<E> {
    // 入队
    void enqueue(E e);

    // 出队
    E dequeue();

    // 获取对头元素
    E getFront();

    // 获取队列元素个数
    int getSize();

    // 判空
    boolean isEmpty();

}
