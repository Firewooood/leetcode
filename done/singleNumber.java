package done;
import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    public static void main(String[] args) {
        singleNumber s1 = new singleNumber();
        int[] nums = { 3, 4, 3, 3 };
        System.out.println(s1.singleNumber1(nums));
    }

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 3)
                map.remove(x);
        }
        int ans = 0;
        for (Integer res : map.keySet())
            ans = res;
        return ans;
    }
}
