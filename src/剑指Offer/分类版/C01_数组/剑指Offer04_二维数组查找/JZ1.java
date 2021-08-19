package 剑指Offer.分类版.C01_数组.剑指Offer04_二维数组查找;

public class JZ1 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j < array[0].length) {
            if (array[i][j] < target) {
                j++;
            } else if (array[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
