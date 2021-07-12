package 牛客算法课.基础班提升.课10_manachar算法;

public class Manacher {
    // 将str转换成带#号的字符数组
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            //偶数位房#，奇数位放原字符
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];// 回文半径数组
        int C = -1;// 回文中心
        int R = -1;// 回文右边界的下一个位置=终止位置
        int max = Integer.MIN_VALUE;// 扩出来的最大值
        for (int i = 0; i != str.length; i++) {
            // 如果i在r内，不需要验证的区域：Math.min(pArr[2*C-i],R-i)
            // 2*C-i 就是i‘的坐标
            // 如果i在r外，不需要验证的区域：1
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }

}
