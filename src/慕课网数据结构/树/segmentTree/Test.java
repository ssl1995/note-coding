package 慕课网数据结构.树.segmentTree;

/**
 * @Author ssl
 * @Date 2020/12/15 10:25
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segTree.query(0, 2));
    }
}
