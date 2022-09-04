package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] 
     * （若两个四元组元素一一对应，则认为两个四元组重复）：
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序后便于去重
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重,若有重复数,只考虑第一次出现的情况
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (right > left) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target)
                        right--;
                    else if (nums[i] + nums[j] + nums[left] + nums[right] < target)
                        left++;
                    else {
                        // 此时四数相加等于target
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]))); // 将符合条件的四元组加入结果集
                        while (right > left && nums[right] == nums[right - 1])
                            right--;
                        while (right > left && nums[left] == nums[left + 1])
                            left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum f1 = new FourSum();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        List<List<Integer>> res = f1.fourSum(nums, target);
        System.out.println(res.size());
    }
}
