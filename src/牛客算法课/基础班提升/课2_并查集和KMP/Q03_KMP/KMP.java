package 牛客算法课.基础班提升.课2_并查集和KMP.Q03_KMP;

public class KMP {
    // KMP:字符串s和m，s是否包含m，如果包含返回m在s中开始的位置?再结合NC149_kmp算法做比较
    // 要求整体时间复杂度O(N),N是s1的长度，M是s2的长度
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        // 获得待匹配str2的next数组
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {// i2对应的最长后缀长度为-1,i1只能一个个往后移比较,无法加速
                // next[i2] == -1 等于 i2==0已经无法加速了
                i1++;
            } else {// 只要不是-1,i2就加速移动到最长后缀下一个位置,由于数组下标是0开始,所以i2移动到next[i2]下标
                i2 = next[i2];
            }
        }
        // while结束,i1或者i2越界
        // s1:abab,i1越界,匹配失败
        // s2: bab,i2越界,代表匹配完成(i1,i2是同时移动的),匹配的起始位置=i1-i2
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms) {
        // 长度为1的数组,前面没有元素,人为规定next值为-1
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;// 第一个位置前面没有元素=没有最大前后缀长度,规定为-1
        next[1] = 0;// 第二个位置前面只有0位置的元素,由于前后缀无法用一个元素代表,规定为0
        int i = 2;// 遍历指针从第3个元素开始
        // cn两个含义:
        // 1.拿哪个位置的字符跟i-1比,由于i初始化2,i-1是1,所以cn=0
        // 2.i位置的前缀和后缀最大匹配长度=最大匹配下标+1的值
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {// i-1位置和cn位置不匹配,cn一直往前跳到能匹配的位置,但cn不能低于数组0位置
                cn = next[cn];
            } else {// i-1位置无法找到匹配的且cn无法再往前跳了=i位置无最大前后缀匹长度,next[i++]=0
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        // 返回match子串在str中匹配的起始位置
        System.out.println(getIndexOf(str, match));
    }
}
