package thread.status;

/**
 * @description: 测试守护线程
 * @author: Komorebi
 * @time: 2021/10/9 15:56
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);     // 默认是false，表示是用户线程，正常的线程都是用户线程

        thread.start();             // 上帝守护线程启动

        new Thread(you).start();    // 你，用户线程启动
    }
}

// God
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("God bless you");
        }
    }
}

// You
class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("Living");
        }
        System.out.println("Game Over!");
    }
}
