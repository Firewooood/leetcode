package LinkedList;

public class MinSubArrayLen {

    /**
     * 
     * @param target
     * @param nums
     * @return 满足其和>= target 的长度最小的连续子数组长度
     *         如果不存在 返回 0
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        int s = 0, e = 0;// s 表示子数组起始坐标， e 表示子数组终止坐标
        int sum = 0, res = Integer.MAX_VALUE;

        // 将特殊情况排除掉
        for (int x : nums)
            sum += x;
        System.out.println(sum);
        if (sum < target)
            return 0;

        sum = 0;
        while (true) {
            while (sum < target && e < len) {
                // 当前子数组和小于target时，e向右扩张
                sum += nums[e];
                e++;
            }
            res = Math.min(res, e - s);
            if (e == len && sum - nums[s] < target)
                break;
            sum -= nums[s]; // 将s向右移。
            s++;
        }

        return res;

    }

    // 滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int sum = 0; // 滑动窗口数值之和
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++]; // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        MinSubArrayLen m1 = new MinSubArrayLen();
        int[] nums = { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
        System.out.println(m1.minSubArrayLen1(213, nums));
    }

}
