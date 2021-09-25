package 慕课网数据结构.sqrt;

/**
 * @Author ssl
 * @Date 2020/12/17 11:42
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        SQRTDecomposition<Integer> sumSqrt = new SQRTDecomposition<Integer>(arr, (a, b) -> a + b);
        // SQRTDecomposition<Integer> sumSqrt = new SQRTDecomposition<Integer>(arr, Integer::sum);
        SQRTDecomposition<Integer> maxSqrt = new SQRTDecomposition<Integer>(arr, (a, b) -> Math.max(a, b));
        // SQRTDecomposition<Integer> maxSqrt = new SQRTDecomposition<Integer>(arr, Math::max);
    }
}
