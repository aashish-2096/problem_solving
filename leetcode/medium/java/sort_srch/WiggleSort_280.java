package sort_srch;

public class WiggleSort_280 {
    void swap(int i, int j, int[] nums) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len >= 3) {
            for (int i = 0; i <= len - 2; i += 2) {
                int a = nums[i];
                int b = nums[i + 1];
                if (i + 2 >= len) {
                    if (a > b) {
                        nums[i] = b;
                        nums[i + 1] = a;
                        break;
                    }
                } else {
                    int c = nums[i + 2];
                    int max = Math.max(a, Math.max(b, c));
                    nums[i + 1] = max;
                    if (a == max) {
                        if (b <= c) {
                            nums[i] = b;
                        } else {
                            nums[i] = c;
                            nums[i + 2] = b;
                        }
                    } else if (c == max) {
                        if (b <= a) {
                            nums[i] = b;
                            nums[i + 2] = a;
                        } else {
                            nums[i + 2] = b;
                        }
                    }
                }
            }
        } else if (len == 2) {
            if (nums[0] > nums[1]) {
                swap(0, 1, nums);
            }
        }
    }
}
