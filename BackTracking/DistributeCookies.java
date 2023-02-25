package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistributeCookies {
    static int res = Integer.MAX_VALUE;

    public static int distributeCookies(int[] cookies, int k) {
        List<Integer> nums = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++) {
            nums.add(0);
        }
        dfs(cookies, nums, k, 0);
        return res;
    }

    static void dfs(int[] cookies, List<Integer> nums, int k, int i) {
        if (i == cookies.length) {
//            res = Math.min(res, (nums.stream().max(Integer::compareTo).get()).intValue());
            res = Math.min(res, Collections.max(nums));
            return;
        }
        for (int j = 0; j < k; j++) {
            nums.set(j, nums.get(j) + cookies[i]);
            dfs(cookies, nums, k, i + 1);
            nums.set(j, nums.get(j) - cookies[i]);
        }
    }

    public static void main(String[] args) {
        int[] cookies = new int[]{8, 15, 10, 20, 8};
        int k = 2;
        System.out.println(distributeCookies(cookies, k));
    }
}
