import java.util.HashSet;
import java.util.Set;

import algorithm.buildTree;

public class test1 {
    public int test1(int a, int b) {
        // 求小美的最少得分
        if (a >= 11) {
            if (a - b >= 2) {
                return 0;
            } else {
                return b - a + 2;
            }
        } else {
            if (a - b >= 2) {
                return 11 - a;
            } else {
                return 11 - b >= 2 ? 11 - a : b - a + 2;
            }
        }
    }

    public TreeNode buildTree() {
        TreeNode t1 = new TreeNode(1, 'A');
        TreeNode t2 = new TreeNode(2, 'B');
        TreeNode t3 = new TreeNode(3, 'C');
        TreeNode t4 = new TreeNode(4, 'C');
        TreeNode t5 = new TreeNode(5, 'A');
        TreeNode t6 = new TreeNode(6, 'D');
        t4.left = t6;
        t2.right = t4;
        t2.left = t3;
        t1.left = t2;
        t1.right = t5;

        return t1;
    }

    public int[] test2(TreeNode root) {
        int[] res = {};
        return res;
    }

    Set<Character> set = new HashSet<>();

    public void dfs(TreeNode root, int[] res) {
        if (root.left == null && root.right == null) {
            // 若遍历到页节点, 返回1
            res[root.num] = 1;
            set.add(root.val);
            return;
        }
        // 后续遍历
        dfs(root.left, res);
        dfs(root.right, res);

    }

    public static void main(String[] args) {
        test1 t1 = new test1();
        // int a = 10, b = 10;
        // System.out.println(t1.test1(a, b));
        TreeNode root = t1.buildTree();
        int[] res = t1.test2(root);
        for (int x : res)
            System.out.print(x + "  ");
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    char val;
    int num;

    public TreeNode(int num, char val) {
        this.num = num;
        this.val = val;
    }
}
