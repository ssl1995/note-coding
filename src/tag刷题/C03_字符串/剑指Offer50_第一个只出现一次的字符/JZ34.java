package tag刷题.C03_字符串.剑指Offer50_第一个只出现一次的字符;

public class JZ34 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || "".equals(str)) {
            return -1;
        }
        // 牛客不能用Map等数据结构，我们就想数组
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (map[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
