package done;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 给你两个整数数组 persons 和 times 。
 * 在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 * 
 * 对于发生在时刻 t 的每个查询，
 * 需要找出在 t 时刻在选举中领先的候选人的编号。
 * 
 * 在 t 时刻投出的选票也将被计入我们的查询之中。
 * 在平局的情况下，最近获得投票的候选人将会获胜。
 * 实现 TopVotedCandidate 类：
 * TopVotedCandidate(int[] persons, int[] times) 
 * 使用 persons 和 times 数组初始化对象。
 */

public class topVotedCandidate {
    List<int[]> list = new ArrayList<>();

    public topVotedCandidate(int[] persons, int[] times) {
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= val) {
                val = map.get(persons[i]);
                //使用val维护当前的票的最大数量，使用list来记录不同时刻的候选人交替情况
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }                           

    /*
    int q(int t) 根据前面描述的规则，
    * 返回在时刻 t 在选举中领先的候选人的编号。*/
    public int q(int t) {
        //使用二分查找的方法获得当前时间的最大票数候选人
       int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0] <= t) l = mid;
            else r = mid - 1;
        }
        return list.get(r)[0] <= t ? list.get(r)[1] : 0;
    }
}
