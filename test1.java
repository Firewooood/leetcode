import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    public int test3(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int temp = x % k;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            res = Math.max(res, map.get(key));
        }
        return res;
    }

    public String test4(int n, int k, int t) {
        if (k > n || t > k - 1 || t < 2 * k - n - 1)
            return "-1";
        // 可实现情况
        StringBuilder sb = new StringBuilder();
        // k - 1 - t 个0 隔开
        for (int i = 0; i < k - 1 - t; i++) {
            sb.append("1");
            sb.append("0");
        }
        // 全0
        for (int i = 0; i < n - 2 * k + 1 + t; i++) {
            sb.append("0");
        }
        // 全1,构成t对相邻11
        for (int i = 0; i < t + 1; i++) {
            sb.append("1");
        }
        System.out.println(sb.length());
        return sb.toString();
    }

    public int test5(int[] nums, int k) {
        int res = 0, i = 0; // 分别表示返回结果 当前箱中个数 滑动窗口初始位置
        double sum = 0;
        double avar = 0;
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            avar = sum / (j - i + 1);
            while (nums[j] > k * avar) {
                sum -= nums[i];
                i++;
                avar = sum / (j - i + 1);
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    // public int test6(int m, int t, int m1, int t1, int m2, int t2) {

    // }

    Map<Integer, Integer> map = new HashMap<>();

    public int test7(int x) {
        if (x == 1 || x == 2 || x == 3) { // 返回条件
            return 1;
        }
        if (map.containsKey(x)) {
            return map.get(x);
        }
        int res = test7(x - 3) + test7(x - 2) + test7(x - 1) + 1;
        map.put(x, res);
        return res;
    }

    int test8(int[] nums, int m) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        while (nums[n - m] > 0) {
            res += nums[n - m];
            for (int i = n - 1; i > n - m - 1; i--) {
                nums[i] -= nums[n - m];
            }
            Arrays.sort(nums);
        }
        return res;
    }

    public static void main(String[] args) {
        test1 t1 = new test1();
        // // int a = 10, b = 10;
        // // System.out.println(t1.test1(a, b));
        // TreeNode root = t1.buildTree();
        // int[] res = t1.test2(root);
        // for (int x : res)
        // System.out.print(x + " ");
        // int[] nums = { 1, 4, 2, 3, 5 };
        // System.out.println(t1.test3(nums, 3));

        // int n = 32, k = 22, t = 11;
        // System.out.println(t1.test4(n, k, t));
        // int[] nums = { 1, 1, 1, 1, 1, 1, 1, 10 };
        // int k = 2;
        // System.out.println(t1.test5(nums, k));
        // System.out.println(t1.test6(10, 2, 1, 5, 2, 5));
        // System.out.println(t1.test7(3));
        int[] nums = { 1, 19, 13, 4, 16, 12, 5, 8, 14, 6 };
        System.out.println(t1.test8(nums, 10));
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
