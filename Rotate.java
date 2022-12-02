public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //
                temp[j][n - i - 1] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    public static void main(String[] args) {
        Rotate r1 = new Rotate();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        r1.rotate(matrix);
    }
}
