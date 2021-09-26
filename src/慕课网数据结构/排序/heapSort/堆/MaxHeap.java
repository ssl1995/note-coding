package 慕课网数据结构.排序.heapSort.堆;

import 慕课网数据结构.数组.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<E>();
    }

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    // heap_ify:从最后一个非叶子结点开始，实现下沉操作
    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        /*
          heapIfy过程：从最后一个非叶子结点开始，实现下沉操作
         */
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }


    // 添加元素
    public void add(E e) {
        data.addLast(e);
        // 数据上浮过程
        siftUp(data.getSize() - 1);
    }

    // 添加上浮操作
    private void siftUp(int k) {
        // 父节点<插入结点，就交换
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E extractMax() {
        // 获取最大值=根节点
        E root = findMax();
        // 交换根节点和二叉树最后的叶子节点
        data.swap(0, data.getSize() - 1);
        // 删除最后结点
        data.removeLast();
        // 数据下沉比较
        siftDown(0);
        return root;
    }

    private void siftDown(int k) {
        // 循环条件：左孩子<数组长度
        while (leftChild(k) < data.getSize()) {
            // 找出左右孩子最大值:data[j]是左右孩子的最大值
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            // k比它左右孩子最大值还大，就跳出
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            // 否则就交换k和左右最大值
            data.swap(k, j);
            // 交换坐标
            k = j;
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    // 取出最大元素，加入一个元素
    public E replace(E e) {
        E root = findMax();
        // 直接设置root元素,然后执行下沉操作，时间O(longN)
        data.set(0, e);
        siftDown(0);
        return root;
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

}
