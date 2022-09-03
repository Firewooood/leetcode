package done;

public class minMove {
    // 每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
    public int minMoves(int[] nums) {
        int res = 0;
        int min = 2147483647;
        for (int x : nums) {
            if (x < min)
                min = x;
        }
        for (int x : nums) {
            res += x - min;
        }
        return res;
    }

    public static void main(String[] args) {
        minMove m = new minMove();
        int[] nums = { 1, 2, 3 };
        System.out.println(m.minMoves(nums));
    }
}
