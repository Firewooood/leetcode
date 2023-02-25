package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode pre = null;
        TreeNode cur = null;
        for (int i = 0; i < list.size(); i++) {
            cur = list.get(i);
            if (pre != null) {
                pre.right = cur;
                pre.left = null;
            }
            pre = cur;
        }
        cur.left = null;
        cur.right = null;
    }

    void dfs(TreeNode root, List<TreeNode> list){
        if (root == null)
            return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
