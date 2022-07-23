package done;

public class isStraight {
    public static void main(String[] args) {
        isStraight s1 = new isStraight();
        int[] nums = { 4,1,6,0,9};
        System.out.println(s1.isStraight1(nums));
    }
    
    public boolean isStraight1(int[] nums) {
        // 只需将nums数组排序。
        // 若nums数组中有非0 的重复数，则不是顺子
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                if (nums[i] == nums[j] && nums[i] != 0)
                    return false;
            }
        }
        //此时已排好序，且数组中无0之外的重复数
        if (nums[4] == 0)
            return true;//数组全0时，为顺子
        int i = 0;
        while (nums[i] == 0)i++;
        if (nums[4] - nums[i] <= 4)
            return true;
        // 若最大值和最小值的差值大于0的个数，则不为顺子// 若不包含0
            for (int j = i; j < 4; j++)
                if (nums[j+1] != nums[j] + 1)
                    return false;
        
        return true;
    }
}
