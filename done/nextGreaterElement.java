package done;

import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        nextGreaterElement n = new nextGreaterElement();
        int[] nums1 = { 2, 4 };
        int[] nums2 = { 1, 2, 3, 4 };
        int[] res = n.f1(nums1, nums2);
        for (int x : res)
            System.out.println(x);
    }

    /*
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     ** 
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     **/

    public int[] f1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            stack.clear();
            int cur = nums1[i];
            int j = nums2.length - 1;
            while (j >= 0) {
                if (nums2[j] > cur)
                    stack.add(nums2[j]);// 从右边起，将比nums1[i]大的元素加入栈
                if (nums2[j] == cur)
                    break;
                j--;
            }
            if (stack.empty()) {
                res[i] = -1;
            } else {
                res[i] = stack.pop();
            }
        }
        return res;
    }
}
