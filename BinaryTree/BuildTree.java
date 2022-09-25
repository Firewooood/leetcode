package BinaryTree;

import algorithm.buildTree;

public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    public TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2)
            return null;

        int val = postorder[r2];
        int i = 0;
        for (i = l1; i <= r1; i++) {
            if (inorder[i] == val)
                break;
        }
        TreeNode root = new TreeNode(val);
        root.left = build(inorder, l1, i - 1, postorder, l2, i - 1 - l1 + l2);
        root.right = build(inorder, i + 1, r1, postorder, r2 - r1 + i, r2 - 1);
        return root;
    }

    public static void main(String[] args) {
        BuildTree b1 = new BuildTree();
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        b1.buildTree(inorder, postorder);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
