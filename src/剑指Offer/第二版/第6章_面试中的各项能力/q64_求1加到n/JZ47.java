package 剑指Offer.第二版.第6章_面试中的各项能力.q64_求1加到n;

public class JZ47 {
    public int Sum_Solution(int n) {
        boolean x = n > 1 && (n += Sum_Solution(n - 1)) > 0;
        return n;
    }
}
