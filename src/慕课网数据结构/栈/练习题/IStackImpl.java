package 慕课网数据结构.栈.练习题;

public class IStackImpl implements IStack {

    private Integer[] arr;
    private Integer index;
    private int min;
    private int max;

    public IStackImpl() {
        arr = new Integer[10];
        index = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public IStackImpl(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    @Override
    public void push(int data) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        if (min > data) {
            min = data;
        }
        if (max < data) {
            max = data;
        }
        arr[index++] = data;
    }

    @Override
    public int pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is null");
        }
        int pop = arr[--index];
        if (pop == min) {
            for (int i = 0; i < index; i++) {
                min = Math.min(min, arr[i]);
            }
        }
        if (pop == max) {
            for (int i = 0; i < index; i++) {
                max = Math.max(max, arr[i]);
            }
        }
        return pop;
    }

    @Override
    public int min() {

        return min;
    }

    @Override
    public int max() {

        return max;
    }
}
