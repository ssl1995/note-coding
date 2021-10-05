package 读书笔记.数据结构By慕课网.哈希表.练习题.程序员面试指南.RandomPool设计;

import java.util.HashMap;

public class Pool<K> {
    private HashMap<K, Integer> k1;
    private HashMap<Integer, K> k2;
    private int size;// map中是无序的，使用size保证两个map能才常数时间获取值

    public Pool() {
        k1 = new HashMap<>();
        k2 = new HashMap<>();
        size = 0;
    }

    public void insert(K key) {
        if (!k1.containsKey(key)) {
            k1.put(key, size);
            k2.put(size, key);
            size++;
        }
    }

    public void delete(K key) {
        if (k1.containsKey(key)) {
            int deleteIndex = k1.get(key);
            int lastIndex = --size;
            K lastKey = k2.get(lastIndex);
            k1.put(lastKey, deleteIndex);
            k2.put(deleteIndex, lastKey);
            k1.remove(key);
            k2.remove(lastIndex);
        }
    }

    public K getRandom() {
        if (this.size == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * size);
        return this.k2.get(randomIndex);
    }

}
