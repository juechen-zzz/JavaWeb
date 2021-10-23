package thread.lock;

/**
 * @description: 死锁：多个线程互相抱有对方需要的资源
 * @author: Komorebi
 * @time: 2021/10/23 10:47
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "A");
        MakeUp g2 = new MakeUp(1, "B");

        g1.start();
        g2.start();
    }
}


// 口红
class Lipstick {

}

// 镜子
class Mirror {

}

class MakeUp extends Thread {
    // 需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;         // 选择
    String girlName;    // 使用的人

    MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        // 化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {           // 获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);

                synchronized (mirror){          // 一秒钟后想获得镜子
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }
        }
        else {
            synchronized (mirror) {           // 获得镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(2000);

                synchronized (lipstick){          // 一秒钟后想获得口红
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }
        }
    }
}