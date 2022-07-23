package done;
public class test {
    public static void main(String[] args) {
        test test = new test();
        int[][] nums = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        System.out.println(test.findNumberIn2DArray(nums, 20));
    }
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        int mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (nums[mid] != mid) {
                // 若不等，则说明在前半部分缺一数字
                h = mid - 1;
                if (h < 0)
                    return 0;
            } else {
                // 若等，则在后半部分缺一数字
                l = mid + 1;
                if (l >= n)
                    return l;
            }
        }
        return l;
    }

    public int search(int[] nums, int target) {
        // nums是非递减数组，则可以使用二分检索找到target的位置，再向前后推，得到出现的次数
        int l = 0, h = nums.length - 1;
        boolean flag = true;
        int mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;
            if (nums[mid] == target) {
                flag = false;
                break;
            }
            if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        if (flag)
            return 0;
        int i = 0, j = 0, num = 0;
        for (i = mid, j = mid;;) {
            if (i >= 0 && nums[i] == target) {
                i--;
                num++;
            }

            if (j < nums.length && nums[j] == target) {
                j++;
                num++;
            }

            if ((i < 0 || nums[i] != target) && (j >= nums.length || nums[j] != target))
                break;
        }
        return num - 1;
    }
    
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;
        for (int i = n - 1, j = 0; i >= 0 && j < m;) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] < target)
                j++;
            if (matrix[i][j] > target)
                i--;
        }
        return false;
    }
    
    public void function() {
        
    }
}
