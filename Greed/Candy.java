package Greed;

public class Candy {
    public int candy(int[] ratings) {
        int res = 0, len = ratings.length;
        // 遍历rating数组，得到评分最小的孩子的下标
        int min = Integer.MAX_VALUE, mini = -1;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            if (ratings[i] < min) {
                min = ratings[i];
                mini = i;
            }
        }
        nums[mini] = 1;
        // 从最小评分向左右扩展
        // 向左扩展
        for (int i = mini; i >= 1; i--) {
            if (i - 1 >= 0 && ratings[i - 1] > ratings[i]) {
                nums[i - 1] = nums[i] + 1;
            } else if (ratings[i - 1] <= ratings[i]) {
                nums[i - 1] = 1;
            }
        }
        for (int i = mini; i < len - 1; i++) {
            if (i + 1 < len && ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            } else if (ratings[i + 1] <= ratings[i]) {
                nums[i + 1] = 1;
            }
        }
        for (int x : nums) {
            res += x;
        }
        return res;
    }

    public static void main(String[] args) {
        Candy c1 = new Candy();
        int[] ratings = { 1, 3, 2, 2, 1 };
        System.out.println(c1.candy(ratings));
    }
}
