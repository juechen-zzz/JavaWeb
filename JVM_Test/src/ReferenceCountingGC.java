/**
 * @description:
 * @author: Komorebi
 * @time: 2021/5/19 16:03
 */
public class ReferenceCountingGC {
    private Object instance = null;

    private static final int _1MB = 1024 * 1024;

    // 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这里发生GC，能否释放
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
