package thread;

/**
 * @description: 两个线程交替打印奇数和偶数
 * @author: Komorebi
 * @time: 2021/4/28 10:45
 */

public class ThreadTest implements Runnable {
    private boolean run;
    private Object lock;
    private int num;

    public ThreadTest(boolean run, Object lock, int num) {
        this.run = run;
        this.lock = lock;
        this.num = num;
    }

    @Override
    public void run() {
        synchronized(lock) {
            while (num <= 20) {
                if (run) {
                    run = false;
                }
                else {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(num);
                num += 2;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new ThreadTest(true, lock, 1));
        Thread t2 = new Thread(new ThreadTest(false, lock, 2));

        t2.start();
        t1.start();
    }
}