package 牛客算法课.初级班.课9_哈希表;

public class KMP {
    // KMP，整体时间复杂度O(N),N是s1的长度，M是s2的长度
    public static int getIndexOf(String s1, String s2) {
        // s2是待匹配字符串，所以保证s1>=s2
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        // next数组,时间复杂度O(M)
        int[] next = getNextArray(str2);
        // s1匹配s2,时间复杂度O(N)
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // 如果i2遍历完，则匹配成功，返回长度差;否则匹配失败-1
        return i2 == str2.length ? i1 - i2 : -1;
    }

    // 获得next数组
    public static int[] getNextArray(char[] chs) {
        if (chs.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[chs.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;// 初始化遍历指针从2位置开始
        int cn = 0;// 初始化cn=0,说明next[1]=0=cn,同时chs[0]=chs[cn]
        while (i < next.length) {
            // 初始化时候,next[1]=cn=0,对应chs[0]=chs[cn]
            // 初始化时候,next[1]=cn=0,对应chs[0]=chs[cn]
            if (chs[i - 1] == chs[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                // cn还能往前跳，就跳
                cn = next[cn];
            } else {
                // cn到0停止匹配，next[i++]=0
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }

}
