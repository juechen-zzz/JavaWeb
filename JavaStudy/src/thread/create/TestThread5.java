package thread.create;

import java.util.concurrent.*;

/**
 * @description: Callable接口创建线程
 * @author: Komorebi
 * @time: 2021/10/7 10:49
 */
public class TestThread5 implements Callable<Boolean> {
    private String url;
    private String name;

    public TestThread5(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载的文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread5 t1 = new TestThread5("http://static.komorebi.top/image-14.jpg", "test1.jpg");
        TestThread5 t2 = new TestThread5("http://static.komorebi.top/image-14.jpg", "test2.jpg");
        TestThread5 t3 = new TestThread5("http://static.komorebi.top/image-14.jpg", "test3.jpg");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        // 关闭服务
        ser.shutdownNow();
    }
}
