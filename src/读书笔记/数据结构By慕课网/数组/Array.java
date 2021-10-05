package 读书笔记.数据结构By慕课网.数组;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 空参构造函数：默认长度为10个
     */
    public Array() {
        this(10);
    }

    /**
     * 有参构造函数:传数组长度
     */
    public Array(int capacity) {

        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 有参构造函数:传数组
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获得数组长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 获得数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     */
    public void add(int index, E e) {
        // 边界
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，插入位置非法");
        }
        // 扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        // 向后移动
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 插入元素
        data[index] = e;
        // 元素长度+1
        size++;
    }

    /**
     * 数组末尾添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 数组开头添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 删除元素
     */
    public E remove(int index) {
        // 边界
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，删除位置非法");
        }
        // 获取待删除元素
        E delete = data[index];
        // 移动
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 长度-1
        size--;
        // 末尾置空
        data[size] = null;
        // 缩容:1/4是和扩容的2倍相对应
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return delete;
    }


    /**
     * 删除首位
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除末尾
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 扩容/缩容函数
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // 改变指向
        this.data = newData;
    }

    /**
     * 获得某个元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，插入位置非法");
        }
        return data[index];
    }

    /**
     * 获得末尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获得首位元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 改变元素
     */
    public void set(int index, E e) {
        data[index] = e;
    }

    /**
     * 判断是否包含某个元素
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 交换数组中两个元素
     */
    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
