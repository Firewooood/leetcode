import java.util.LinkedList;
import java.util.Queue;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE, sum = 0;
        boolean flag = false;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
            sum += nums[i];
            while (sum >= target) {
                flag = true;
                min = Math.min(min, queue.size());
                sum -= queue.poll();
            }
        }
        return flag ? min : 0;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] nums = { 1, 4, 4 };
        MinSubArrayLen m1 = new MinSubArrayLen();
        System.out.println(m1.minSubArrayLen(target, nums));
    }
}
