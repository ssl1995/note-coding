package tag刷题.C09_数学.剑指Offer64_求1加到n;

public class JZ47 {
    public int Sum_Solution(int n) {
        boolean x = n > 1 && (n += Sum_Solution(n - 1)) > 0;
        return n;
    }
}
