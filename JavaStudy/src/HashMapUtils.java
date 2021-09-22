import java.util.*;

/**
 * @description: HashMap排序
 * @author: Komorebi
 * @time: 2021/4/1 09:34
 */
public class HashMapUtils {
    /**
     * @description  对Map<String, Integer>的值降序排列，并输出
     */
    private static void sortMapByValue1(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> curList = new ArrayList<>(map.entrySet());
        curList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < curList.size(); i++) {
            System.out.println(curList.get(i).getKey() + "--" + curList.get(i).getValue());
        }
    }

    /**
     * @description  对Map<Character, Integer>的值降序排列，并输出
     */
    private static void sortMapByValue2(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> curList = new ArrayList<>(map.entrySet());
        curList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < curList.size(); i++) {
            System.out.println(curList.get(i).getKey() + "--" + curList.get(i).getValue());
        }
    }

    /**
     * @description 对Map<Integer, String>的键降序排列，并输出
     */
    private static void sortMapByKey(Map<Integer, String> map) {
        Set set = map.keySet();
        Object[] keyArr = set.toArray();
        Arrays.sort(keyArr, Collections.reverseOrder());
        for(Object key : keyArr){
            System.out.println(key  + "--" + map.get(key));
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> count1 = new HashMap<>();
        count1.put("DIB", 54);
        count1.put("LIG", 34);
        count1.put("EVN", 37);
        count1.put("CXO", 40);
        count1.put("AOP", 50);
        System.out.println(" Map<String, Integer> sort by value");
        sortMapByValue1(count1);

        System.out.println("---------------------------------------------------");

        Map<Character, Integer> count2 = new HashMap<>();
        count2.put('A', 54);
        count2.put('N', 34);
        count2.put('K', 37);
        count2.put('I', 40);
        count2.put('W', 50);
        System.out.println(" Map<Character, Integer> sort by value");
        sortMapByValue2(count2);

        System.out.println("---------------------------------------------------");

        Map<Integer, String> count3 = new HashMap<>();
        count3.put(23, "AKN");
        count3.put(52, "PND");
        count3.put(34, "WNM");
        count3.put(65, "ICM");
        count3.put(25, "FBG");
        System.out.println("Map<Integer, String> sort by key");
        sortMapByKey(count3);
    }
}
