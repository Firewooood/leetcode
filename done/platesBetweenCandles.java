package done;

public class platesBetweenCandles {
    public static void main(String[] args) {
        platesBetweenCandles p1 = new platesBetweenCandles();
        String s = "|||||*|||*|||*||||*||||**|*|||**|**||**|||*|||*||***||*|*||";
        int[][] queries = { {1,55} };

        int[] res = p1.plate1(s, queries);
        for(int x:res)
            System.out.println(x);
    }

    public int[] plate1(String s, int[][] queries) {
        int n = queries.length;
        int m = s.length();
        int num = 0;
        int[] res = new int[n];
        int[] nums = new int[m];
        int[] plate_l = new int[m]; //当前盘子左边的蜡烛
        int[] plate_r = new int[m]; //当前盘子右边的蜡烛
        //记录从最左边到当前位置盘子的数量
        for (int i = 0; i < m; i++) {
            if (i != 0 && s.charAt(i) == '|') {
                nums[i] = nums[i - 1];
            }
            if (s.charAt(i) == '*') {
                nums[i] = ++num;
            }
        }
        num = -1;//使用num表示盘子左边第一个蜡烛的下标
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '*')
                plate_l[i] = num;
            if (s.charAt(i) == '|') {
                plate_l[i] = i;
                num = i;
            }
        }
        num = m;// 使用num表示盘子右边第一个蜡烛的下标
        for (int i = m - 1; i >= 0; i--) {
            if (s.charAt(i) == '*')
                plate_r[i] = num;
            if (s.charAt(i) == '|') {
                plate_r[i] = i;
                num = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int right = plate_r[queries[i][0]];//找出左边盘子右边蜡烛的下标
            int left = plate_l[queries[i][1]];//找出右边盘子左边蜡烛的下标
            if (right >= left || right == m || left == -1)
                res[i] = 0;
            else {
                res[i] = nums[left] - nums[right] ;
            }
        }
        return res;
    }
}
