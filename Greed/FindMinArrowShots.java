package Greed;

import java.util.Arrays;
import java.util.LinkedList;

public class FindMinArrowShots {
    /**
     * 
     * @param points points[i] = [xstart, xend]
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        // xstart小的在前，若xstart一样，xend小的在前
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[1], b[1]);
        });
        LinkedList<Integer> list = new LinkedList<>(); // 存放射出弓箭的坐标
        for (int i = 0; i < points.length; i++) {
            if (list.isEmpty() || list.getLast() < points[i][0]) {
                // 当没有弓箭时，或弓箭坐标最大值 仍小于当前气球的xstart， 在气球的xend处发射弓箭
                list.addLast(points[i][1]);
            }
            if (points[i][1] < list.getLast()) {
                list.removeLast();
                list.add(points[i][0]); // 若当前气球的xend 小于箭的x值，则从当前xend处射出必能穿过前一箭的覆盖
            }
        }

        return list.size();
    }

    public static void main(String[] args) {
        FindMinArrowShots f1 = new FindMinArrowShots();
        int[][] points = { { 1, 2 }, { 3, 4 }, { 2, 3 }, { 4, 5 } };
        System.out.println(f1.findMinArrowShots(points));
    }
}
