package 慕课网数据结构.树;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<E>();
    }

    @Override
    public void add(E e) {
        // 自己实现的bst就是不重复
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

}
