package BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindMode {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
        int num = 0;
        for (Map.Entry<Integer, Integer> a : entry) {
            if (a.getValue() == max)
                num++;
        }
        int[] res = new int[num];
        num = 0;
        for (Map.Entry<Integer, Integer> a : entry) {
            if (a.getValue() == max) {
                res[num++] = a.getKey();
            }
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        int value = map.getOrDefault(root.val, 0) + 1;
        max = Math.max(value, max);
        map.put(root.val, value);
        dfs(root.right);
    }
}