package done;

public class maxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        int[][] grid = {
                { 3, 0, 8, 4 },
                { 2, 4, 5, 7 },
                { 9, 2, 6, 3 },
                { 0, 3, 1, 0 } };
        //从数组竖直方向(顶部、底部)看天际线是{9,4,8,7}，即每一列的最大值
        //从数组水平方向(左侧、右侧)看，天际线是{8,7,9,3}，即每一行的最大值
        maxIncreaseKeepingSkyline m1 = new maxIncreaseKeepingSkyline();
        System.out.println(m1.max1(grid));
    }
    
    /**已知数组grid，表示某矩阵面积内的建筑物高度，要求对建筑物进行增高，但不对城市天际线造成变化
     * 即不影响上述每一列每一行的最大值，
     * 求建筑物可以增加的最大高度之和
     * 
     * @param grid
     * @return 建筑物高度可以增加的最大值
     */
    public int max1(int[][] grid) {
        int col_num = grid[0].length;
        int row_num = grid.length;
        int[] col = new int[col_num];//记录各列的最大值
        int[] row = new int[row_num];//记录各行的最大值
        //上述数组的初始值均为0
        int res = 0;
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                col[j] = Math.max(col[j], grid[i][j]);
                row[i] = Math.max(row[i], grid[i][j]);
            }
        }
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                res += Math.min(col[j], row[i]) - grid[i][j];
            }
        }
        return res;
    }
}
