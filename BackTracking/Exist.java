package BackTracking;

public class Exist {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        // 找到word 的首字母，对其进行回溯
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j] = true;
                     res = res || trackbacking(board, word, i, j, 0, used);
                }
            }
        }
        return res;
    }

    public boolean trackbacking(char[][] board, String word, int row, int col, int n, boolean[][] used) { // row col
        if (n == word.length() - 1 && board[row][col] == word.charAt(n))
            return true;                                                                             // 表示现在遍历到的行列值，n表示当前需匹配的word字符
        if (board[row][col] != word.charAt(n)) {
            return false;
        }

        used[row][col] = true;
        boolean up = false, down = false, right = false, left = false;
        if (row + 1 < board.length && !used[row+1][col]) {
            up = trackbacking(board, word, row + 1, col, n + 1, used);
        }
        if (row - 1 >= 0&&!used[row-1][col]) {
            down = trackbacking(board, word, row - 1, col, n + 1, used);
        }
        if (col + 1 < board[0].length&&!used[row][col+1]) {
            right = trackbacking(board, word, row, col + 1, n + 1, used);
        }
        if (col - 1 >= 0 && !used[row][col - 1]) {
            left = trackbacking(board, word, row, col - 1, n + 1, used);
        }
        used[row][col] = false;
        return up || down || right || left;
    }

    public static void main(String[] args) {
        // char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCESEEEFS";
        Exist e1 = new Exist();
        System.out.println(e1.exist(board, word));
    }
}