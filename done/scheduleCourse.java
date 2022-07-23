package done;
import java.util.Arrays;
import java.util.PriorityQueue;

public class scheduleCourse {
    public static void main(String[] args) {
        int[][] courses = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
        scheduleCourse s1 = new scheduleCourse();
        System.out.println(s1.s1(courses));
    }
    
    /**
     * 这里有 n 门不同的在线课程，按从 1 到 n 编号。
     * 给你一个数组 courses ，其中 courses[i] = duration[i]
     * lastDay[i] 表示第 i 门课将会 持续 上 duration[i] 天课，并且必须在不晚于 lastDay[i] 的时候完成。
     * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
     * 返回你最多可以修读的课程数目。
     * 
     * @param courses
     * @return
     */
    public int s1(int[][] courses) {
        //按照 结束时间  对courses进行升序排序
        // (a, b) -> a[1] - b[1]  为comparator,
        //若comparator中的值大于0，则将前一个数和后一个数交换，即为所谓的升序排列
    
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        //使用优先队列  记录已选课程   从过往学习课程中找出持续时间最长的课程
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] c : courses) {
            int d = c[0], e = c[1];
            //d为持续时间，e为结束时间
            sum += d;
            q.add(d);
            if (sum > e)
                sum -= q.poll();
        }
        return q.size();
    }
}
