package 牛客算法课.初级班.课9_哈希表;

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
        // 元素集合<元素，包装元素>
        public HashMap<V, Element<V>> elementMap;
        // 父亲集合<包装元素，父亲包装元素>
        public HashMap<Element<V>, Element<V>> fatherMap;
        // 代表元素记录集合<代表元素，它挂着有几个元素>
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> ele = new Element<V>(value);
                elementMap.put(value, ele);
                fatherMap.put(ele, ele);
                rankMap.put(ele, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            // 扁平化优化：所有的栈中的代表结点都是同一个
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    rankMap.remove(small);
                }
            }
        }

    }

}
