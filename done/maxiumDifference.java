package done;
public class maxiumDifference {
    public static void main(String[] args) {
        maxiumDifference m1 = new maxiumDifference();
        int[] nums = { 9,4,3,2 };
        System.out.println(m1.m1(nums));
    }

    /**
     * 请你计算 nums[j] - nums[i] 能求得的 最大差值 ，
     * 其中 0 <= i < j < n 且 nums[i] < nums[j] 。
     * 返回最大差值，如果不存在满足要求的i和j，返回-1 
     * @param nums
     * @return
     */
    public int m1(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] > max)
                    max = nums[j] - nums[i];
            }
        }
        if (max <= 0)
            return -1;
        return max;
    }

    //最小差值 的 较小数 一定是整个数组的最小值
    public int m2(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0, min = nums[0]; i < n; i++) {
            if (nums[i] > min)
                res = Math.max(res, nums[i] - min);
            min = Math.min(min, nums[i]);
            
        }
        return res;
    }
}
