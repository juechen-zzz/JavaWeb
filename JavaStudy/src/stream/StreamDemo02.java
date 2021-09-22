package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Stream流 测试Demo-02 过滤
 * @author: Komorebi
 * @time: 2021/9/9 23:52
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        // 1 创建一个Category集合
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1L, "Java", "java", 0L, 1));
        categoryList.add(new Category(2L, "PHP", "PHP", 0L, 2));
        categoryList.add(new Category(3L, "JavaScript", "JavaScript", 0L, 3));
        categoryList.add(new Category(4L, "Python", "Python", 0L, 10));
        categoryList.add(new Category(5L, "Go", "Go", 0L, 8));
        categoryList.add(new Category(6L, "Ruby", "Ruby", 0L, 4));

        // 过滤
        categoryList = categoryList.stream().filter(category -> category.getId().equals(2L)).collect(Collectors.toList());

        // 打印
        categoryList.forEach(System.out::println);
    }
}