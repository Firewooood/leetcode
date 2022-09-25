package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (nums.length < 2)
            return res;

        backTracking(nums, res, path, 0);
        return res;
    }

    void backTracking(int[] nums, List<List<Integer>> res, List<Integer> path, int startIndex) {
        if (path.size() >= 2)
            res.add(new ArrayList<>(path)); // 符合条件的子集先加入结果集

        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100] == 1)
                continue;
            path.add(nums[i]);
            used[nums[i] + 100] = 1;
            backTracking(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        FindSubsequences f1 = new FindSubsequences();
        int[] nums = { 4, 6, 7, 7 };
        List<List<Integer>> re = f1.findSubsequences(nums);
    }
}
