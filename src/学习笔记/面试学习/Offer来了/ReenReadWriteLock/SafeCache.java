package 学习笔记.面试学习.Offer来了.ReenReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SongShengLin
 * @date 2022/3/16 23:46
 * @description
 */
public class SafeCache {

    private final Map<String, Object> cache = new HashMap<>();
    /**
     * 读写锁：读写分离。多个读锁不互斥，写锁互斥且读锁和写锁也互斥
     */
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    /**
     * 读加读锁
     */
    public Object get(String key) {
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 写加写锁
     */
    public void put(String key, Object value) {
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

}
