
package done;

import java.util.ArrayList;
import java.util.List;

public class goodDaysToRobBank {
    public static void main(String[] args) {
        goodDaysToRobBank g1 = new goodDaysToRobBank();
        List<Integer> res = new ArrayList<>();
        int[] security = { 3, 3, 3, 3, 3, 3, 3};
        int time = 2;
        res = g1.g1(security, time);
        for(Integer x:res){ 
            System.out.println(x);
        }
    }
    
    /**
     * 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
     * 
     * 第 i 天前和后都分别至少有 time 天。
     * 第 i 天前连续 time 天警卫数目都是非递增的。
     * 第 i 天后连续 time 天警卫数目都是非递减的。
     * 
     * @param security security[i] 是 第 i天执勤警卫的数量
     * @param time
     * @return 包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列
     */
    public List<Integer> g1(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        if (n <= 2 * time)
            return res;
        loop:for (int i = time; i < n - time; i++) {
            for (int j = 0; j < time; j++) {
                if (security[i - j] > security[i - j - 1])
                    continue loop;
                if (security[i + j] > security[i + j + 1])
                    continue loop;
            }
            res.add(i);
        }
        return res;
    }
}
