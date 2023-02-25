package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

import algorithm.BuildTree;

public class CodeC {

    // Encodes a tree to a single string.
    // [1,2,3,null,null,4,5,null,null,null,null]
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new ArrayDeque<>();
        StringJoiner sj = new StringJoiner(","); // 该初始化表示，不添加前后缀，sj.add("a") sj.add("b")后拼接为"a,b"
        q.add(root);
        sj.add(Integer.toString(root.val));
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur.left != null) {
                q.add(cur.left);
                sj.add(Integer.toString(cur.left.val));
            } else {
                sj.add("null");
            }
            if (cur.right != null) {
                q.add(cur.right);
                sj.add(Integer.toString(cur.right.val));
            } else {
                sj.add("null");
            }
        }
        return sj.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] nodes = data.split(","); // 将序列化后各节点 放入nodes列表中
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int index = 1, n = nodes.length;
        while (index < n) {
            TreeNode head = q.remove();
            if (!nodes[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[index]));
                head.left = left; // left 挂接到head上。
                q.add(left);
            }
            index++;
            if (index < n && !nodes[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[index]));
                head.right = right; // left 挂接到head上。
                q.add(right);
            }
            index++;
        }
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,-1,-1,4,5};
        TreeNode root = BuildTree.construct_binary_tree(nums);
        CodeC c1 = new CodeC();
        System.out.println(c1.serialize(root));
    }
}
