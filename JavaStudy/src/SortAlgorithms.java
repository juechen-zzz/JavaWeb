import java.util.Arrays;

/**
 * @description: 整理一下常用排序算法
 * @author: Komorebi
 * @time: 2021/5/11 19:38
 */
public class SortAlgorithms {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 3, 3, 1, 6, 2, 7, 4, 5};
        System.out.print("原始数组为：");
        System.out.println(Arrays.toString(nums));

        mergeSort(nums, 0, nums.length - 1);
        System.out.print("排序后：");
        System.out.println(Arrays.toString(nums));
    }


    /**
     * @description 冒泡排序
     * @date 2021/5/11
     * @param
     * @return 
     */
    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {return;}

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {break;}
        }
    }

    /**
     * @description 插入排序
     * @date 2021/5/11
     * @param 
     * @return 
     */
    private static void insertSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
                j--;
            }
            nums[j + 1] = value;
        }
    }

    /**
     * @description 选择排序
     * @date 2021/5/11
     * @param 
     * @return 
     */
    private static void chooseSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {return;}

        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            swap(nums, i, k);
        }
    }

    /**
     * @description 快速排序
     * @date 2021/5/11
     * @param 
     * @return 
     */
    private static void quickSort(int[] nums, int left, int right) {
        int n = nums.length;
        if (n <= 1) {return;}

        if (left < right) {
            int key = nums[left];
            int i = left, j = right;
            while ( i <= j) {
                while (nums[i] < key && i < right) {i++;}
                while (nums[j] > key && j > left) {j--;}
                if (i <= j) {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
            }

            if (j > left) {quickSort(nums, left, j);}
            if (i < right) {quickSort(nums, i, right);}
        }
    }

    /**
     * @description 归并排序
     * @date 2021/5/11
     * @param
     * @return
     */
    private static void mergeSort(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {temp[k++] = nums[i++]; }
        while (j <= right) {temp[k++] = nums[j++];}

        for (int m = 0; m < temp.length; m++) {
            nums[m + left] = temp[m];
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
