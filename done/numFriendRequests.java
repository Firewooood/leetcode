package done;
import java.util.Arrays;

public class numFriendRequests {
    public static void main(String[] args) {
        numFriendRequests n1 = new numFriendRequests();
        int[] ages = { 20, 30, 100, 110, 120 };
        System.out.println(n1.n1(ages));
    }
    // 从三个不发送好友请求的条件来看，以 yy 的角度来说，
    // 可总结为：年龄比我小的不考虑（同龄的可以），
    // 年龄比我大可以考虑，但是不能超过一定范围则不考虑。
    public int n1(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length, res = 0;
        for (int k = 0, i = 0, j = 0; k < n; k++) {
            //使用i、j维护左右区间
            //[i,j)代表在ages上会向y = ages[k]发送请求的连续段
            while (i < k && !check(ages[i], ages[k]))
                i++;
            if (j < k)
                j = k;
            while (j < n && check(ages[j], ages[k]))
                j++;
            if (j > i)
                res += j - i - 1;
        }
        return res;
    }
    
    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7)
            return false;
        if (y > x)
            return false;
        if (y > 100 && x < 100)
            return false;
        return true;
    }
}
