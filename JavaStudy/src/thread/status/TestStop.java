package thread.status;

/**
 * @description: 测试stop方法
 * @author: Komorebi
 * @time: 2021/10/8 09:59
 */
public class TestStop implements Runnable{
    // 1 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("Thread is running -> " + i++);
        }
    }

    // 2 设置一个公开的方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();

        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main -> " + i);
            if (i == 900) {
                testStop.stop();       // 调用stop方法切换标志位，让线程停止
                System.out.println("Thread stopped");
            }
        }
    }
}
