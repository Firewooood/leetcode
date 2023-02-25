package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import BinaryTree.TreeNode;

//通过数组的形式添加二叉树
public class BuildTree {
    public static TreeNode construct_binary_tree(int[] arr) {
        List<TreeNode> list = new ArrayList<>();
        Collections.fill(list, null);
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if (arr[i] != -1) { // 使用-1表示空节点。
                node = new TreeNode(arr[i]);
            }
            list.add(i, node);
            if (i == 0) {
                root = node;
            }
        }
        for (int i = 0; 2 * i + 2 < arr.length; i++) {
            if (list.get(i) != null) {
                // 二叉树和左右节点的关系如下。
                list.get(i).left = list.get(2 * i + 1);
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return root;
    }

    // 将同一层的二叉树节点放在一个列表中
    public static List<List<Integer>> show(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        // 构建二叉树
        TreeNode root = construct_binary_tree(arr);
        // 层序遍历二叉树
        List<List<Integer>> res = show(root);
        // 打印结果
        for (List<Integer> ans : res) {
            System.out.print(ans);
        }
        scanner.close();
    }
}
