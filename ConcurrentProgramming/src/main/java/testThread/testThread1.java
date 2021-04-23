package testThread;

/**
 * @description: Thread
 * @author: Komorebi
 * @time: 2021/4/23 14:54
 */
public class testThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread方式创建多线程");
    }

    public static void main(String[] args) {
        testThread1 t = new testThread1();
        t.start();
        System.out.println("over");
    }
}
