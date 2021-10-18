package thread.synchronization;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 线程不安全的集合案例
 * @author: Komorebi
 * @time: 2021/10/18 16:57
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
               synchronized (list) {
                   list.add(Thread.currentThread().getName());
               }
            }).start();
        }

        System.out.println(list.size());
    }
}
