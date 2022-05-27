package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第3章_字符串.q14_字符串中的变位词;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        // 因为只有26个小写字母，可以使用数组充当map
        // 数组下标从0-25，分别对应a-z
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        // 如果s1、s2的字符都相同、长度一样长，那肯定s2是s1的变位词
        if (areAllZero(counts)) {
            return true;
        }
        // 指向到这里，说明s2的长度一定>s1的长度
        for (int i = s1.length(); i < s2.length(); i++) {
            // i相当于右指针=添加的元素，值-1
            counts[s2.charAt(i) - 'a']--;
            // i - s1.length()相当于左指针=删除元素，值+1
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (areAllZero(counts)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组元素是否全为0
     *
     * @param counts
     * @return 布尔值
     */
    private boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ac";
        String s2 = "dgcaf";
        Solution solution = new Solution();
        boolean res = solution.checkInclusion(s1, s2);
        System.out.println(res);
    }
}
