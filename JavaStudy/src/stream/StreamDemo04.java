package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @description: Stream流 测试Demo-04 Max、Min
 * @author: Komorebi
 * @time: 2021/9/10 09:54
 */
public class StreamDemo04 {
    public static void main(String[] args) {
        // 1 创建一个Category集合
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1L, "Java", "java", 0L, 1));
        categoryList.add(new Category(2L, "PHP", "PHP", 0L, 2));
        categoryList.add(new Category(3L, "JavaScript", "JavaScript", 0L, 3));
        categoryList.add(new Category(4L, "Python", "Python", 0L, 10));
        categoryList.add(new Category(5L, "Go", "Go", 0L, 8));
        categoryList.add(new Category(6L, "Ruby", "Ruby", 0L, 4));

        // max
        Optional<Category> optionalCategory = categoryList.stream().max((Comparator.comparingInt(Category::getSort)));
        optionalCategory.ifPresent(System.out::println);
    }
}
