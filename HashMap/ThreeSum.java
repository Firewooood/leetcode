package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    /**
     * 哈希法处理该问题。需要先排序后对重复数进行去重。
     * 
     * 该方法已放弃，后使用双指针。
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = -1 * (nums[i] + nums[j]);
                if (map.containsKey(sum)) {
                    int k = map.get(sum);
                    if (k > i && k > j) {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[k]);
                        res.add(cur);
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) // 如果排序后第一个元素大于零，则无法构成三元组
                break;
            if (k > 0 && nums[k] == nums[k - 1])// 去重
                continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) { // i+=1 跳过所有重复的nums[i]
                    while (i < j && nums[i] == nums[++i])
                        ;
                } else if (sum > 0) { // j-=1 跳过所有重复的nums[j]
                    while (i < j && nums[j] == nums[--j])
                        ;
                } else { // 记录组合[k,i,j] 到res中，++i，--j 跳过所有重复的nums[i] nums[j]
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i])
                        ;
                    while (i < j && nums[j] == nums[--j])
                        ;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum t1 = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = t1.threeSum1(nums);
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : res) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        System.out.println(sb.toString());
    }

    // 输出部分
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
