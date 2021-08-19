package 剑指Offer.分类版.C01_数组.剑指Offer61_扑克牌中的顺子;

public class JZ45 {

    public boolean IsContinuous(int[] numbers) {
        // set判断是否有重复的数
        boolean[] set = new boolean[14];
        // 扑克牌顺子大小从大小王为0,A=1到K=13,范围[0,A,2...10,J,Q,K]
        int min = 13, max = 0;
        // 遍历数组中每一个数字
        for (int num : numbers) {
            // 如果是大小王,这一轮循环跳过
            if (num == 0) {
                continue;
            } else {
                // 不是大小王,
                // 若有重复数字,必不可能构成顺子
                if (contains(set, num)) {
                    return false;
                } else {
                    // 若没有重复数字,找到当前的max,min
                    // 每一轮为必须满足判断顺子的条件:max-min<5
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                    // 当前元素放进set中,给之后的遍历重复元素做铺垫
                    add(set, num);
                }
            }
        }
        // 返回整个数组中的max-min<5的布尔值
        return max - min < 5;
    }

    private boolean contains(boolean[] set, int index) {
        return set[index];
    }

    private void add(boolean[] set, int index) {
        set[index] = true;
    }
}
