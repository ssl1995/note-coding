package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第15章_图.q113_课程顺序;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/28 3:23 下午
 * @description
 */
public class Solution {
    /**
     * 课程表
     * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites给出，
     * 其中prerequisites[i] = [ai, bi],表示如果要学习课程ai，则必须先学习课程bi 。
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：输出[0,1,2,3],一个可行的修课序列0->1->2->3
     * 注意：LC207是返回布尔，本题是返回可行序列
     */
    public int[] findOrder(int numCourses, int[][] pres) {
        // 本题转换为pres的有向无环图是否存在
        // = 求pres的对应图的拓扑排序，如果最后图非空或者已经不存在入度为0的结点，图必有环=返回false，否则返回true
        // graph：图邻接表，key是先修课程，value是必须先修课程之后才能学习的所有课程
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        // inDegrees[i]表示结点i的入度
        // 初始化图和入度表
        int[] inDegrees = new int[numCourses];
        for (int[] pre : pres) {
            // pre=[1,0]：修1号课程，先修0号课程
            // pre[0]:入度结点=该课程的入度+1
            inDegrees[pre[0]]++;
            // pre[1]:该节点有一条边指向pre[0]=更新图的邻接表
            graph.get(pre[1]).add(pre[0]);
        }

        // 求图的拓扑排序(BFS)
        List<Integer> order = new LinkedList<>();
        // 1.入度为0的结点进入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 2.遍历队列
        while (!queue.isEmpty()) {
            // 拓扑排序：每次从队列中取出一个入度为0的结点
            int node = queue.remove();

            order.add(node);

            // 更新邻接表，如果有入度为0的结点，就放入队列中
            for (int next : graph.get(node)) {
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
