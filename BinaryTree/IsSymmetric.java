package BinaryTree;

import java.nio.charset.MalformedInputException;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        // 1. 将右子树 的所有左右子节点相互调换
        if (root.right != null)
            reverse(root.right);
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) { // 左右节点不全为空时，返回false
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        if (left == null && right == null)
            return true;
        if (left.val != right.val)
            return false;

        return dfs(left.left, right.left) || dfs(left.right, right.right);
    }

    // 将树的所有左右子节点 互相调换
    public TreeNode reverse(TreeNode root) {
        if (root == null)
            return root;
        TreeNode tmp = reverse(root.right);
        root.right = reverse(root.left);
        root.left = tmp;
        return root;
    }

}
