package done;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class visiblePoints_hard {
    public static void main(String[] args) {
        new visiblePoints_hard();
        new ArrayList<>();
        System.out.println();

    }
    
    public int v1(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>(); //存储夹角数据
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180; //t为角的弧度制表达
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            if (a == x && b == y && ++cnt >= 0)
                continue;
            list.add(Math.atan2(b - y, a - x)); //添加不在(x1,y1) x = x1, y = y1,上的点的角度 
        }
        Collections.sort(list);//将角度进行排序， 值域范围为[-180',180'];
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++)
            list.add(list.get(i) + 2 * pi); //加上2Π后，将问题变为了连续求解问题 ，原值域的取值范围，
            //会丢失夹角横跨一四象限的情况
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t)
                i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }
}
