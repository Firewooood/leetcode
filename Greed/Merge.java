package Greed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    /**
     * 合并所有重叠区间，返回一个不重叠的区间数组
     * 
     * @param intervals intervals[i] = [starti, endi]
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        // 将原区间按starti 从小到大排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // 定义下两个变量表示当前待添加区间
        int starti = -1;
        int endi = -1;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > endi) { // 新区间和原区间无交集
                if (i != 0) {
                    // 将原区间加入结果集中
                    int[] tmp = new int[] { starti, endi };
                    res.add(tmp);
                }
                // 更新待添加区间
                starti = intervals[i][0];
                endi = intervals[i][1];
            } else { // 新区间和原区间有交集
                endi = Math.max(endi, intervals[i][1]);
            }

            if (i == intervals.length - 1) {
                // 若到了最后一元素
                int[] tmp = new int[] { starti, endi };
                res.add(tmp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 17 }, { 15, 18 } };
        Merge m1 = new Merge();
        int[][] res = m1.merge(intervals);
    }
}
