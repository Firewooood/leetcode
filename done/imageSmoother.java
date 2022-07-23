package done;

class imageSmoother {
    public static void main(String[] args) {
        imageSmoother i = new imageSmoother();
        int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
        int[][] res = i.imageSmoother1(img);
    }
    public int[][] imageSmoother1(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int [m][n];
        // 矩形最外层
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = getAva(i, j, img);
            }
        }
        return res;
    }

    int getAva(int i, int j, int[][] img) {
        int m = img.length, n = img[0].length;
        int sum = 0, count = 0;
        int[] dx = { -1, 0, 1 };
        int[] dy = { -1, 0, 1 };
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (i + dx[x] < 0 || i + dx[x] >= m || j + dy[y] < 0 || j + dy[y] >= n) {
                    continue;
                } else {
                    sum += img[i + dx[x]][j + dy[y]];
                    count++;
                }
            }
        }
        return sum / count;
    }
}
