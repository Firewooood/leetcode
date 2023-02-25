class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length]; // 定义两个数组，分别记录i左右的全部值
        left[0] = 1;
        right[nums.length - 1] = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left[i] = left[i - 1] * nums[i - 1];
                right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, 1, 0, -3, 3};
        ProductExceptSelf p1 = new ProductExceptSelf();
        int[] res = p1.productExceptSelf(nums);
    }
}