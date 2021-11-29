package 剑指Offer.第二版.第6章_面试中的各项能力.q58_I_反转单词顺序;

public class JZ44 {

    public String ReverseSentence(String str) {
        String trim = str.trim();
        int last = trim.length() - 1;
        int index = last;
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            while (index >= 0 && trim.charAt(index) != ' ') {
                index--;
            }
            sb.append(trim, index + 1, last + 1).append(" ");
            while (index >= 0 && trim.charAt(index) == ' ') {
                index--;
            }
            last = index;
        }
        return sb.toString().trim();
    }

}
