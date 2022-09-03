package done;

import java.util.Arrays;

public class test1 {

    // 求出nums 中连续最长子段
    public int test(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int res = 0, count = 1;
        Arrays.sort(nums);
        // 去除重复数
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }

        for (int i = 0; i < j - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        test1 t1 = new test1();
        int[] nums = { 1, 4, 200, 1, 3, 2 };
        System.out.println(t1.test(nums));
    }
}
