package 学习笔记.极客时间.数据结构与算法之美.第4章_哈希表_位图和哈希算法;

/**
 * @author SongShengLin
 * @date 2022/1/5 9:34 AM
 * @description 位图
 */
public class BitMap {
    /**
     * Java中char占2B=16bit
     */
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        // char站2B=16b；0位置不要
        bytes = new char[nbits / 16 + 1];
    }

    public void set(int k) {
        if (k > nbits) {
            return;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        // |=：按位或赋值
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) {
            return false;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        // &:两个位都为1时输出1，否则0
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        System.out.println(1 << 2);
    }


}
