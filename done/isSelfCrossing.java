package done;

public class isSelfCrossing {
    public static void main(String[] args) {
        int[] tmp = { 2, 1, 1, 2 };
        System.out.println(f1(tmp));
    }

    /*
     * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，
     * 向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。
     * 也就是说，每次移动后你的方位会发生逆时针变化。
     * 
     * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
     */

    public static boolean f1(int[] d) {
        /*
         * 显然至少需要4条边才可能存在相交的路径。
         */
        int n = d.length;
        if (n < 4)
            return false;
        for (int i = 3; i < n; i++) {
            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3])
                return true;
            // d[i]和d[i-3]相交
            if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2])
                return true;
            // d[i]和d[i-4]相交
            if (i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i] + d[i - 4] >= d[i - 2]
                    && d[i - 1] + d[i - 5] >= d[i - 3])
                return true;
            // d[i]和d[i-5]相交
        }
        return false;
    }
}
