package thread;

/**
 * @description: 模拟多用户买票场景
 * @author: Komorebi
 * @time: 2021/9/27 10:35
 */
public class TestThread4 implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }

            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket, "用户A").start();
        new Thread(ticket, "用户B").start();
        new Thread(ticket, "用户C").start();
    }
}
