public class searchMatrix {
    public boolean f2(int[][] matrix, int target) {
        //从右上角看是一棵二叉搜索树
        int m = matrix.length;
        int n = matrix[0].length;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (matrix[j][i] == target)
                return true;
            else if (matrix[j][i] > target) {
                i--;
            } else if (matrix[j][i] < target)
                j++;

        }
        return false;
    }
    
    public static void main(String[] args) {
        searchMatrix s = new searchMatrix();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target =25;
        System.out.println(s.f2(matrix, target));

    }
}
