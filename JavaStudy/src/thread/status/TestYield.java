package thread.status;

/**
 * @description: yield测试礼让线程
 * @author: Komorebi
 * @time: 2021/10/9 10:42
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread start: " + Thread.currentThread().getName());
        Thread.yield();
        System.out.println("Thread end: " + Thread.currentThread().getName());
    }
}