package done;
import java.util.LinkedList;

public class maxSlidingWindow {
    //该题不可使用大顶堆求解，但大顶堆只能得到最大值，并不能按滑动窗口的要求移除较小值。
    //使用双端队列，从末端入队，首端出值
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>();  //使用双端队列，按数从大到小的顺序来存储 数的下标
        int k1 = k;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                //将小于nums[i] 的数的下标全部移除
                q.removeLast();
            }
            q.addLast(i);
            if (q.peek() < i - k1 + 1) {
                q.pop();//若头部的下标不在滑动窗口中，则头部移出
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
        }  

    public static void main(String[] args) {
        maxSlidingWindow m1 = new maxSlidingWindow();
        int []nums = {1,3,-1,-3,5,3,6,7};
        int[] res = m1.maxSlidingWindow1(nums, 3);
        for (int x : res) {
            System.out.print(x);
            System.out.print(" ");
        }
    }
    
}
