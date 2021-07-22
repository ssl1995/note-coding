package tag刷题.C04_字符串.NC97_出现次数的TopK问题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static class Node implements Comparable<Node> {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }

        // 排序逻辑:排序在前面的，返回负数，排序在后面的，返回正数
        // 1.词频相同，词频高的在前，返回负数
        // 2.词频不相同，字典序低的在前，返回负数
        @Override
        public int compareTo(Node node) {
            if (this.times == node.times) {// 词频一样，比较字符串
                return this.str.compareTo(node.str);
            } else {// 词频不一样，就比较词频
                return node.times - this.times;
            }
        }
    }

    public String[][] topKstrings(String[] strings, int k) {
        if (strings == null || k < 1) {
            return new String[][]{};
        }
        // map统计每个字符，出现的词频
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
        }
        // 遍历哈希表，每个node放入小根堆中
        // minHeap中的"小"指的是：排序放在后面的放在堆顶（compareTo返回正数）
        Node[] minHeap = new Node[k];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            Integer times = entry.getValue();
            Node node = new Node(str, times);
            if (index < k) {// 堆未满，就加入
                minHeap[index] = node;
                heapInsert(minHeap, index++);
            } else {
                if (minHeap[0].compareTo(node) > 0) {// 堆满了，如果小根堆顶应该排在待插入元素的后面（>0）,就更新堆顶
                    minHeap[0] = node;
                    heapify(minHeap, 0, k);
                }
            }
        }
        // 重新调整小根堆，使排序在前的放在堆顶
        for (int i = index - 1; i >= 0; i--) {
            swap(minHeap, 0, i);
            heapify(minHeap, 0, i);
        }
        // 结果集接受堆中数据，返回结果集
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            // 小根堆，就倒序放入res中
            res[i][0] = minHeap[i].str;
            res[i][1] = String.valueOf(minHeap[i].times);
        }
        return res;
    }

    private void heapify(Node[] minHeap, int index, int size) {
        while (2 * index + 1 < size) {
            int left = 2 * index + 1;
            // 越排在后面的，compareTo返回的越大，找出左右孩子节点中的排序后在更后面的
            if (left + 1 < size && minHeap[left].compareTo(minHeap[left + 1]) < 0) {
                left++;
            }
            // 如果父亲已经比孩子中最靠后的还要排序在后面，就停止本轮循环
            if (minHeap[index].compareTo(minHeap[left]) > 0) {
                break;
            }
            swap(minHeap, index, left);
            index = left;
        }
    }

    // 小根堆未满，加入堆时，排序小的往上放
    private void heapInsert(Node[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            // 返回正数，应该放后面，所以交换
            if (heap[index].compareTo(heap[parent]) > 0) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(Node[] minHeap, int i, int j) {
        Node temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"abcd", "abcd", "abcd", "pwb2", "abcd", "pwb2", "p12"};
        int k = 3;
        String[][] res = solution.topKstrings(strs, k);
        // 正确：[["abcd","4"],["pwb2","2"],["p12","1"]]
        System.out.println(Arrays.deepToString(res));
        System.out.println("---------");
        String s1 = "231";
        String s2 = "32";
        Node n1 = new Node(s1, 1);// 词频相同，231字典序<32，返回负数
        Node n2 = new Node(s2, 1);

        Node n3 = new Node(s1, 1);// 词频不相同，231词频<32词频，返回正数
        Node n4 = new Node(s2, 2);

        System.out.println(n1.compareTo(n2));// -1
        System.out.println(n3.compareTo(n4));// 1

    }
}
