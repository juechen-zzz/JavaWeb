package testThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: 实现Callable接口
 * @author: Komorebi
 * @time: 2021/4/23 14:59
 */
public class testThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Callable方式创建多线程 2";
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 启动多线程
        Future<String> future = threadPool.submit(new testThread3());
        try {
            System.out.println("Callable方式创建多线程");
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
