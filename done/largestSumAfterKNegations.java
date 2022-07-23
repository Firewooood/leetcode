package done;import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class largestSumAfterKNegations {
    public static void main(String[] args) {
        largestSumAfterKNegations l1 = new largestSumAfterKNegations();
        int[] nums = { -4,-2,-3};
        int k = 4;
        System.out.println(l1.l1(nums, k));
    }
    
    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     * 
     * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     * 
     * 以这种方式修改数组后，返回数组可能的最大和 。
     * @param nums
     * @param k
     * @return
     */
    public int l1(int[] nums, int k) {
        int len = nums.length, n = 0; //使用n记录nums数组中小于等于0的数的数目
        int res = 0;
        int[] nums1 = nums.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums1); //将nums1由小到大排列
        for (int i = 0; i < len; i++) {
            res += nums[i];
            if (nums1[i] < 0)
                n++;
            map.put(nums1[i], i + 1);
        }

        if (n == 0) {
            if(k % 2 ==1)
                res -= 2 * nums1[0];
            return res;
        }
        //nums中负数较翻转次数多，由小到大，将负数变为正数，所得和最多。
        if (n >= k) {
            for (int i = 0; i < k; i++) {
                res += -2 * nums1[i];
            }
        }//nums中负数较翻转次数少
        else {//将负数全部翻转
            for (int i = 0; i < n; i++) {
                res += -2 * nums1[i];
            }
            int temp;//使用temp记录最小正数。
            if(len > n){
                 temp = -nums1[n - 1] > nums1[n] ? nums1[n] : -nums1[n - 1];
            } 
            else{
                 temp = -nums1[n-1];
            }
            if((k-n)%2==1)
                res += -2 * temp;
        }
        
        return res;
    }
}
