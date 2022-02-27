package 刷题笔记.力扣.热门100.LC621_任务调度器;

/**
 * @author SongShengLin
 * @date 2022/2/27 1:34 PM
 * @description
 */
public class Solution {
    /**
     * 任务调度器
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0 || n == 0) {
            return tasks.length;
        }
        int[] map = new int[26];
        int max = 0;
        for (char task : tasks) {
            max = Math.max(max, ++map[task - 'A']);
        }
        // 贪心：找出相同元素数量最大的的元素，它后面紧跟着n个单位时间
        // n=2:A__A__Axx，max=3，有max-1个时间段，每个时间段有n+1单位长度
        int res = (max - 1) * (n + 1);

        for (int i = 0; i < 26; i++) {
            // 加上还等于max的任务数量
            if (map[i] == max) {
                res++;
            }
        }
        // 如果不同的任务种类数量大于n + 1则可能不存在冷却时间，取长度最大值
        return Math.max(res, tasks.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(solution.leastInterval(tasks, n));

    }
}
