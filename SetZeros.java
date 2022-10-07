import java.util.HashSet;
import java.util.Set;

public class SetZeros {
    /**
     * 若 M * N 矩阵中某个元素为0，则将其所在行列清零
     * 
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();

        // 将为0元素的 行列值加入集合
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (iSet.contains(i) || jSet.contains(j)) {
                    matrix[i][j] = 0;
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        SetZeros s1 = new SetZeros();
        s1.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
