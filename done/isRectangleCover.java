package done;import java.util.HashSet;
import java.util.Set;

public class isRectangleCover {
    public static void main(String[] args) {
        isRectangleCover i = new isRectangleCover();
        int[][] rect = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1, 3, 2, 4 }, { 2, 3, 3, 4 } };
        System.out.println(i.isRectangleCover1(rect));
    }

    /**
     * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 
     * 表示一个坐标轴平行的矩形。
     * 这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
      如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
     * @param rect
     * @return
    */

    //大矩形的左下、左上、右下、右上的点均只出现一次，
    //且由四点组成的矩形面积应为各小矩形面积之和
    public boolean isRectangleCover1(int[][] rect) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int n = rect.length;
        
        Set<String> set = new HashSet<>();
        int sumArea = 0;
        for (int i = 0; i < n; i++) {
            //获取四个点的坐标
            left = Math.min(left, rect[i][0]);
            bottom = Math.min(bottom, rect[i][1]);
            right = Math.max(right, rect[i][2]);
            top = Math.max(top, rect[i][3]);
            //计算总小矩形的面积
            sumArea += (rect[i][3] - rect[i][1]) * (rect[i][2] - rect[i][0]);
            //分别记录小矩形的坐标
            String lt = rect[i][0] + " " + rect[i][3];
            String lb = rect[i][0] + " " + rect[i][1];
            String rt = rect[i][2] + " " + rect[i][3];
            String rb = rect[i][2] + " " + rect[i][1];
            //若有则移除，没有则加入
            if (!set.contains(lt))
                set.add(lt);
            else
                set.remove(lt);
            if (!set.contains(lb))
                set.add(lb);
            else
                set.remove(lb);
            if (!set.contains(rt))
                set.add(rt);
            else
                set.remove(rt);
            if (!set.contains(rb))
                set.add(rb);
            else
                set.remove(rb);
        }

        //若最后只剩四个大矩形且面积相等，即为完美矩形
        if(set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + bottom)
                && set.contains(right + " " + bottom) && set.contains(right + " " + top))
        {
            return sumArea == (right - left) * (top - bottom);
        }
        return false;
    }
}