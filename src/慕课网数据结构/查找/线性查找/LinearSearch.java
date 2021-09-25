package 慕课网数据结构.查找.线性查找;


import 慕课网数据结构.工具类.Student;

public class LinearSearch {
    private LinearSearch() {
    }

    // 线性查找法：不使用泛型
    public static int linearSearch1(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            // 循环不变量：data[i] == target
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 线性查找法：使用泛型，
    // 一个方法使用泛型，声明在方法返回值之前,用<X>表示
    public static <E> int linearSearch2(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // 测试
    public static void main(String[] args) {
        // 使用泛型，基本属性就要使用包装类
        Integer[] data = new Integer[]{24, 18, 12, 9, 16, 66, 32, 4};
        System.out.println(linearSearch2(data, 16));
        // 使用泛型，
        Student[] students = {new Student("a"), new Student("b"), new Student("c")};
        Student target = new Student("b");
        System.out.println(linearSearch2(students, target));
    }
}
