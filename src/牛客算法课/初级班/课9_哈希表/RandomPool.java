package 牛客算法课.初级班.课9_哈希表;

import java.util.HashMap;

public class RandomPool {

    public static class Pool<K> {
        private HashMap<K, Integer> map1;// keyIndexMap
        private HashMap<Integer, K> map2;// indexKeyMap
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
                int deleteIndex = this.map1.get(key);
                // map2中找出末尾key和index
                int lastIndex = --this.size;
                K lastKey = this.map2.get(lastIndex);
                this.map1.put(lastKey, deleteIndex);
                this.map2.put(deleteIndex, lastKey);
                this.map1.remove(key);
                this.map2.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return this.map2.get(randomIndex);
        }

    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
