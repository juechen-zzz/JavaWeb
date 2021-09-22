import java.util.*;
public class Main {
    public static void main(String[] args) {
        String s = "1 3 5";
        System.out.println(s.split(" "));       // 返回["1"， "2"， "3"]这个数组

        String[] tmp = s.split(" ");
        String ans = "[";
        for (int i = 0; i < tmp.length; i++) {
            ans += ("'" + tmp[i] + "',");
        }
        System.out.println(ans.substring(0, ans.length() - 1));

//        Scanner sc = new Scanner(System.in);
//
//        int averageScore = sc.nextInt();
//        int n = sc.nextInt();
//        sc.nextLine();
//
//        int[] nums = new int[n * 2];
//        for (int i = 0; i < 2 * n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        myMethod(averageScore, n, nums);
    }

    private static void myMethod(int averageScore, int n, int[] nums) {
        int sum = 0;
        for (int cur : nums) {sum += cur % averageScore;}
        if (sum != 0) {
            System.out.println(0);
        }
        else {
            Arrays.sort(nums);
            String ans = "";
            for (int i = 2 * n - 1; i >= 0; i--) {
                if (nums[i] == -2) {continue;}
                ans += (nums[i] + " ");
                nums[i] = -2;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == -2) {continue;}
                    if ((nums[i] + nums[j]) % averageScore == 0) {
                        ans += (nums[j] + " ");
                        nums[j] = -2;
                    }
                }
            }
            System.out.println(ans.substring(0, ans.length() - 1));
        }
    }
}