package 剑指Offer.第三版.第15章_图.q117_相似字符串;

/**
 * @author SongShengLin
 * @date 2021/11/29 3:34 下午
 * @description
 */
public class Solution {
    public int numSimilarGroups(String[] strs) {
        int[] fathers = new int[strs.length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }

        int groups = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                // 如果是相似字符串，并且属于同一个子图，子图总数减1
                if (isSimilar(strs[i], strs[j]) && union(fathers, i, j)) {
                    groups--;
                }
            }
        }

        return groups;
    }

    /**
     * 合并i和j所在子图
     */
    private boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            // 合并两个子集
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    /**
     * 查找一个结点i的根节点
     */
    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            // 压缩路径，记录每个结点的根节点
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    /**
     * 判断两个字符串中是否相似：相似是交换两个单词就相同，并且字符串已经是异位词了
     */
    private boolean isSimilar(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount <= 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"tars", "rats", "arts", "star"};
        System.out.println(solution.numSimilarGroups(strs));
    }
}
