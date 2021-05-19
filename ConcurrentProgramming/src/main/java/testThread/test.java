package testThread;

import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import ch.qos.logback.classic.Logger;

public class test {
    private final static Logger log = (Logger) LoggerFactory.getLogger(test.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 方式一：Thread
        Thread task1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("hello Thread");
            }
        };
        task1.start();

        // 方式二：Runnable
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                log.debug("hello Runnable");
            }
        };
        Thread t = new Thread(task2, "t2");
        t.start();

        // 方式三：Callable
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            log.debug("hello Callable");
            return 100;
        });
        Thread t3 = new Thread(task3, "t3");
        t3.start();
        Integer result = task3.get();
        log.debug("结果是:{}", result);
    }
}