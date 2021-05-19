package testThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/5/11 11:18
 */
public class SynDemo {
    public static void main(String[] args) {
        Runnable t1 = new MyThread2();
        new Thread(t1, "1").start();
        new Thread(t1, "2").start();
    }
}

// synchronized
class MyThread implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Synchronized:" +Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

// ReentrantLock
class MyThread2 implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ReentrantLock:" + Thread.currentThread().getName() + ":" + i);
            }
        } finally {
            lock.unlock();
        }
    }
}