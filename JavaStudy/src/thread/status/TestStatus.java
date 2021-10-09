package thread.status;

/**
 * @description: 观察测试线程状态
 * @author: Komorebi
 * @time: 2021/10/9 11:11
 */
public class TestStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Over");
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state);      // NEW

        // 观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);      // RUNNABLE

        while (state != Thread.State.TERMINATED) {      // 只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
