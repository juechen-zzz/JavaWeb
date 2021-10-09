package thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: sleep模拟倒计时
 * @author: Komorebi
 * @time: 2021/10/9 09:43
 */
public class TestSleep2 {
    public static void tenDown() {
        // 打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis()); // 获取系统当前时间
        int num = 10;

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime) + " -> " + num--);
                startTime = new Date(System.currentTimeMillis());
                if (num == 0) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        tenDown();
    }
}
