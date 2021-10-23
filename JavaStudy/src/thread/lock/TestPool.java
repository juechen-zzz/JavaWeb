package thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 测试线程池
 * @author: Komorebi
 * @time: 2021/10/23 16:12
 */
public class TestPool {
    public static void main(String[] args) {
        // 1 创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 2 关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}