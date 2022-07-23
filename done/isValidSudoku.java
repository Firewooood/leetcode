package done;
public class isValidSudoku {
    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println(isValidSudoku1(board));
    }

    //小方块编号和行列的关系：n = ⌊i/3⌋*3 + ⌊j/3⌋
    public static boolean isValidSudoku1(char[][] board) {
        //设置三个状态数组，判断是否有数重复出现。
        boolean [][]row = new boolean[10][10],col=new boolean[10][10],area = new boolean[10][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int c = board[i][j];
                if(c=='.')continue;
                int u = c - '0';//获取字符数组board中的数值。
                int n = i/3*3+j/3;//判断当前在哪一个方格
                if(row[i][u]||col[j][u]||area[n][u])return false;
                row[i][u] = col[j][u] = area[n][u] = true;
                //使用n将小方格相互隔开。
            }
        }
        return true;
    }
}
