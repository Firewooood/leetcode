package done;
public class spiralOrder {
    public static void main(String[] args) {
        spiralOrder s1 = new spiralOrder();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int[] res = s1.function(matrix);
        for(int r:res)System.out.println(r);
    }


    public int[] function(int[][] matrix) {
        int n = matrix.length;
        if (n == 0)
            return new int[0];
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int[][] move = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };//分别记录下标可能的变换情况。
        int i = 0, j = 0, count = 0, mode = 0;  //使用mode表示向那个方向move
        // boolean[][] flag = new boolean[n][m]; //使用flag数组，标识当前元素是否被访问过。
        int mini = 0, maxi = n - 1, minj = 0, maxj = m - 1;
        while(count < m*n){  //当元素未被访问过时。
            res[count++] = matrix[i][j];
            //if (i + move[mode][0] >= n || i + move[mode][0] < 0 || j + move[mode][1] >= m || j + move[mode][1] < 0) //若当前元素要越界
            if ( j + move[mode][1] > maxj) {//若当前走到了最右侧
                mode = (mode + 1) % 4;
                mini += 1;
            }
            else if ( i + move[mode][0] > maxi) {// 若当前走到了最下侧
                mode = (mode + 1) % 4;
                maxj -= 1;
            }
            else if ( j + move[mode][1] < minj) {// 若当前走到了最左侧
                mode = (mode + 1) % 4;
                maxi -= 1;
            }
            else if ( i + move[mode][0] < mini) {// 若当前走到了最上侧
                mode = (mode + 1) % 4;
                minj += 1;
            }    
            i += move[mode][0];
            j += move[mode][1];
        }
        return res;
    }
}
