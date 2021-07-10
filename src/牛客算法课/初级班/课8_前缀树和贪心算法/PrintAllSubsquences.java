package 牛客算法课.初级班.课8_前缀树和贪心算法;

public class PrintAllSubsquences {

    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);// 直接递归到字符数组末尾
        char tmp = chs[i];
        chs[i] = 0;// char c = 0 ,打印为空
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSubsquence(test);
    }

}
