import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split("\\s+");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[][] nums = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] tmp2 = sc.nextLine().split("\\s+");
            nums[i][0] = Integer.parseInt(tmp2[0]);
            nums[i][1] = Integer.parseInt(tmp2[1]);
        }

        myMethod(N, M, nums);
    }

    private static void myMethod(int N, int M, int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int ans = 0;

        for (int i = 0; i < M; i++) {
            ans += nums[0][0];
            nums[0][0] = nums[0][0] - nums[0][1];
            if (nums[0][0] < 0) {
                nums[0][0] = 0;
            }
            Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        }

        System.out.println(ans);
    }
}