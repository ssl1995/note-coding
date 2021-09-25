package 慕课网数据结构.数组.LCArray;

public class LCArray {
    private int[] arr;
    private int size;
    private int capacity = 10;

    public LCArray() {
        arr = new int[capacity];
        size = 0;
    }

    public void push_back(int n) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        arr[size] = n;
        size++;
    }

    private void resize(int newCapacity) {
        int[] res = new int[newCapacity];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        this.arr = res;
    }

    public void pop_back() {
        if (arr.length == 0) {
            throw new IllegalArgumentException("index is 0");
        }
        size--;
    }

    public int size() {
        return size;
    }

    public int index(int idx) {
        if (idx < 0 || idx >= arr.length) {
            throw new IllegalArgumentException("idx is illegal");
        }
        return arr[idx];
    }
}
