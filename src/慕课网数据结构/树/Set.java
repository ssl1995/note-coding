package 慕课网数据结构.树;

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
