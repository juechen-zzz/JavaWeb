package thread.create;

/**
 * @description: Runnable接口创建线程
 * @author: Komorebi
 * @time: 2021/9/27 10:18
 */
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        System.out.println("测试Runnable接口创建线程");
    }

    public static void main(String[] args) {
        TestThread3 t1 = new TestThread3();

        // 创建线程对象，通过线程对象来开启线程，代理
        Thread t = new Thread(t1);
        t.start();
    }
}
