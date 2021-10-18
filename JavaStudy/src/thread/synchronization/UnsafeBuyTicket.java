package thread.synchronization;

/**
 * @description: 不安全的买票案例
 * @author: Komorebi
 * @time: 2021/10/18 14:39
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "A").start();
        new Thread(station, "B").start();
        new Thread(station, "C").start();
    }
}

class BuyTicket implements Runnable {
    int ticketNums = 10;
    boolean flag = true;        // 外部停止方式

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

//    private void buy() {
    private synchronized void buy() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}