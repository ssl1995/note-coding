package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第13章_回溯法.q87_恢复IP地址;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/14 12:38 上午
 * @description
 */
public class Solution {

    // 给一个只包含数字的字符串，列出所有可能恢复出来的IP地址
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        helper(s, 0, "", 0, "", res);

        return res;
    }

    private void helper(String s, int i, String seg, int segI, String ip, List<String> res) {
        if (i == s.length() && segI == 3 && isValid(seg)) {
            res.add(ip + seg);
        } else if (i < s.length() && segI <= 3) {
            char ch = s.charAt(i);
            // 选择1：当前字符拼接到当前分段数字的末尾
            if (isValid(seg + ch)) {
                helper(s, i + 1, seg + ch, segI, ip, res);
            }
            // 选择2：当前字符作为一个新的分段数字的开始
            // 开始一个新的分段时，前一个分段数字不能为空，且IP地址最多只有4个分段
            if (seg.length() > 0 && segI < 3) {
                helper(s, i + 1, "" + ch, segI + 1, ip + seg + ".", res);
            }
        }
    }

    // 有效的ip地址分段：每个字符<=255，0只能是单独一个，或者0不能作为开头
    private boolean isValid(String seg) {
        return Integer.parseInt(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "10203040";
        System.out.println(solution.restoreIpAddresses(s));
    }

}
