package 慕课网数据结构.哈希表.练习题.程序员面试指南.RandomPool设计;

import java.util.HashMap;

public class RandomizedSet {

    private HashMap<Integer, Integer> k1;
    private HashMap<Integer, Integer> k2;
    private int size;

    public RandomizedSet() {
        k1 = new HashMap<>();
        k2 = new HashMap<>();
        size = 0;

    }

    public boolean insert(int val) {
        if (!k1.containsKey(val)) {
            k1.put(val, size);
            k2.put(size++, val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (k1.containsKey(val)) {
            int deleteIndex = k1.get(val);
            int lastIndex = --size;
            int lastKey = k2.get(lastIndex);
            k1.put(lastKey, deleteIndex);
            k2.put(deleteIndex, lastKey);
            k1.remove(val);
            k2.remove(lastIndex);
            return true;
        }
        return false;
    }

    public int getRandom() {
        if (size == 0) {
            return -1;
        }
        int random = (int) (Math.random() * size);
        return k2.get(random);
    }

}
