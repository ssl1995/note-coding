package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第15章_图.q115_重建序列;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/28 10:19 下午
 * @description
 */
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        // 构建有向图
        for (List<Integer> seq : seqs) {
            for (int num : seq) {
                if (num < 1 || num > org.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }

            for (int i = 0; i < seq.size() - 1; i++) {
                int num1 = seq.get(i);
                int num2 = seq.get(i + 1);
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }
        // 获取有向图的拓扑排列
        Queue<Integer> queue = new LinkedList<>();
        for (int node : inDegrees.keySet()) {
            if (inDegrees.get(node) == 0) {
                queue.offer(node);
            }
        }
        List<Integer> built = new LinkedList<>();
        // 本题要求获取重建后的唯一序列，队列长度只能保持1个长度
        while (queue.size() == 1) {
            int num = queue.remove();
            built.add(num);
            for (int next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        int[] res = built.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(res, org);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> seqs = new ArrayList<>() {
        };
        List<Integer> t1 = new ArrayList<>() {{
            add(5);
            add(2);
            add(6);
            add(3);
        }};
        List<Integer> t2 = new ArrayList<>() {{
            add(4);
            add(1);
            add(5);
            add(2);
        }};
        seqs.add(t1);
        seqs.add(t2);
        int[] org = {4, 1, 5, 2, 6, 3};
        boolean b = solution.sequenceReconstruction(org, seqs);
        System.out.println(b);
    }
}
