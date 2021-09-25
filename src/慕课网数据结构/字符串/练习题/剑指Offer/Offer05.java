package 慕课网数据结构.字符串.练习题.剑指Offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer05 {
    // 遍历法
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
