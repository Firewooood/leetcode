import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k); // 创建大小为k的小顶堆
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                // 若小顶堆此时已满
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        FindKthLargest f1 = new FindKthLargest();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 3;
        System.out.println(f1.findKthLargest(nums, k));
    }
}
