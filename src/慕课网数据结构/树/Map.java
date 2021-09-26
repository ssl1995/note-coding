package 慕课网数据结构.树;

/**
 * @Author ssl
 * @Date 2020/12/7 17:29
 * @Description
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
