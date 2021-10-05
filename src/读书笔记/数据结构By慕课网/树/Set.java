package 读书笔记.数据结构By慕课网.树;

/**
 * @Author ssl
 * @Date 2020/12/7 16:00
 * @Description
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean isEmpty();

    int getSize();

    boolean contains(E e);
}
