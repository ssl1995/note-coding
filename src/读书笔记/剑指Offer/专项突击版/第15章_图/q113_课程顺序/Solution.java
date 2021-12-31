package 读书笔记.剑指Offer.专项突击版.第15章_图.q113_课程顺序;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/28 3:23 下午
 * @description
 */
public class Solution {
    // prerequisites[i]={1,2}，表示先修2才能修1
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // key是先修课程，value是必须先修课程之后才能学习的所有课程
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        // 保存每个结点的入度：inDegrees[i]表示结点i的入度
        int[] inDegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegrees[pre[0]]++;
        }
        // 入度为0的结点进入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 队列用的while，没用指针，所以用list接受最后的结果集
        List<Integer> order = new LinkedList<>();
        while (!queue.isEmpty()) {
            // 拓扑排序：每次从队列中取出一个入度为0的结点
            int course = queue.remove();
            // 加入结果集
            order.add(course);
            // 遍历该入度为0的结点的所有后续课程
            for (int next : graph.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prep = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prep)));
    }
}
