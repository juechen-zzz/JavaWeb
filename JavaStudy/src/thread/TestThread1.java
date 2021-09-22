package thread;

/**
 * @description: Thread创建线程
 * @author: Komorebi
 * @time: 2021/9/22 10:29
 */
public class TestThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("测试Thread方式创建线程");
    }

    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1();
        t1.start();
    }
}
