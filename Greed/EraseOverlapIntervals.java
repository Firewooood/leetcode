package Greed;

import java.util.Arrays;

public class EraseOverlapIntervals {
    /**
     * 
     * @param intervals intervals[i] = [starti, endi]
     * @return 删除区间的最小数量，使剩余区间互不重叠
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        // 将intervals 按照右区间从小到大排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int range = intervals[0][1]; // range表示目前覆盖到区域右边界
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= range) { // 新增区域的左边界>=range，则与原区域无重复
                range = intervals[i][1]; // 扩展原区域
            } else {
                res++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals e1 = new EraseOverlapIntervals();
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(e1.eraseOverlapIntervals(intervals));
    }
}
