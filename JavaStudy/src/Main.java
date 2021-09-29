import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] nums = new int[n];
        String[] tmp = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }
        myMethod(n, nums);
    }

    private static void myMethod(int n, int[] nums) {
        int MOD = 1_0000_0000_7;
        long ans = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                int[] tmp = Arrays.copyOfRange(nums, i, j + 1);
                int min = Arrays.stream(tmp).min().getAsInt();
                int max = Arrays.stream(tmp).max().getAsInt();
                ans = (ans + ((max - min) * (j - i + 1)) % MOD) % MOD;
            }
        }

        System.out.println(ans);
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        sc.nextLine();
//
//        int[] nums = new int[n];
//        String[] tmp = sc.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(tmp[i]);
//        }
//
//        int k = sc.nextInt();
//        myMethod(n, nums, k);
//    }
//
//    private static void myMethod(int n, int[] nums, int k) {
//        int end = 0, maxPosition = 0, steps = 0;
//
//        for(int i = 0; i < nums.length - 1; i++){
//            maxPosition = Math.max(maxPosition, nums[i] + i);
//            if(i == end){
//                end = maxPosition;
//                steps++;
//            }
//        }
//
//        if (steps <= k) {
//            System.out.println(steps);
//        }
//        else {
//            System.out.println(-1);
//        }
//    }
//}