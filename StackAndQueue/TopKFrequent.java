package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * 给出一个整数数组 nums 和一个整数 k，返回其中出现频率前k高的元素。
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        // 根据map 的value 正序排列 创建小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> minTop = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        // 在comparator 中，如果a - b > 0，则交换a b的位置。 则上面的比较器是创建小顶堆
        // 使用hashmap ， key为nums中的元素，value为元素的出现次数。
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minTop.offer(entry); // 此处也可用add方法，add和offer的区别是 添加元素个数大于队列大小时，offer返回false，add会报异常
            // 小顶堆中元素个数大于k个时，堆顶弹出。 则最后较小的均弹出，在小顶堆中的即是频率前k高的元素
            if (minTop.size() > k) {
                minTop.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minTop.poll().getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequent t1 = new TopKFrequent();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] res = t1.topKFrequent(nums, k);
        for (int x : res)
            System.out.print(x + " ");
    }
}
