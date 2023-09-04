package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LongestPath {
    List<Integer>[] tree;
    int res;
    String s;

    public int longestPath(int[] parent, String s) {
        this.s = s;
        int n = parent.length;
        tree = new ArrayList[n];
        for (int i = 1; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            tree[parent[i]].add(i);
        }
        dfs(0);
        return res + 1;
    }

    int dfs(int x) {
        // 先用maxLen 更新 res，再更新 maxLen 巧妙得到 第一大和第二大的值，
        // 并且完美处理了只存在 0/1 个有效子树值 的情况
        int maxLen = 0;
        for (Integer y : tree[x]) {
            // 遍历x的所有子节点
            int len = dfs(y) + 1;
            if (s.charAt(x) != s.charAt(y)) {
                res = Math.max(res, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
