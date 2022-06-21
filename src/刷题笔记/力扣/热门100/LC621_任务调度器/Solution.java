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
        // map:统计tasks中每个字母出现的次数
        int[] map = new int[26];
        // max:记录最多出现字母的次数
        int max = 0;
        for (char task : tasks) {
            int num = ++map[task - 'A'];
            max = Math.max(max, num);
        }

        // 贪心：找出相同元素数量最大的的元素，它后面紧跟着n个单位时间
        // n=2，max=3:A__A__Axx，此时的res=A__A__=(max-1)*n +(max-1) = (max - 1) * (n + 1)
        // 此时差了一个A没计算
        int res = (max - 1) * (n + 1);


        for (int i = 0; i < 26; i++) {
            // 每一个max的元素，(max-1)*(n+1)时都会剩一个未算时间
            // 有n个，res就加n个
            if (map[i] == max) {
                res++;
            }
        }
        // 如果结果算出来，比数组长度还小，是不可能的，所以我们还需将上述结果与数组长度比较，返回两个中的最大值
        return Math.max(res, tasks.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(solution.leastInterval(tasks, n));

    }
}
