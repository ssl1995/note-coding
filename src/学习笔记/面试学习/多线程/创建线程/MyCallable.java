package 学习笔记.面试学习.多线程.创建线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author SongShengLin
 * @date 2022/4/10 17:29
 * @description
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "正在执行！");
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        // FutureTask包装
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        futureTask.run();

        Integer res = futureTask.get();

        System.out.println(res);

    }
}
