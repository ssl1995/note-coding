package interview.maimai;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        int[] res = getMax2(arr);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] getMax2(int[] arr) {
        if (arr == null) {
            return new int[]{-1, -1};
        }
        int a = arr[0];
        int b = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > a) {
                b = a;
                a = arr[i];
            } else if (arr[i] > b) {
                b = a;
            }
        }
        return new int[]{a, b};
    }
}
