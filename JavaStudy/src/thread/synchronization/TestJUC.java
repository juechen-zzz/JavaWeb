package thread.synchronization;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: 测试JUC安全类型的集合
 * @author: Komorebi
 * @time: 2021/10/18 17:02
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
    }
}