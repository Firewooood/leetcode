package LinkedList;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int right = n - 1, left = 0, up = 0, down = n - 1;
        int cur = 1, i = 0, j = 0;
        if (n == 1) {
            res[0][0] = 1;
            return res;
        }
        while (cur < n * n) {
            // 1. 首先向右走
            while (i == up && j <= right) {
                res[i][j] = cur;
                if (j == right) {
                    up++;
                    break;
                } // 走完了上层，up向下移动
                cur++;
                j++; // 向右移动
            }

            // 2. 向下走
            while (i <= down && j == right) {
                res[i][j] = cur;
                if (i == down) {
                    right--; // 走完了右层，right向左移动
                    break;
                }
                cur++;
                i++; // 向下移动
            }
            // 3. 向左走
            while (i == down && j >= left) {
                res[i][j] = cur;
                if (j == left) {
                    down--; // 走完了下层，up向上移动
                    break;
                }
                cur++;
                j--; // 向左移动
            }
            // 4. 向上走
            while (i >= up && j == left) {
                res[i][j] = cur;
                if (i == up) {
                    left++; // 走完了左层，left向右移动
                    break;
                }
                cur++;
                i--; // 向上移动
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix g1 = new GenerateMatrix();
        int n = 11;
        int[][] res = g1.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
