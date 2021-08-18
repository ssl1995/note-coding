package 牛客算法课.基础班提升.课1_哈希表和布隆过滤器.Q03_布隆过滤器;

public class BitMap {

    // 学习布隆过滤器,先学习位图
    public static void main(String[] args) {
        // 怎么使用BItMap(位图)
        // 1个int=4B=32b
        // 10个int:0-320b
        int[] arr = new int[10];

        // 假设i=178b,获取i在arr数组中的坐标
        int i = 178;
        int numIndex = i / 32;
        int bitIndex = i % 32;
        // 获取i在arr数组中的状态: >>右移bit位
        int s = (arr[numIndex] >> bitIndex) & 1;
        // 把i位状态改成1: | 可以将0改成1,1改成1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);
        // 把i位状态改成0: 将改成1取反~
        arr[numIndex] = arr[numIndex] | ~(1 << bitIndex);
    }
}
