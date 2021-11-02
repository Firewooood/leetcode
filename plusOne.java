public class plusOne {
    public int[] f(int[] nums) {
        int n = nums.length;
        if (n == 1 && nums[0] == 0) {
            nums[0]++;
            return nums;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != 9) {
                nums[i]++;
                break;
            } else {
                nums[i] = 0;
            }
        }
        if (nums[0] == 0) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
        return nums;
        
    }
    public static void main(String[] args) {
        plusOne p = new plusOne();
        int[] nums = { 9,9,9,9,9 };
        int[] res = p.f(nums);
        for(int x:res)System.out.println(x);
    }
}
