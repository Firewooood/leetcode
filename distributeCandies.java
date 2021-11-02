import java.util.HashSet;
import java.util.Set;

public class distributeCandies {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 3 };
        distributeCandies d1 = new distributeCandies();
        System.out.println(d1.distributeCandies1(nums));
        
    }
    
    /**
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
     * 每一个数字代表一个糖果。
     * 你需要把这些糖果平均分给一个弟弟和一个妹妹。
     * 返回妹妹可以获得的最大糖果的种类数
     * @param nums
     * @return
     */

    public int distributeCandies1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        /*若所有糖都不重样，妹妹也只能得到一半种类的，*/
        if (set.size() > nums.length / 2)
            return nums.length / 2;
        else
            return set.size();
    }
}
