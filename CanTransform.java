import javax.security.auth.x500.X500Principal;

public class CanTransform {
    /**
     * 字符串由X L R组成，一个移动操作LX 替换 XL， 用XR 替换 RX
     * 编写代码，使得存在移动操作使得start 可以转换为 end 时，返回 true
     * 
     * @param start RXXLRXRXL
     * @param end   XRLXXRRLX
     * 
     *              RXXLRXRXL ->
     *              XRXLRXRXL ->
     *              XRLXRXRXL ->
     *              XRLXXRRXL ->
     *              XRLXXRRLX
     * @return
     */
    public boolean canTransform(String start, String end) {
        // 1. 去除X后，RL组成的字符串应该相等
        // 2. Start中R左边的X应该比 end中R左边的少，R只会向右移动
        // 3. Start中L左边的X应该比 endL左边的多， L只会向左移动
        int i = 0, j = 0, n = start.length();
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        while (i < n || j < n) {
            while (i < n && s[i] == 'X')
                i++;
            while (j < n && e[j] == 'X')
                j++;
            if (i == n && j == n)
                return true;
            if ((i == n || j == n) || s[i] != e[j] || (s[i] == 'L' && i < j) || (s[i] == 'R' && i > j))
                return false;
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        CanTransform c1 = new CanTransform();
        System.out.println(c1.canTransform(start, end));
    }

}
