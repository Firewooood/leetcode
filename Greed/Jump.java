package Greed;

public class Jump {
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int max = nums[0], pre = 0; // 记录0 ~ i 可以到达的最大位置, pre 记录前一最大位置
        int res = 0, i = 0;
        while (i < nums.length) {
            if (max >= nums.length - 1) {
                return ++res;
            }
            if (i < pre) {
                i++;
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return ++res;
                }
            } else {
                res++; // 前进一步
                pre = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        Jump j1 = new Jump();
        System.out.println(j1.jump(nums));
    }
}
