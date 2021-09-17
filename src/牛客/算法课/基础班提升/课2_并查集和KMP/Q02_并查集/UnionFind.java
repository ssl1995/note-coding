package 牛客.算法课.基础班提升.课2_并查集和KMP.Q02_并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    // 定义包装元素的数据结构
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }

    }

    public static class UnionFindSet<V> {
        // 元素集合<元素，包装元素>:加速判断该元素是否在该并查集内
        public HashMap<V, Element<V>> elementMap;
        // 父亲集合<包装元素，父亲包装元素>
        public HashMap<Element<V>, Element<V>> fatherMap;
        // 代表元素记录集合<代表元素，它挂着有几个元素>
        public HashMap<Element<V>, Integer> rankMap;

        //  初始化
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> ele = new Element<V>(value);
                elementMap.put(value, ele);
                fatherMap.put(ele, ele);// 初始化:自己指向自己
                rankMap.put(ele, 1);// 初始化:自己的rank只有它自己
            }
        }


        // 判断a和b是否在同一集合
        public boolean isSameSet(V a, V b) {
            // 如果a和b在初始化都注册过,就去查父亲是否一致
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                // 找两个节点的代表元素
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            // 都没注册过,返回false
            return false;
        }

        // 查找父亲,并完成路径压缩
        private Element<V> findHead(Element<V> element) {
            // 用栈保存沿途经过的节点,便于后面路径压缩
            Stack<Element<V>> path = new Stack<>();
            // 向上找父亲
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            // 此时已经找到父亲
            // 压缩路径:所以存进栈中的元素出栈,其father都指向他们的父亲
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        // 合并a和b集合
        public void union(V a, V b) {
            //  如果a和b在初始化都注册过,才合并
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                // 两个元素的父亲不一样,才需要合并
                if (aF != bF) {
                    // 找元素最多的父亲
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    // 短的指向长的
                    fatherMap.put(small, big);
                    // 更新长的个数
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    // 移除短的个数
                    rankMap.remove(small);
                }
            }
        }

    }

}
