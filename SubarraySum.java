import java.util.HashMap;
import java.util.Map;

class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length, res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();    //使用map记录出现同样和的次数
        map.put(0, 1);  
        int[] pre = new int[len];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
    public static void main(String[] args) {
        int[] nums = { 1,2,3,1 };
        int k = 3;
        SubarraySum s1 = new SubarraySum();
        System.out.println(s1.subarraySum(nums, k));
    }
}