package BinaryTree;

import done.numFriendRequests;

public class TirmBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        // root 及 root.left 都会小于low
        if (root.val < low)
            return trimBST(root.right, low, high);

        // root 及 root.right 都会大于right
        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1, n0, n2);

        TirmBST t1 = new TirmBST();
        TreeNode res = t1.trimBST(n1, 1, 2);
        System.out.println(res.val);
    }

}
