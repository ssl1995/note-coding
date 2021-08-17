package 牛客.NC97_出现次数的TopK问题;

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

        // compareTo：
        // 1.>0,是从小到大升序
        // 2.<0,是从大到小降序
        @Override
        public int compareTo(Node node) {
            if (this.times == node.times) {
                // 词频相同，按字典序升序，本类字段-入参字段
                return this.str.compareTo(node.str);
            } else {
                // 词频不相同，频率降序，入参字段-本类字段
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
        // heap:本题排序在前的放在heap前面
        Node[] heap = new Node[k];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            Integer times = entry.getValue();
            Node node = new Node(str, times);
            if (index < k) {// 堆未满，就加入node，调整堆让排序靠后的在堆顶
                heap[index] = node;
                heapInsert(heap, index++);
            } else {// 堆满了，如果加进来的node排序比
                if (heap[0].compareTo(node) > 0) {
                    heap[0] = node;
                    heapify(heap, 0, k);
                }
            }
        }
        // 上面执行完，类似小根堆=[[p12, 1], [pwb2, 2], [abcd, 4]]
        for (int i = index - 1; i >= 0; i--) {
            swap(heap, 0, i);
            heapify(heap, 0, i);
        }
        // 再调整成，大根堆=[["abcd","4"],["pwb2","2"],["p12","1"]]
        // 结果集接受堆中数据，返回结果集
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = heap[i].str;
            res[i][1] = String.valueOf(heap[i].times);
        }
        return res;
    }

    private void heapInsert(Node[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[index].compareTo(heap[parent]) > 0) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapify(Node[] heap, int index, int size) {
        while (2 * index + 1 < size) {
            int left = 2 * index + 1;
            if (left + 1 < size && heap[left].compareTo(heap[left + 1]) < 0) {
                left++;
            }
            if (heap[index].compareTo(heap[left]) > 0) {
                break;
            }
            swap(heap, index, left);
            index = left;
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

        String s11 = "231";// 字典序小于32
        String s22 = "32";
        System.out.println(s11.compareTo(s22));// -1<0.从大到小排序，p12排在pwb2后面
        System.out.println(s22.compareTo(s11));// 1>0
        System.out.println("---------");

        String s1 = "p12";
        String s2 = "pwb2";
        Node n1 = new Node(s1, 1);
        Node n2 = new Node(s2, 2);
        System.out.println(n1.compareTo(n2));// 返回1>0，从小到大升序，(p12,1)排在(pwb2,2)前面

    }
}
