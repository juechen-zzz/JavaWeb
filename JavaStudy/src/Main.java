import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 5, 3, -1};
        System.out.println(MyMethod(nums));
    }

    private static int MyMethod(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        return sum;
    }
}