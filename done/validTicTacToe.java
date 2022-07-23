package done;

public class validTicTacToe {
    public static void main(String[] args) {
        validTicTacToe v1 = new validTicTacToe();
        String[] board = { "XOX", "O O", "XOX" };
        System.out.println(v1.validTicTacToe1(board));
    }

/**
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。
 * 字符 ' ' 代表一个空位。
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 
 * @param board
 *              * board.length == 3
 *              board[i].length == 3
 *              board[i][j] 为 'X'、'O' 或 ' '
 * @return
 * 当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 */
    public boolean validTicTacToe1(String[] board) {
        /**
         * 1）X和O的数量，要么相等，要么X比O多1个；
         * 2）X和O同时满，不可能出现；
         * 3）O满，导致游戏结束，此时X和O的数量必然相等；
         * 4）X满，导致游戏结束，此时X的数量必然比O多一个；
         */
        int x = 0, y = 0;
        boolean isX = false, isO = false;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X')
                    x++;
                else if (c == 'O')
                    y++;
            }
        }
        isX = win(board, 'X');
        isO = win(board, 'O');
        // x赢
        if (isX) {
            return x - y == 1;
        }
        // o赢
        if (isO) {
            return x == y;
        }
        return x - y >= 0 && x - y <= 1;
    }

    private boolean win(String[] board, char c) {
        //中间
        if (board[1].charAt(1) == c) {
            //包含中间的四种情况
            return (board[0].charAt(0) == board[2].charAt(2) && board[0].charAt(0) == c)
                    || (board[0].charAt(2) == board[2].charAt(0) && board[0].charAt(2) == c)
                    || (board[0].charAt(1) == board[2].charAt(1) && board[0].charAt(1) == c)
                    || (board[1].charAt(0) == board[1].charAt(2) && board[1].charAt(0) == c);
        }
        //左上角
        if (board[0].charAt(0) == c) {
            //包含左上两种
            return (board[0].charAt(1) == board[0].charAt(2) && board[0].charAt(1) == c) ||
                    (board[1].charAt(0) == board[2].charAt(0) && board[1].charAt(0) == c);
        }
        if (board[2].charAt(2) == c) {
            // 包含右下两种
            return (board[1].charAt(2) == board[0].charAt(2) && board[1].charAt(2) == c) ||
                    (board[2].charAt(0) == board[2].charAt(1) && board[2].charAt(0) == c);
        }
        return false;
    }
}
