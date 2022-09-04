package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int sum = 0;
        int x = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = nums1[i] + nums2[j];
                x = map1.getOrDefault(sum, 0) + 1;
                map1.put(sum, x);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = nums3[i] + nums4[j];
                x = map2.getOrDefault(sum, 0) + 1;
                map2.put(sum, x);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int cur = entry.getKey();
            if (map2.containsKey(0 - cur)) {
                res += entry.getValue() * map2.get(0 - cur);
            }
        }
        return res;
    }

    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int x = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = nums1[i] + nums2[j];
                x = map.getOrDefault(sum, 0) + 1;
                map.put(sum, x);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = -1 * (nums3[i] + nums4[j]);
                if (map.containsKey(sum))
                    res += map.get(sum);
            }
        }
        return res;
    }

    public int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = (nums1[i] + nums2[j]);
                if (map.containsKey(target)) {
                    map.put(target, map.get(target) + 1);
                } else {
                    map.put(target, 1);
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int tmp = -(nums3[k] + nums4[l]);
                if (map.containsKey(tmp)) {
                    res += map.get(tmp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSumCount f1 = new FourSumCount();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -1, 2 };
        int[] nums3 = { -2, -1 };
        int[] nums4 = { 0, 2 };
        System.out.println(f1.fourSumCount3(nums1, nums2, nums3, nums4));
    }
}
