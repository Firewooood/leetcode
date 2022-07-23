package done;
public class verifyPostorder {
    public static void main(String[] args) {
        verifyPostorder v1 = new verifyPostorder();
        System.out.println(v1.verifyPostorder1(new int[] {4,6,7,5}));
    }
    public boolean verifyPostorder1(int[] postorder) {
        // 二叉搜索树 使用后序遍历
        int len = postorder.length;
        return postOrder(postorder, 0, len - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean postOrder(int[] postorder, int start, int end, int min, int max) {
        if (start > end)
           return true;
        int root = postorder[end]; // 数组的最后一个位置为根节点
        if (root <= min || root >= max) {
            return false;
        }
        int right = start;
        int left = right - 1;
        for (int i = start; i < end; i++) {
            if (postorder[i] > root) {
                right = i;
                left = i - 1;
                break;
            }
        }
        return postOrder(postorder, start, left, min, root) && postOrder(postorder, right, end - 1, root, max);
    }
}
