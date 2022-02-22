package 刷题笔记.力扣.热门100.LC207_课程表;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2022/2/22 8:04 AM
 * @description
 */
public class Solution {
    /**
     * 课程表
     * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites给出，
     * 其中prerequisites[i] = [ai, bi],表示如果要学习课程ai，则必须先学习课程bi 。
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：true,一个可行的修课序列0->1->2->3
     */
    public boolean canFinish(int numCourses, int[][] pres) {
        // 本题转换为pres的有向无环图是否存在
        // = 求pres的对应图的拓扑排序，如果最后图非空或者已经不存在入度为0的结点，图必有环=返回false，否则返回true
        // graph：图邻接表，key是先修课程，value是必须先修课程之后才能学习的所有课程
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        int[] inDegrees = new int[numCourses];
        for (int[] node : pres) {
            int cur = node[0];
            int pre = node[1];

            inDegrees[cur]++;
            graph.get(pre).add(cur);
        }

        // 拓扑排序(BFS)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 队列出队=入度为0的出队
            int node = queue.remove();

            // 课程完成拓扑数-1
            numCourses--;

            for (int next : graph.get(node)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        // 完成拓扑排序的课程数量减0，说明完成所有的先修课程
        return numCourses == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums = 4;
        int[][] pres = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(solution.canFinish(nums, pres));
    }
}
