package testThread;

/**
 * @description: Runnable
 * @author: Komorebi
 * @time: 2021/4/23 14:56
 */
public class testThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable方式创建多线程");
    }

    public static void main(String[] args) {
        testThread2 myRunnable = new testThread2();
        Thread t = new Thread(myRunnable);
        t.start();
        System.out.println("over");
    }
}
