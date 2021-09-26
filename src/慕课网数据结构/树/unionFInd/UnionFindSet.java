package 慕课网数据结构.树.unionFInd;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFindSet<V> {
    public class Element<V> {
        public V value;

        public Element(V val) {
            this.value = val;
        }
    }

    public HashMap<V, Element<V>> elementMap;
    public HashMap<Element<V>, Element<V>> fatherMap;
    public HashMap<Element<V>, Integer> rankMap;

    // 并查集是一次性必须传入全部的数据集，不能动态传入
    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
        for (V value : list) {
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            // 父亲集合存数据和它父亲
            fatherMap.put(element, element);
            // 范围集合存数据和它作为头结点包含的元素个数
            rankMap.put(element, 1);
        }
    }

    //找到公共父节点
    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();
        // 判断当前节点的父节点是否是自己，不是就保存当前节点入栈
        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }
        //以上循环跳出，element指向头结点，栈顶指向上一个element
        while (!path.isEmpty()) {
            // 优化:让所有的子节点都指向父节点
            fatherMap.put(path.pop(), element);
        }
        return element;
    }

    // 查找是否是同一个父节点
    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    // 合并操作
    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findHead(elementMap.get(a));
            Element<V> bF = findHead(elementMap.get(b));
            if (aF != bF) {
                Element<V> big = (rankMap.get(aF) >= rankMap.get(bF)) ? aF : bF;
                Element<V> small = (big == aF) ? bF : aF;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                rankMap.remove(small);
            }
        }
    }
}


