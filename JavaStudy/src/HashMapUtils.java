import java.util.*;

/**
 * @description: HashMap排序
 * @author: Komorebi
 * @time: 2021/4/1 09:34
 */
public class HashMapUtils {
    public static void main(String[] args) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(23, 54);
        count.put(24, 4);
        count.put(25, 154);
        count.put(26, 44);
        count.put(27, 534);
        count.put(28, 534);
        sortMap(count);
    }

    private static void sortMap(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> curList = new ArrayList<>(map.entrySet());
        // 按key升序
//        curList.sort(Map.Entry.comparingByKey());
        // 按key降序
//        curList.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        // 按value升序
//        curList.sort(Map.Entry.comparingByValue());
        // 按value降序
//        curList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 完整展开形式，value相同时，默认key升序
        curList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {      // 手动定义value相同时，key降序
                return o2.getKey().compareTo(o1.getKey());
            }
            else {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < curList.size(); i++) {
            System.out.println(curList.get(i).getKey() + "--" + curList.get(i).getValue());
        }
    }
}
