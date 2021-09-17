package 牛客.算法课.基础班提升.课1_哈希表和布隆过滤器.Q02_RandomPool;

import java.util.HashMap;

public class RandomPool {

    public static class Pool<K> {
        private HashMap<K, Integer> map1;
        private HashMap<Integer, K> map2;
        private int size;

        public Pool() {
            this.map1 = new HashMap<>();
            this.map2 = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!this.map1.containsKey(key)) {
                this.map1.put(key, this.size);
                this.map2.put(this.size++, key);
            }
        }


        public void delete(K key) {
            if (this.map1.containsKey(key)) {
                int value = this.map1.get(key);
                int lastSize = --this.size;// 池子最后一个元素
                K lastKey = this.map2.get(lastSize);
                // map1更新末尾行、map2更新value行
                this.map1.put(lastKey, value);
                this.map2.put(value, lastKey);
                // map1删除key行、map2删除末尾行
                this.map1.remove(key);
                this.map2.remove(lastSize);
            }
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            // 使用map2好处:就可以随机获取
            int randomIndex = (int) (Math.random() * this.size);
            return this.map2.get(randomIndex);
        }

    }

}
