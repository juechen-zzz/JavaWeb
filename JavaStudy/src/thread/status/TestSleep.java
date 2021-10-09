package thread.status;

import thread.create.TestThread4;

/**
 * @description: sleep模拟网络延时
 * @author: Komorebi
 * @time: 2021/10/9 09:40
 */
public class TestSleep implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }

            // 模拟延时
            try {
                Thread.sleep(1000);
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
