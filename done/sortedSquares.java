package done;

public class sortedSquares {
    public int[] sortedSquares1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // 若nums数组的第一个数不小于0，则直接返回nums的平方
        if (nums[0] >= 0) {
            for (int i = 0; i < len; i++) {
                res[i] = nums[i] * nums[i];
            }
            return res;
        } else if (nums[len - 1] <= 0) { // 全为负数的情况
            for (int i = 0; i < len; i++) {
                res[i] = nums[len - i - 1] * nums[len - i - 1];
            }
            return res;
        } else { // 该情况 nums 范围为整数
            int i = 0, j = 0, k = 0;
            while (k < len) {
                while (j < len && nums[j] < 0) {
                    j++; // 使用i记录第一个不小于0的数的位置
                    i = j - 1;
                }
                int cur = j >= len ? Integer.MAX_VALUE : nums[j] * nums[j];
                int tmp = i >= 0 ? nums[i] * nums[i] : Integer.MAX_VALUE;
                if (cur < tmp || i < 0) {
                    res[k++] = cur;
                    j++;
                } else {
                    res[k++] = tmp;
                    i--;
                }
            }

        }
        return res;

    }

    public static void main(String[] args) {
        sortedSquares s1 = new sortedSquares();
        int[] nums = { -4, -1, 0, 3, 1 };
        int[] res = s1.sortedSquares1(nums);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
