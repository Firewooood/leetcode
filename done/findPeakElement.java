package done;public class findPeakElement {
    public static void main(String[] args) {
        int[] nums = { 3,4,3,2,1 };
        System.out.println(findPeakElement1(nums));
    }

    public static int findPeakElement1(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;
        //边界处理
        if (nums[0] > nums[1])
            return 0;
        if(nums[len-1]>nums[len-2])
            return len - 1;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else if (nums[mid] < nums[mid - 1]) {
                high = mid;
            } else
                return mid;
        }
        return mid;
    }
}
