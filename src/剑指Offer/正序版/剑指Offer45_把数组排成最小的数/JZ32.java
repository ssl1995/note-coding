package 剑指Offer.正序版.剑指Offer45_把数组排成最小的数;


public class JZ32 {
    // 牛客：不能使用Arrays
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int x = numbers[i];
                int y = numbers[j];
                long num1 = Long.parseLong(x + "" + y);
                long num2 = Long.parseLong(y + "" + x);
                // 如果字符串：x+y>y+x，则y在前
                if (num1 > num2) {
                    numbers[i] = y;// y在前
                    numbers[j] = x;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num);
        }
        return sb.toString();
    }
}
