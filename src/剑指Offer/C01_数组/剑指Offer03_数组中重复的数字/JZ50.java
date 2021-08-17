package 剑指Offer.C01_数组.剑指Offer03_数组中重复的数字;


public class JZ50 {

    public int duplicate(int[] numbers) {
        int index = 0;
        // 不能用for，因为只有index == numbers[index]才index++
        while (index <= numbers.length - 1) {
            // 元素值和坐标对应，遍历指针后移+进行下次循环
            if (index == numbers[index]) {
                index++;
                continue;
            }
            // 当元素值和坐标不对应
            // 情况1：第二次来到该位置，就是重复元素
            if (numbers[index] == numbers[numbers[index]]) {
                return numbers[index];
            } else {
                // 情况2：归位，让其归位到第一次出现的位置
                int temp = numbers[index];
                numbers[index] = numbers[temp];// temp既是记录数还是记录下标
                numbers[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ50 jz50 = new JZ50();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(jz50.duplicate(arr));
    }
}
