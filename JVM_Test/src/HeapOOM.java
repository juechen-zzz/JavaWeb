import java.util.ArrayList;
import java.util.List;

/**
 * @description:  堆OOM
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author: Komorebi
 * @time: 2021/5/18 20:30
 */
public class HeapOOM {
    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
