package thread.create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @description: 练习Thread实现多线程同步下载图片
 * @author: Komorebi
 * @time: 2021/9/22 10:53
 */
public class TestThread2 extends Thread {
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载的文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://static.komorebi.top/image-14.jpg", "test1.jpg");
        TestThread2 t2 = new TestThread2("http://static.komorebi.top/image-14.jpg", "test2.jpg");
        TestThread2 t3 = new TestThread2("http://static.komorebi.top/image-14.jpg", "test3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownLoader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}