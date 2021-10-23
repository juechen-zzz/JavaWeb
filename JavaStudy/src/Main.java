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