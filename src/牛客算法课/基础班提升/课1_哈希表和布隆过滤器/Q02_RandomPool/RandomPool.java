package 牛客算法课.基础班提升.课1_哈希表和布隆过滤器.Q02_RandomPool;

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
                // 待删除元素在map1中的key和value
                int deleteIndex = this.map1.get(key);
                // map2中获取最后一个元素的key和value
                int lastIndex = --this.size;
                K lastKey = this.map2.get(lastIndex);
                // 末尾元素代替待删除元素的map1和map2
                this.map1.put(lastKey, deleteIndex);
                this.map2.put(deleteIndex, lastKey);
                // 删除元素
                this.map1.remove(key);
                this.map2.remove(lastIndex);
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
