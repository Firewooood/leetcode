package done;public class findMinMove {
    public static void main(String[] args) {
        int[] machines = { 1, 0, 5 };
        System.out.println(findMinMove1(machines));
    }
    
    public static int findMinMove1(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0)//若不能使每台洗衣机中衣物的数量相等，返回-1。
            return -1;
        int t = sum / n; //可除尽时，使用t表示每台洗衣机应放的数量。
        int ls = 0, rs = sum;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // right不包含i，先减去
            rs -= machines[i];
            // i向左边运送的数量
            int a = Math.max(t * i - ls, 0);
            // i向右边运送的数量
            int b = Math.max((n - i - 1) * t - rs, 0);
            //最小移动次数为 所有机器的「最小运输衣服数量」中的最大值
            res = Math.max(res, a + b);
            // i移动到i+1，left要加上machines[i]
            ls += machines[i];
        }
        return res;
    }
}
