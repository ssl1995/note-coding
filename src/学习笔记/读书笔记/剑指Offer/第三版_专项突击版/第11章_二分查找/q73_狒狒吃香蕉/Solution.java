package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第11章_二分查找.q73_狒狒吃香蕉;

/**
 * @author SongShengLin
 * @date 2021/11/6 3:41 下午
 * @description
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        // 最慢速度为1根/h
        int left = 1;
        // 最快速度为max根/h
        int right = max;
        while (left <= right) {
            // 每次取speed为中位数
            int speed = left + (right - left) / 2;
            int hours = getHours(piles, speed);
            if (hours <= h) {
                // 找最慢速度
                if (speed == 1 || getHours(piles, speed - 1) > h) {
                    return speed;
                }
                // mid-1速度下的时间也小，说明速度还可以再慢一点
                right = speed - 1;
            } else {
                // hours>h,说明要吃的更快一点
                left = speed + 1;
            }
        }
        return -1;
    }

    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            // 向上取整：2.4取3
            hours += pile % speed == 0 ? pile / speed : pile / speed + 1;
            // 向上取整优化:速度更快，为了防止整除
            // hours += (pile - 1) / speed + 1;
        }
        return hours;
    }
}
